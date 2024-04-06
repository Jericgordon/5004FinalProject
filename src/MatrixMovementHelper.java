import java.util.ArrayList;

public class MatrixMovementHelper {

  /**
   * This helper function is meant to provide a list of nodes a certain distance away from node (x,y)
   * without factoring in terrain.
   *
   * Think about this as a wizard casting a spell with an origin, and getting back a list of the
   * squares int speed distance away. The algorithm used is explained in the documentation for
   * ignoreTerrainValidMovesHelper
   *
   * @param matrix - the board at the current state
   * @param coordX - x coordinate of the character; expecting that this is cartesian, not an index
   * @param coordY - y coordinate of the character; expecting that this is cartesian, not an index
   * @param speed - the amount of orthogonal moves away from a space
   * @return return an arraylist of nodes which satisfy the above conditions
   */
  public static ArrayList<Space> validMovesIgnoreTerrain(Space[][] matrix,int coordX,int coordY,int speed){
    int x = coordX -1;//convert coordinates to index
    int y = coordY -1;

    //create new Arraylist to return
    ArrayList<Space> returnList = new ArrayList<>();
    return ignoreTerrainMovementHelper(matrix,returnList,x,y,speed);
  }

  public static ArrayList<Space>validMovesCheckTerrain
      (Space[][] matrix,int coordX,int coordY,int speed){
    int x = coordX -1;//convert coordinates to index
    int y = coordY -1;

    //create new Arraylist to return
    ArrayList<Space> returnList = new ArrayList<>();
    returnList.add(matrix[x][y]);
    return MatrixMovementHelper.validMovesCheckTerrainHelper(returnList,matrix,x,y,speed);
  }

  private static ArrayList<Space>validMovesCheckTerrainHelper
      (ArrayList<Space> returnArray, Space[][] matrix,int x,int y,int speed) {
    //we use the recursion helper to abstract out the operations slightly.
    if (speed > 0){
      MatrixMovementHelper.validMovesCheckTerrainRecursionHelper
          (returnArray, matrix, x + 1, y, speed); //check & recurse east
      MatrixMovementHelper.validMovesCheckTerrainRecursionHelper
        (returnArray, matrix, x, y - 1, speed); //check & recurse south
      MatrixMovementHelper.validMovesCheckTerrainRecursionHelper
        (returnArray, matrix, x - 1, y, speed); //check & recurse west
      MatrixMovementHelper.validMovesCheckTerrainRecursionHelper
        (returnArray, matrix, x, y + 1, speed); //check & recurse north
    }
    return returnArray;

  }

  private static void validMovesCheckTerrainRecursionHelper
      (ArrayList<Space> returnArray, Space[][] matrix,int x,int y,int speed) {
    //check that xy are inbounds
    if (MatrixMovementHelper.checkInBounds(matrix,(x),y)){
      //Check that there is enough speed to get there
      if (MatrixMovementHelper.checkSpeed(matrix[x][y], speed)) {
        speed -= matrix[x][y].getSpeedCost(); //set the current speed to the cost of moving there
        MatrixMovementHelper.conditionalAdder(returnArray, matrix[x][y]);
        MatrixMovementHelper.validMovesCheckTerrainHelper(returnArray, matrix, x, y, speed);
      }
    }
  }
  /**
   * Much work has gone into making this code readable. I'm of the option that further abstraction
   * would deteriorate readability. We essentially flower out from a space, and call the helper
   * method recursively as long as we have speed left. A quick visual has been made below with
   * a * as the active space. and o as the origin and c for checked WITHOUT the recursive call
   *
   * [][][]      [][][]      [][][]       [][*][]
   * [][o][*] -> [][o][c] -> [*][o][c] -> [c][][c]
   * [][][]      [][*][]     [][c][]      [][c][c]
   *
   * with the recursive call it would look like
   *
   * [][][]      [][][]      [][][]      [][][]
   * [][o][*] -> [][o][c] -> [][o][c] -> [][o][c]
   * [][][]      [][][]     [][*][c]    [*][c][c]
   *
   * @param matrix - the board at the current state
   * @param returnArray - the array assembled so far
   * @param x - x index of origin
   * @param y - y index of origin
   * @param speed - the amount of orthogonal moves away from a space
   */
  private static ArrayList<Space> ignoreTerrainMovementHelper
    (Space[][] matrix, ArrayList<Space> returnArray,int x,int y, int speed) {
    MatrixMovementHelper.conditionalAdder(returnArray,matrix[x][y]); //Add this to the array
    if (speed > 0){
      //Add node to the east, and call this method on it
      if (MatrixMovementHelper.checkInBounds(matrix,(x+1),y)) {
        MatrixMovementHelper.conditionalAdder(returnArray, matrix[x + 1][y]);
        MatrixMovementHelper.ignoreTerrainMovementHelper(matrix, returnArray, (x + 1), y, speed - 1);
      }
      //Add node to the south, and call this method on it
      if (MatrixMovementHelper.checkInBounds(matrix,(x),y-1)) {
        MatrixMovementHelper.conditionalAdder(returnArray, matrix[x][y-1]);
        MatrixMovementHelper.ignoreTerrainMovementHelper(matrix, returnArray, (x), (y-1), speed - 1);
      }
      //Add node to the west, and call this method on it
      if (MatrixMovementHelper.checkInBounds(matrix,(x-1),y)) {
        MatrixMovementHelper.conditionalAdder(returnArray, matrix[x - 1][y]);
        MatrixMovementHelper.ignoreTerrainMovementHelper(matrix, returnArray, (x - 1), y, speed - 1);
      }
      //Add node to the north, and call this method on it
      if (MatrixMovementHelper.checkInBounds(matrix,(x),(y+1))) {
        MatrixMovementHelper.conditionalAdder(returnArray, matrix[x][y+1]);
        MatrixMovementHelper.ignoreTerrainMovementHelper(matrix, returnArray, (x), (y+1), speed - 1);
      }
    }
    return returnArray;
  }

  private static boolean checkSpeed(Space space,int speed){
    if ((speed -space.getSpeedCost()) >= 0){
      return true;
    }
    return false;
  }



  private static boolean checkInBounds(Space[][] matrix,int x, int y){
    if ((x >= 0) && (y >= 0) && (x < matrix.length) && (y < matrix[0].length)){
      return true;
    }
    return false;
  }

  private static void conditionalAdder(ArrayList<Space> returnArray,Space space){
      if(!(returnArray.contains(space))){
        returnArray.add(space);
      }
  }

}
