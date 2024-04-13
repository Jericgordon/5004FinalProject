public class Point {
  private int indexX;
  private int indexY;
  private boolean limit;
  private int maxX;
  private int maxY;
  public Point(int CoordX, int CoordY) {
    this.indexX = CoordX;
    this.indexY = CoordY;
  }

  public void setXCoord(int indexX) throws IllegalArgumentException {
    if (limit){
      if (indexX > this.maxX){
        throw new IllegalArgumentException(String.format("X above limit. Current limit %d",maxX));
      }
    }
    this.indexX = indexX;
  }
  public void setYCoord(int indexY) {
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

  public int getXCoord() {
    return indexX;
  }

  public int getYCoord() {
    return indexY;
  }

  @Override
  public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if (!(o instanceof Point)){
      return false;
    }
    Point comparePoint = (Point) o;
    return ((this.getXCoord() == comparePoint.getXCoord()) &&
        (this.getYCoord() == this.getYCoord()));
  }
}

