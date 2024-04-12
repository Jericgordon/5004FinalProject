import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Board {
  private final Space[][] map; //This can be final as we'll replace the object
  public Board(Space[][] map) {
    this.map = map;
  }

  private Space getSpace(int coodX,int coodY){
    return map[coodX -1][coodY -1];
  }

  public LinkedList<Creature> getCreatureList(){
    LinkedList<Creature> creatures = new LinkedList<>();
    for (int indexX = 0;indexX < map.length; indexX++){
      for (int indexY = 0; indexY <map[0].length;indexY++){
        if (map[indexX][indexY].hasCreature()){
          Creature temp = map[indexX][indexY].getCreature();
          temp.setXY(indexX,indexY);
          creatures.add(temp);
        }
      }
    }
    return creatures;
  }
  public void moveCreature(int fromX,int fromY,int toX,int toY){
  }

  public void addCreature(Creature creature, int CoordX,int CoordY){
    map[CoordX-1][CoordY-1].addCharacter(creature);
  }
  public ArrayList<Space> getSpacesWithinDistance(int coordX,int coordY, int distance,boolean ignoreTerrain) {
    if (ignoreTerrain){
      return MatrixMovementHelper.validMovesIgnoreTerrain(this.map,coordX,coordY,distance);
    }
    return MatrixMovementHelper.validMovesCheckTerrain(this.map,coordX,coordY,distance);
  }



  public boolean creatureCanMove(int fromCoordX,int fromCoordY,int toCoordX,int toCoordY) {
    Creature creature = map[fromCoordX-1][fromCoordY-1].getCreature();
    if (creature == null){
      throw new CreatureNotFoundError("No creature found in this square");
    }
    return getSpacesWithinDistance
        (fromCoordX,fromCoordY,creature.getSpeed(),false)
        .contains(map[toCoordX-1][toCoordY-1]);
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
