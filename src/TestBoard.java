import java.util.LinkedList;

public class TestBoard implements BoardSetTwoPlayer{

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
    return null;
  }

  @Override
  public LinkedList<Creature> getCreaturesP2() {
    return null;
  }
}
