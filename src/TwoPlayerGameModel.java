public class TwoPlayerGameModel implements GameModel {
  Board board;
  Player player1;
  Player player2;

  public TwoPlayerGameModel() {
  }
  public void createNewGame(Board b,String player1Name, String Player2Name){
    this.board = b;
    this.player1 = new Player(player1Name,b.getCreatureList());
  }

  public void moveCharacter(Character c,int x, int y) throws IllegalMovementError{
  }

  public void characterAttack(int x, int y){
  }

  public boolean isGameOver(){
    return true;
  }

}
