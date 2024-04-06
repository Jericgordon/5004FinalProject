import java.util.ArrayList;
import java.util.HashMap;

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
  public HashMap<Creature,Point> getCreaturesP1() {
    return null;
  }

  @Override
  public HashMap<Creature,Point> getCreaturesP2() {
    return null;
  }
}
