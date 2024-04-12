public interface GameModel {

  public void createNewGame(Board b,String player1Name, String Player2Name);
  public void moveCharacter(Character c, int x, int y) throws IllegalMovementError;
  public void characterAttack(int x, int y);
  public boolean isGameOver();
}
