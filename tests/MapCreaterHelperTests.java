import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
public class MapCreaterHelperTests {
  Board b;
  String[] StrMap;
  @Before
  public void setup(){
    String[] StrMap =
            {"-------",
            "-^-^^--",
            "-^-^-^-",
            "-------"};
  }

  @Test
  public void mapCreaterTest(){
    Space[][] spaceMap = MapCreaterHelper.stringToMap(StrMap);
    assertArrayEquals('-',spaceMap[0][0].getSymbol());
  }
}


