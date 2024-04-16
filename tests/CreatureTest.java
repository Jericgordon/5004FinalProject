import org.junit.Test;
import static org.junit.Assert.*;

public class CreatureTest {

  @Test
  public void creatureTest() {
    Goblin g1 = new Goblin(PlayerNumber.player1,"Alex");
    g1.setXY(1,1);
    Goblin g2 = new Goblin(PlayerNumber.player2,"Alex");
    g2.setXY(1,1);
    assertTrue(g1.equals(g2));
  }

  @Test
  public void takeDamage() {
    Goblin g1 = new Goblin(PlayerNumber.player1,"Alex");
    Creature g2 = g1.takeDamage(5);
    assertEquals(5,g1.getHitPoints());
    assertEquals(5,g2.getHitPoints());
  }
}
