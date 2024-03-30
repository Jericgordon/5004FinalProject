public class Mountain implements Terrain{
  int speedCost = 2;
  char symbol = '^';

  public int getSpeedCost() {
    return speedCost;
  }

  public String getSymbol() {
    return String.valueOf(symbol);
  }
}
