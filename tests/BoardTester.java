import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
public class BoardTester {
  Board b;

  @Before
  public void setup(){
    String[] StrMap = new String[]
           {"^------",
            "---^^--",
            "-^-^^--",
            "-------"};
    Space[][] spaceMap = MapCreaterHelper.stringToBoardInput(StrMap);
    b = new Board(spaceMap);
  }

  @Test
  public void toStringTest(){
    assertEquals("^------\n---^^--\n-^-^^--\n-------",b.toString());
  }
}


