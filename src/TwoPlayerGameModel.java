import java.util.LinkedList;

public class TwoPlayerGameModel implements GameModel {
  private Board board;
  private Player player1;
  private Player player2;
  private PlayerNumber whoseTurnItIs;
  private int indexOfCreatureCurrentPlayerIsOn;


  public TwoPlayerGameModel() {
    whoseTurnItIs = PlayerNumber.player1;
    indexOfCreatureCurrentPlayerIsOn = 0;
  }

  public void currentCreatureAttack(int x, int y, int attackIndex) {

  }

  public int getXMaxCoord(){
    return board.getXCoordMax();
  }
  public int getYMaxCoord(){
    return board.getYCoordMax();
  }

  public String getBoardString(){
    return board.toString();
  }
  public String getCurrentPlayerName(){
    return currentPlayerObject().getName();
  }
  public String getCurrentCreatureInformation(){
    return getCreatureInformation(getCurrentCreature().getXCoord(), getCurrentCreature().getYCoord());
  }

  /**
   *
   * @return - the current creature object
   */
  private Creature getCurrentCreature(){
    return currentPlayerObject().getCreatures().get(indexOfCreatureCurrentPlayerIsOn);
  }

  public String getCreatureInformation(int xCoord,int yCoord){
    Creature c;
    try {
      c = board.getCreature(xCoord,yCoord);
      return c.toString();
    } catch (NullPointerException nullPointerException){
      return "No creature found on that square";
    } catch (IllegalArgumentException illegalArgumentException){
      return "Not a valid square";
    }

  }
  public void createNewGame(BoardSetTwoPlayer b,String player1Name, String Player2Name){
    //assign variables
    this.board = b.getBoard();
    this.player1 = new Player(player1Name,b.getCreaturesP1());
    this.player2 = new Player(Player2Name,b.getCreaturesP2());

    //put creatures on the board
    for (int index = 0; index < b.getCreaturesP1().size();index++){
      Creature c = b.getCreaturesP1().get(index);
      board.addCreature(c,c.getXCoord(),c.getYCoord());
    }
    for (int index = 0; index < b.getCreaturesP2().size();index++){
      Creature c = b.getCreaturesP2().get(index);
      board.addCreature(c,c.getXCoord(),c.getYCoord());
    }
  }

  /*
  A helper class for update creature for players that takes the global list of creatures on the
  board, and a player, and removes any creatures from the player's list that don't appear on the
  board.
   */
  private void updateCreaturesForPlayer
      (Player player,LinkedList<Creature> currentListOfCreatures){
    //queue creatures for removal so we don't change size of list during iteration
    LinkedList<Creature> toRemove = new LinkedList<>();
      for (int index = 0; index<player.getCreatures().size();index++){
      Creature creatureToEvaluate = player.getCreatures().get(index);
      if (!(currentListOfCreatures.contains(creatureToEvaluate))){
        toRemove.add(creatureToEvaluate);
      }
    }
    //actually remove those creatures that were queued up
    for (Creature creature : toRemove) {
      player.getCreatures().remove(creature);
    }
  }
  /* updates the current list of creatures for all players in the game.
   */

  public void nextTurn(){
    //update Player Number
    if (whoseTurnItIs == PlayerNumber.player1){
      this.whoseTurnItIs = PlayerNumber.player2;
    }
    else{
      whoseTurnItIs = PlayerNumber.player1;
    }
    // update Player's creature list
    this.updateCreaturesForPlayer(this.currentPlayerObject(),board.getCreatureList());
    //update creature index
    indexOfCreatureCurrentPlayerIsOn = 0;

  }

  private Player currentPlayerObject() throws IllegalStateException{
    if (this.whoseTurnItIs == PlayerNumber.player1){
      return player1;
    }
    if (this.whoseTurnItIs == PlayerNumber.player2){
      return player2;
    }
    throw new IllegalStateException("More than Two Players have been added without updating "
        + "this code block");
  }

  public boolean isThereANextCreatureInThisTurn(){
    return this.indexOfCreatureCurrentPlayerIsOn <
        this.currentPlayerObject().getCreatures().size();
  }
  public void moveCurrentCreature(int x, int y) throws IllegalMovementError{
    board.moveCreature(getCurrentCreature().getXCoord(),getCurrentCreature().getYCoord(),x,y);
    getCurrentCreature().setXY(x,y);
    indexOfCreatureCurrentPlayerIsOn++;
  }

  /**
   *
   * @param toXcoord
   * @param toYCoord
   * @throws NullPointerException - if null object is passed to it, this function will throw a null
   * pointer exception
   */
  public boolean canCurrentCreatureMove(int toXcoord,int toYCoord) throws NullPointerException{
    Creature c = getCurrentCreature();
    return board.creatureCanMove(c.getXCoord(),c.getYCoord(),toXcoord,toYCoord);
  }

  public void currentCreatureAttack(int x, int y){
  }

  public boolean isGameOver(){
    return (this.player1.hasNoCreatures() || this.player2.hasNoCreatures());
  }

}

