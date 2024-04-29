import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

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

  public void setCreatures(LinkedList<Creature> creatures) {
    this.creatures = creatures;
  }

  public String getName() {
    return name;
  }

  public boolean hasNoCreatures(){
    return creatures.isEmpty();
  }
}
