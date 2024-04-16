import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Function;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AttackTest {
  Creature c1 = new Goblin(PlayerNumber.player1,"Brennan");
  Creature c2 = new Goblin(PlayerNumber.player2,"Sam");

  @Test
  public void Attacks() {
   IAttack a =  c1.getAttack(0);
   c2 = a.attack(c2);
    assertEquals(5,c2.getHitPoints());
  }

  @Test
  public void AttackFunctions() {
    Function <Creature,Creature> attk = (c)-> c.takeDamage(5);
    Creature c1 = new Goblin(PlayerNumber.player1,"Tim");
    Creature c2 = attk.apply(c1);

    assertEquals(5,c1.getHitPoints());
    assertEquals(5,c2.getHitPoints());

    IAttack  attkTwo = new MeleAttack(5);

    attkTwo.attack(c2);
    assertEquals(0,c2.getHitPoints());


  }
}
