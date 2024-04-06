//Setup for a two player game right now
public class TwoPlayerGame {
  Player p1;
  Player p2;
  Board b;

  public TwoPlayerGame(BoardSetTwoPlayer boardSet){
    p1 = new HumanPlayer("Human1",boardSet.getCreaturesP1());
    p2 = new HumanPlayer("Human2",boardSet.getCreaturesP2());
    b = boardSet.getBoard();
  }

  public void runGame(){
    while ((!(p1.isGameOver())) && (!(p2.isGameOver())) ){
      b = p1.takeTurn(b);
      b = p2.takeTurn(b);
    }
  }
}
