public class Board {
  private Space[][] map;
  public Board(Space[][] map) {
    this.map = map;
  }

  public void moveCharater(int fromX,int fromY,int toX,int toY){
  }

  public void addCharacter(Creature creature, int toX,int toY){
    map[toX-1][toY-1].addCharacter(creature);
  }
  @Override
  public String toString(){
    //The board is stored in Cartesian (x,y) coordinates. To convert that to a string, we have to
    //start at the top of the board, or the max y value, but keep going 0->max on the x value
    StringBuilder returnString = new StringBuilder(map.length*(map[0].length +1));
    for (int y = map[0].length -1;y>-1;y--){
      for (int x = 0;x< map.length;x++){
        returnString.append(map[x][y].getSymbol());
      }
      if (y!=0) { //do not append newline if at the last part.
        returnString.append("\n");
      }
    }
    return returnString.toString();
  }
}
