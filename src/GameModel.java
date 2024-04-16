public interface GameModel {

  public void createNewGame(BoardSetTwoPlayer b,String player1Name, String Player2Name);
  public String getCurrentPlayerName();
  public void moveCurrentCreature(int x, int y) throws IllegalMovementError;
  public void currentCreatureAttack(int x, int y,int attackIndex);
  public boolean canCurrentCreatureAttack(int x,int y, int attackIndex);
  public boolean isGameOver();
  public boolean isThereANextCreatureInThisTurn();
  public String getCreatureInformation(int x,int y);
  public String getCurrentCreatureInformation();
  public boolean isThereACreatureOnThisSquare(int xCoord,int yCoord);
  public int getXMaxCoord();
  public int getYMaxCoord();
  public boolean canCurrentCreatureMove(int toXcoord,int toYCoord) throws NullPointerException;
  public String getBoardString();
  public void nextTurn();
}
