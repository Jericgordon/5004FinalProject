import java.util.HashMap;


/**
 * This class is built to transform a string map into a usable
 * spaces matrix.
 */
public class MapCreaterHelper {
  private final static HashMap<Character,Terrain> TERRAIN_OBJECT_GETTER = new HashMap<>();
  public MapCreaterHelper() {
    hashMapInitializer();
  }

  private static void hashMapInitializer(){ //add more items here as support is added for more terrain
    TERRAIN_OBJECT_GETTER.put('-',new Plains());
    TERRAIN_OBJECT_GETTER.put('^',new Mountain());
  }

  /**
   * This function assumes that the input of an array of strings, each string comprised of
   * characters that are valid display terrain types.
   *
   * we return a 2d array where array[x][y] are the cartesian coordinates of a space object.
   *
   * It should be noted that while the coordinates are not part of the Constructor for space, they
   * are essential for certain operations when we convert the 2d Array -> a graph for the movement
   * purposes. A wiser programmer would have found a way to pass them in as constructors, but I
   * could not find a way to pass them through without recreating the hashmap every time.
   *
   * So, while this is not best practice, it is the best solution I've found.
   *
   * @param OriginStringMap - a string array with every space an array
   *
   * @return 2d array of spaces.
   */

  public static Space[][] stringToBoardInput(String[] OriginStringMap){
    hashMapInitializer();
    Space[][] gameMap = new Space[OriginStringMap[0].length()][OriginStringMap.length]; //this creates the array that we will
    // finally export back
    for (int y = OriginStringMap.length -1;y> -1;y--){ //loops over the rows from Origin String map in reverse
      String strRow = OriginStringMap[y]; //sets the string we're about to decode
      Space[] returnSpaceRow = new Space[strRow.length()];
      for (int x = 0; x < (OriginStringMap[0].length()); x++) { //iterates over that string we're decoding
        char characterKey = strRow.charAt(x); //Isolate the character
        Space spaceToAdd = new Space(TERRAIN_OBJECT_GETTER.get(characterKey));//find the corresponding
        spaceToAdd.setXY(x + 1,(OriginStringMap.length) - y);
        //cartesian coordinates onto the space

        //While the original array needs to be read
        //backwards, we want Cartesian coordinates to makes sense. That means counting up instead of
        //down. This conversion means the index will go 0,1... (OriginStringMap.length -1)
        gameMap[x][(OriginStringMap.length -1) - y] = spaceToAdd;
      }
    }
    return gameMap;
    }
}



