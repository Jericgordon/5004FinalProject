import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardTest{
  Board b;
  Board smallBoard;

  TestCreature testCreature;

  @Before
  public void setup(){
    String[] StrMap = new String[]
           {"^------",
            "---^^--",
            "-^-^^--",
            "-------"};
    Space[][] spaceMap = MapCreaterHelper.stringToBoardInput(StrMap);
    b = new Board(spaceMap);

    String[] StrMapElectricBoogaloo = new String[]
        {"--^-^-",
         "--^-^-"};

    Space[][] spaceMap2 =MapCreaterHelper.stringToBoardInput(StrMapElectricBoogaloo);
    smallBoard =new Board(spaceMap2);
  }

  @Test
  public void toStringTest(){
    assertEquals("^------\n---^^--\n-^-^^--\n-------",b.toString());
  }

  @Test
  public void movementChecker(){
    testCreature = new TestCreature("Test1",CreatureType.Goblin,'T',4);
    assertTrue(smallBoard.creatureCanMove(testCreature,smallBoard[0][0],));

  }
}


