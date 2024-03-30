public abstract class Creature {
  String name;
  CreatureType creatureType;
  char symbol;

  public Creature(String name, CreatureType creatureType, char symbol) {
    this.name = name;
    this.creatureType = creatureType;
    this.symbol = symbol;
  }

  public String getSymbol() {
    return String.valueOf(symbol);
  }
}
