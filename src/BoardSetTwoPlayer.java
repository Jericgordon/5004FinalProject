import java.util.ArrayList;
import java.util.HashMap;

public interface BoardSetTwoPlayer {
  public Board getBoard();
  public HashMap<Creature,Point> getCreaturesP1();
  public HashMap<Creature,Point> getCreaturesP2();
}
