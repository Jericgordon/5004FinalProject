public abstract class Creature {
  String name;
  CreatureType creatureType;
  char symbol;
  int speed;

  public Creature(String name, CreatureType creatureType, char symbol,int speed) {
    this.name = name;
    this.creatureType = creatureType;
    this.symbol = symbol;
    this.setSpeed(speed);
  }

  public String getSymbol() {
    return String.valueOf(symbol);
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
}

