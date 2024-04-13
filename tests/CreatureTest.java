import org.junit.Test;
import static org.junit.Assert.*;

public class CreatureTest {

  @Test
  public void creatureTest() {
    Goblin g1 = new Goblin("Alex");
    g1.setXY(1,1);
    Goblin g2 = new Goblin("Alex");
    g2.setXY(1,1);
    assertTrue(g1.equals(g2));
  }
}
