import java.util.ArrayList;
import java.util.HashMap;


/**
 * This class is built to transform a string map into a usable
 * spaces matrix.
 */
public class MapCreaterHelper {
  private static HashMap<Character,Terrain> terrainObjectGetter = new HashMap<>();
  public MapCreaterHelper() {
    hashMapInitializer();
  }

  private static void hashMapInitializer(){ //add more items here as support is added for more terrain
    terrainObjectGetter.put('-',new Plains());
    terrainObjectGetter.put('^',new Mountain());
  }
  public static Space[][] stringToMap(String[] stringMap){

    ArrayList<Space[]> gameMap = new ArrayList<>();
    for (int i = stringMap.length -1;i> -1;i--){ //loops over the rows in reverse
      ArrayList<Space> spaceRow = new ArrayList<>();
      String strRow = stringMap[i];
      for (int i2 = 0; i2 < (strRow.length() - 1); i2++) { //iterates over the index of every character
        char characterKey = strRow.charAt(i2);
        Space spaceToAdd = new Space(terrainObjectGetter.get(characterKey));
        spaceRow.add(spaceToAdd);
      }
      //These typecasts are necessary because .toArray() produces an Object[]
      Space[] returnSpaceArray = (Space[]) spaceRow.toArray();
      gameMap.add(returnSpaceArray);
    }
    return (Space[][]) gameMap.toArray();
    }
  }



