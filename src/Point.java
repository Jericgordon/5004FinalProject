public class Point {
  int indexX;
  int indexY;
  boolean limit;
  int maxX;
  int maxY;
  public Point(int indexX, int indexY) {
    this.indexX = indexX;
    this.indexY = indexY;
  }

  public void setIndexX(int indexX) throws IllegalArgumentException {
    if (limit){
      if (indexX > this.maxX){
        throw new IllegalArgumentException(String.format("X above limit. Current limit %d",maxX));
      }
    }
    this.indexX = indexX;
  }
  public void setIndexY(int indexY) {
    if (limit){
      if (indexY > this.maxY){
        throw new IllegalArgumentException(String.format("Y above limit. Current limit %d",maxY));
      }
    }
    this.indexY = indexY;
  }
  public void setMaximum(int x,int y){
    x = this.maxX;
    y = this.maxY;
    limit = true;
  }
}

