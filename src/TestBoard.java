import java.util.LinkedList;

public class TestBoard implements BoardSetTwoPlayer{
  public TestBoard(){
  }

  public Board getBoard() {
    String[] StrMap = new String[]
           {"^------",
            "---^^--",
            "-^-^^--",
            "-------"};
    Space[][] spaceMap = MapCreaterHelper.stringToBoardInput(StrMap);
    Board b = new Board(spaceMap);
    return b;
  }
  @Override
  public LinkedList<Creature> getCreaturesP1() {
    Goblin g = new Goblin(PlayerNumber.player1,"Timn");
    g.setXY(1,1);
    LinkedList<Creature> returnList = new LinkedList<>();
    returnList.add(g);
    return returnList;
  }

  @Override
  public LinkedList<Creature> getCreaturesP2() {
    Goblin g = new Goblin(PlayerNumber.player2,"Russel T. Davies");
    g.setXY(4,4);
    LinkedList<Creature> returnList = new LinkedList<>();
    returnList.add(g);
    return returnList;
  }

  public int getXMaxCoord() {
    return this.getBoard().getXCoordMax();
  }
  public int getYMaxCoord() {
    return this.getBoard().getYCoordMax();
  }
}
