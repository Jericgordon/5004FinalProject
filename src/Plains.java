public class Plains implements Terrain{
  int speedCost = 1;
  char symbol = '-';
  public int getSpeedCost() {
    return 0;
  }

  @Override
  public String getSymbol(){
    return String.valueOf(symbol);
  }
}
