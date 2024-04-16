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

    g = new Goblin(PlayerNumber.player1,"Timn");
    g.setXY(1,1);
    d = new Goblin(PlayerNumber.player2,"Russel T Davies");
    d.setXY(4,4);
  }

  @Test
  public void toStringTest(){
    assertEquals("^------\n---^^--\n-^-^^--\n-------",b.toString());
  }

  @Test
  public void movementChecker(){
    testCreature = new TestCreature(PlayerNumber.player1,"Test1",CreatureType.Goblin,'T',4,10);
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

  @Test
  public void canCurrentCreatureAttack() {
    assertTrue(b.canCreatureAttack(2,2,2,3,1));
    assertFalse(b.canCreatureAttack(2,2,2,4,1));
  }

  @Test
  public void ClearDead() {
    Creature c = new TestCreature(PlayerNumber.player1,"Alex",CreatureType.Goblin,'d',5,0);
    c.setXY(1,1);
    b.addCreature(c,1,1);
    b.clearDeadCreatures();

    assertEquals(0,b.getCreatureList().size());
  }
}


