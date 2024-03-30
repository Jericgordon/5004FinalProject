import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
public class MapCreaterHelperTests {
  Board b;
  String[] StrMap;
  @Before
  public void setup(){
    StrMap = new String[]
           {"^------",
            "---^^--",
            "-^-^^--",
            "-------"};
  }

  @Test
  public void mapCreaterTest(){
    //assertEquals("-------",StrMap[0]);
    Space[][] spaceMap = MapCreaterHelper.stringToBoardInput(StrMap);
    assertEquals("-",spaceMap[0][0].getSymbol());
    assertEquals("^",spaceMap[1][1].getSymbol());
    assertEquals("^",spaceMap[0][3].getSymbol());
    assertEquals("-",spaceMap[6][0].getSymbol());

    //test coordinate system in the spaces
    assertEquals(1, spaceMap[0][0].getyVal());
    assertEquals(3, spaceMap[3][2].getyVal());
  }
}


