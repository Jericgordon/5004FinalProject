import java.util.Objects;

public abstract class Creature {
  private static int globalID;
  private int id;
  String name;
  CreatureType creatureType;
  char symbol;
  int speed;
  Point point;

  public Creature(String name, CreatureType creatureType, char symbol,int speed) {
    this.name = name;
    this.creatureType = creatureType;
    this.symbol = symbol;
    this.setSpeed(speed);
    this.id = ++globalID;
  }
  public Creature(String name, CreatureType creatureType, char symbol,int speed,int x, int y) {
    this.name = name;
    this.creatureType = creatureType;
    this.symbol = symbol;
    this.setSpeed(speed);
    this.id = ++globalID;
    this.point = new Point(x,y);
  }


  public void setXY(int x, int y) {
    this.point = new Point(x,y);
  }

  public String getSymbol() {
    return String.valueOf(symbol);
  }

  public int getId() {
    return id;
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
  public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if (!(o instanceof Creature)){
      return false;
    }
    Creature compareCreature = (Creature) o;
    return (this.getId() == compareCreature.getId());
  }
  @Override
  public int hashCode(){
    return Objects.hashCode(id);


  }
}

