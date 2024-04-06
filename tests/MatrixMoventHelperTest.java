import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatrixMoventHelperTest {

  Space[][] largeSpaceMap;
  Space[][] smallSpaceMap;
  @Before
  public void setup(){
    String[] StrMap = new String[]
        {"^------",
            "---^^--",
            "-^-^^--",
            "-------"};
    largeSpaceMap = MapCreaterHelper.stringToBoardInput(StrMap);


    String[] StrMapElectricBoogaloo = new String[]
        {"--^-^-",
         "--^-^-"};

    smallSpaceMap =MapCreaterHelper.stringToBoardInput(StrMapElectricBoogaloo);
  }

  @Test
  public void movementChecker(){
    ArrayList<Space> answers = MatrixMovementHelper.
        validMovesIgnoreTerrain(smallSpaceMap,1,1,3);
    assertTrue(answers.contains(smallSpaceMap[0][0]));
    assertTrue(answers.contains(smallSpaceMap[1][0]));
    assertTrue(answers.contains(smallSpaceMap[2][0]));
    assertTrue(answers.contains(smallSpaceMap[1][1]));
    assertTrue(answers.contains(smallSpaceMap[0][1]));
    assertTrue(answers.contains(smallSpaceMap[2][1]));
    assertTrue(answers.contains(smallSpaceMap[3][0]));
    assertFalse(answers.contains(smallSpaceMap[4][0]));
    assertFalse(answers.contains(smallSpaceMap[5][0]));
    assertFalse(answers.contains(smallSpaceMap[3][1]));
    assertFalse(answers.contains(smallSpaceMap[4][1]));
    assertFalse(answers.contains(smallSpaceMap[5][1]));

    ArrayList<Space> withTerrainAnswers = MatrixMovementHelper.
        validMovesCheckTerrain(smallSpaceMap,1,1,3);

    assertTrue(withTerrainAnswers.contains(smallSpaceMap[0][0]));
    assertTrue(withTerrainAnswers.contains(smallSpaceMap[1][0]));
    assertTrue(withTerrainAnswers.contains(smallSpaceMap[1][1]));
    assertTrue(withTerrainAnswers.contains(smallSpaceMap[0][1]));
    assertFalse(withTerrainAnswers.contains(smallSpaceMap[2][1]));
    assertFalse(withTerrainAnswers.contains(smallSpaceMap[3][0]));
    assertFalse(withTerrainAnswers.contains(smallSpaceMap[4][0]));
    assertFalse(withTerrainAnswers.contains(smallSpaceMap[5][0]));
    assertFalse(withTerrainAnswers.contains(smallSpaceMap[3][1]));
    assertFalse(withTerrainAnswers.contains(smallSpaceMap[4][1]));
    assertFalse(withTerrainAnswers.contains(smallSpaceMap[5][1]));
  }
}




