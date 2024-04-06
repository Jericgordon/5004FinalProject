import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpaceTester {
  Space s;
  @Before
  public void setup(){
    s = new Space(new Mountain());

  }

  @Test
  public void terrainTest(){
    //test speed, Constructor
    assertEquals(2,s.getSpeedCost());
  }
  @Test
  public void creatureTestsTest(){
    //SymbolTests, AddCharacter
    assertEquals("^",s.getSymbol());
    Goblin g = new Goblin("Timothy");
    s.addCharacter(g);
    assertEquals("g",s.getSymbol());

    //getCharacter
    assertEquals(g,s.getCreature());

    //hasCharacter
    Space k = new Space(new Plains());
    assertTrue(s.hasCreature());
    assertFalse(k.hasCreature());

    //removeCharacter test
    s.removeCharacter();
    assertFalse(s.hasCreature());

  }
  @Test (expected = IllegalMovementError.class)
  public void badAddCharacter(){
    Goblin g = new Goblin("Timothy");
    s.addCharacter(g);
    s.addCharacter(g);
  }
}


