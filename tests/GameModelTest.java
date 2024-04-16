import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameModelTest {

  /**
   *       {"^------",
   *        "---^^--",
   *        "-^-^^--",
   *        "-------"};
   */
  GameModel m;
  @Before
  public void setup(){
    m = new TwoPlayerGameModel();
    m.createNewGame(new TestBoard(),"a","b");
  }

  @Test
  public void createNewGameTest(){
    String board = m.getBoardString();
    m.nextTurn();
    assertEquals(board,m.getBoardString());
  }

  @Test
  public void maxCoordTest(){
    assertEquals(7,m.getXMaxCoord());
    assertEquals(4,m.getYMaxCoord());
  }
  @Test
  public void turnsTest() {
    assertEquals("a",m.getCurrentPlayerName());
    m.nextTurn();
    assertEquals("b",m.getCurrentPlayerName());
  }

  @Test
  public void getCreatureInfoTest() {
    Goblin g = new Goblin(PlayerNumber.player1,"Timn");
    g.setXY(1,1);
    assertEquals(g.toString(),m.getCreatureInformation(1,1));
  }

  @Test
  public void getCurrentCreatureTest() {
    Goblin g = new Goblin(PlayerNumber.player1,"Timn");
    g.setXY(1,1);

    Goblin d = new Goblin(PlayerNumber.player1,"Russel T Davies");
    d.setXY(4,4);

    assertEquals(g.toString(),m.getCreatureInformation(1,1));
    assertFalse(m.isGameOver());

    assertEquals(g.toString(),m.getCurrentCreatureInformation());

    assertFalse(m.isGameOver());
  }

  @Test
  public void MoveTest() {
    Goblin g = new Goblin(PlayerNumber.player1,"Timn");
    g.setXY(1,1);

    Goblin d = new Goblin(PlayerNumber.player2,"Russel T Davies");
    d.setXY(4,4);
    //move c1 -> 2,2
    m.moveCurrentCreature(2,2);
    m.nextTurn();

    //move c2 -> 2,3
    m.moveCurrentCreature(2,3);
    assertFalse(m.isGameOver());

    m.nextTurn();
    m.currentCreatureAttack(2,3,0);

    assertFalse(m.isGameOver());
    m.nextTurn();

    m.currentCreatureAttack(2,2,0);
    assertFalse(m.isGameOver());

    m.currentCreatureAttack(2,3,0);
    m.nextTurn();
    assertTrue(m.isGameOver());
  }
}
