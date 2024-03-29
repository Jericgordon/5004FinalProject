public class Mountain implements Terrain{
  int speedCost = 2;
  char symbol = '^';
  @Override
  public int getSpeedCost() {
    return 0;
  }

  public String getSymbol() {
    return String.valueOf(symbol);
  }
}
