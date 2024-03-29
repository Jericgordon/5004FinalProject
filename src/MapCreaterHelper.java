import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.util.Collections.reverse;

/**
 * This class is built to transform a string map into a usable
 * spaces matrix.
 */
public class MapCreaterHelper {
  HashMap<Character,Terrain> terrainObjectGetter = new HashMap<>();
  public MapCreaterHelper() {
    hashMapInitializer();
  }

  private void hashMapInitializer(){ //add more items here as support is added for more terrain
    terrainObjectGetter.put('-',new Plains());
    terrainObjectGetter.put('^',new Mountain());
  }
  public Space[][] stringToMap(String[] stringMap){

    ArrayList<Space[]> gameMap = new ArrayList<>();
    for (String strRow:reverse(Arrays.asList(stringMap))){ //loops over the rows
      ArrayList<Space> spaceRow = new ArrayList<>();
      for (int i = 0; i < (strRow.length() - 1); i++) { //iterates over the index of every character
        char characterKey = strRow.charAt(i);
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



}
