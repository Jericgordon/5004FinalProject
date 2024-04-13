import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest{
  Board b;
  Board smallBoard;

  TestCreature testCreature;
  Goblin g;
  Goblin d;

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

    g = new Goblin("Timn");
    g.setXY(1,1);
    d = new Goblin("Russel T Davies");
    d.setXY(4,4);
  }

  @Test
  public void toStringTest(){
    assertEquals("^------\n---^^--\n-^-^^--\n-------",b.toString());
  }

  @Test
  public void movementChecker(){
    testCreature = new TestCreature("Test1",CreatureType.Goblin,'T',4);
    smallBoard.addCreature(testCreature,1,1);
    assertTrue(smallBoard.creatureCanMove(1,1,4,1));
    assertFalse(smallBoard.creatureCanMove(1,1,5,1));
  }

  @Test
  public void getCreaturesListTest() {
    b.addCreature(g,g.getXCoord(),g.getYCoord());
    b.addCreature(d,d.getXCoord(),d.getYCoord());

    LinkedList<Creature> currentList = new LinkedList<>();
    currentList = b.getCreatureList();
    assertTrue(currentList.contains(g));
    assertTrue(currentList.contains(d));
  }
}


