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
    Space[][] spaceMap = MapCreaterHelper.stringToMap(StrMap);
    assertEquals("-",spaceMap[0][0].getSymbol());
    assertEquals("^",spaceMap[1][1].getSymbol());
    assertEquals("^",spaceMap[0][3].getSymbol());
    assertEquals("-",spaceMap[6][0].getSymbol());
  }
}


