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
  public String toString(){
    return String.format("%s (Symbol) %s\nSpeed: %d\n Located at (%d,%d)" ,
        this.name,this.symbol,this.speed,this.getXCoord(),this.getYCoord());
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
        (this.point.equals(compareCreature.point))));
  }
  @Override
  public int hashCode(){
    return Objects.hashCode(id);
  }
}

