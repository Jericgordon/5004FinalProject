import java.util.LinkedList;
import java.util.Objects;
import javax.ws.rs.core.Link;
import org.jooq.Attachable;

public abstract class Creature {
  private String name;
  private final CreatureType creatureType;
  private char symbol;
  private int speed;
  private Point point;
  private int hitPoints;
  private PlayerNumber owner;
  private LinkedList<IAttack> attacks;

  public Creature(PlayerNumber owner, String name, CreatureType creatureType, char symbol,int speed, int hitPoints) {
    this.name = name;
    this.creatureType = creatureType;
    this.symbol = symbol;
    this.setSpeed(speed);
    this.hitPoints = hitPoints;
    attacks = new LinkedList<>();
    this.owner = owner;
  }
  public Creature(PlayerNumber owner, String name, CreatureType creatureType, char symbol,int speed, int hitPoints, int x, int y) {
    this.name = name;
    this.creatureType = creatureType;
    this.symbol = symbol;
    this.setSpeed(speed);
    this.point = new Point(x,y);
    this.hitPoints = hitPoints;
    attacks = new LinkedList<>();
    this.owner = owner;
  }

  public PlayerNumber getPlayerNumber() {
    return owner;
  }

  public Creature takeDamage(int damage){
    hitPoints -= damage;
    return this;
  }

  public void addAttack(IAttack attack){
    this.attacks.add(attack);
  }

  public IAttack getAttack(int index) throws IndexOutOfBoundsException{
    return attacks.get(index);
  }

  public void setXY(int x, int y) {
    this.point = new Point(x,y);
  }
  public int getXCoord(){
    return this.point.getXCoord();
  }
  public int getYCoord(){
    return this.point.getYCoord();
  }

  public String getSymbol() {
    return String.valueOf(symbol);
  }

  public String getName() {
    return name;
  }

  public int getHitPoints() {
    return hitPoints;
  }

  public void setSpeed(int speed) {
    if (speed < 0){
      this.speed = 0;
    }
    this.speed = speed;
  }

  public int getSpeed() {
    return speed;
  }

  @Override
  public String toString(){
    return String.format("%s (Symbol) %s\nSpeed: %d\nHealth: %d\n Located at (%d,%d)" ,
        this.name,this.symbol,this.speed,this.hitPoints,this.getXCoord(),this.getYCoord());
  }

  @Override
  public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if (!(o instanceof Creature)){
      return false;
    }
    Creature compareCreature = (Creature) o;
    return ((this.name == compareCreature.getName() &&
        this.speed == compareCreature.getSpeed()));
  }
  @Override
  public int hashCode(){
    return Objects.hashCode(this);
  }
}

