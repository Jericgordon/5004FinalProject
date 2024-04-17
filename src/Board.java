import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Board {
  private final Space[][] map; //This can be final as we'll replace the object
  public Board(Space[][] map) {
    this.map = map;
  }


  public int getXCoordMax(){
    return map.length;
  }
  public int getYCoordMax(){
    return map[0].length;
  }

  private Space getSpace(int coodX,int coodY){
    return map[coodX -1][coodY -1];
  }

  public LinkedList<Space> filter(Predicate<Space> p){
    LinkedList<Space> returnList = new LinkedList<>();
    for (int indexX = 0;indexX < map.length; indexX++){
      for (int indexY = 0; indexY <map[0].length;indexY++){
        if (p.test(map[indexX][indexY])){
          returnList.add(map[indexX][indexY]);
        }
      }
    }
    return returnList;
  }

  public <T> LinkedList<T> map(Function<Space,T> mapFunction,LinkedList<Space> toMap){
    LinkedList<T> returnList = new LinkedList<>();
    int index = 0;
    while (index < toMap.size()){
      returnList.add(mapFunction.apply(toMap.get(index++)));
    }
    return returnList;
  }

  public void clearDeadCreatures(){
    LinkedList<Creature> toRemove = getCreatureList();
    toRemove = toRemove.stream().filter((creature)->(creature.getHitPoints() <= 0)).collect(
        Collectors.toCollection(LinkedList::new));
    for (Creature c:toRemove){
      int xIndex = c.getXCoord() -1;
      int yIndex = c.getYCoord() -1;
      map[xIndex][yIndex].removeCreature();
    }
  }
  public boolean canCreatureAttack(int fromXCoord,int fromYCoord,int toXCoord,int toYCoord,int range){
    ArrayList<Space> validSpaces =
        MatrixMovementHelper.validMovesIgnoreTerrain(map,fromXCoord,fromYCoord,range);
    Space targetSpace = map[toXCoord-1][toYCoord-1];
    return validSpaces.contains(targetSpace);
  }

  public LinkedList<Creature> getCreatureList(){
    LinkedList<Creature> creatures = new LinkedList<>();
    creatures = this.map(((space) -> space.getCreature()),this.filter(Space::hasCreature));
    return creatures;
  }

  private void checkXYinput(int xCoord,int yCoord) throws IllegalArgumentException{
    if ((xCoord < 0) || (xCoord > getXCoordMax())){
      throw new IllegalArgumentException("Invalid X Coordinate");
    }
    if ((yCoord < 0) || (yCoord > getYCoordMax())){
      throw new IllegalArgumentException("Invalid Y Coordinate");
    }
  }



  public void moveCreature(int fromXCoord,int fromYCoord,int toXCoord,int toYCoord) throws IllegalArgumentException,IllegalMovementError,NullPointerException{
    //Check to see if these are valid inputs. Throws IllegalArgumentException if they are not
    checkXYinput(fromXCoord,fromYCoord);
    checkXYinput(toXCoord,toYCoord);

    //see if the character is there.
    //GetCreature throws NullPointerException if there isn't a character there to get
    Creature toMoveCreature = getAndRemoveCreature(fromXCoord,fromYCoord);

    //Get an Arraylist of all valid moves for that character.
    //this step allows 2 characters on the same space; that will be checked for later
    ArrayList<Space> validMovesArraylist = MatrixMovementHelper.validMovesCheckTerrain
        (map,toMoveCreature.getXCoord(),toMoveCreature.getYCoord(),toMoveCreature.getSpeed());

    //Check if the given creature can actually move there
    if (!validMovesArraylist.contains(map[toXCoord-1][toYCoord-1])){
      throw new IllegalMovementError("Given Character cannot move there");
    }
    //update the creature's location information
    toMoveCreature.setXY(toXCoord,toYCoord);

    //move the creature
    this.addCreature(toMoveCreature,toXCoord,toYCoord);
  }

  public boolean isThereACreatureOnThisSquare(int xCoord,int yCoord){
    return map[xCoord-1][yCoord-1].hasCreature();
  }

  public Creature getCreature(int xCoord, int yCoord) throws NullPointerException{
    checkXYinput(xCoord,yCoord);
    Creature c = map[xCoord -1][yCoord -1].getCreature();
    if (c == null){
      throw new NullPointerException("No creature found at this coordinate");
    }
    return c;
  }

  public Creature getAndRemoveCreature(int xCoord, int yCoord) throws NullPointerException{
    Creature c = getCreature(xCoord,yCoord); //throws null pointer if creature not there
    map[xCoord -1][yCoord -1].removeCreature();
    return c;
  }

  public void addCreature(Creature creature, int CoordX,int CoordY) throws DoublePlacementError{
    //A space is being asked to add the creature. If it has another creature already, it will throw
    //an error
    map[CoordX-1][CoordY-1].addCharacter(creature);
  }
  public ArrayList<Space> getSpacesWithinDistance(int coordX,int coordY, int distance,boolean ignoreTerrain) {
    if (ignoreTerrain){
      return MatrixMovementHelper.validMovesIgnoreTerrain(this.map,coordX,coordY,distance);
    }
    return MatrixMovementHelper.validMovesCheckTerrain(this.map,coordX,coordY,distance);
  }



  public boolean creatureCanMove(int fromCoordX,int fromCoordY,int toCoordX,int toCoordY) throws NullPointerException {
    Creature creature = map[fromCoordX-1][fromCoordY-1].getCreature();
    if (creature == null){
      throw new NullPointerException("No creature found in this square");
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
