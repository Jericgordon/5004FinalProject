public class Point {
  int x;
  int y;
  boolean limit;
  int maxX;
  int maxY;
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setX(int x) throws IllegalArgumentException {
    if (limit){
      if (x > this.maxX){
        throw new IllegalArgumentException(String.format("X above limit. Current limit %d",maxX));
      }
    }
    this.x = x;
  }
  public void setY(int y) {
    if (limit){
      if (y > this.maxY){
        throw new IllegalArgumentException(String.format("Y above limit. Current limit %d",maxY));
      }
    }
    this.y = y;
  }
  public void setMaximum(int x,int y){
    x = this.maxX;
    y = this.maxY;
    limit = true;
  }
}

