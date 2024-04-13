import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import org.jooq.util.derby.sys.Sys;

public class Player {
  private final String name;
  private LinkedList<Creature> creatures  = new LinkedList<>();


  public Player(String name,LinkedList<Creature> creatures) {
    this.creatures = creatures;
    this.name = name;
  }
  public LinkedList<Creature> getCreatures(){
    return this.creatures;
  }

  public String getName() {
    return name;
  }

  public boolean hasNoCreatures(){
    return creatures.isEmpty();
  }
}
