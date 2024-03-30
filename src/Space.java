import java.util.Objects;

public class Space {
  private Terrain terrain;
  private Creature creature;
  private Boolean hasCreature;
  private int xVal,yVal;

  public Space(Terrain terrain) {
    this.terrain = terrain;
    this.creature = null;
    hasCreature = false;
  }
  public String getSymbol() {
    if (!(creature == null)){
      return creature.getSymbol();
    }
    return terrain.getSymbol();
  }
  public int getSpeedCost(){
    return terrain.getSpeedCost();
  }

  public int getxVal() {
    return xVal;
  }
  public int getyVal() {
    return yVal;
  }

  public void setxVal(int xVal) throws IllegalArgumentException {
    if (xVal < 0){
      throw new IllegalArgumentException("Xval cannot be below 0");
    }
    this.xVal = xVal;
  }

  public void setyVal(int yVal) throws IllegalArgumentException {
    if (yVal < 0){
      throw new IllegalArgumentException("Yval cannot be below 0");
    }
    this.yVal = yVal;
  }
  public void setXY(int xVal,int yVal){
    setxVal(xVal);
    setyVal(yVal);
  }

  public Terrain getTerrain() {
    return terrain;
  }

  public Creature getCreature() {
    return creature;
  }

  public boolean hasCreature(){
    return (!(creature == null));
  }
  public void addCharacter(Creature creature) throws IllegalMovementError{//Add illegal movement error
    if (hasCreature){
      throw new IllegalMovementError("Two Characters cannot be placed on the same space");
    }
    hasCreature = false;
    this.creature = creature;
  }
  public void removeCharacter(){
    this.creature = null;
  }
  public Creature getCharacter(){
    return this.creature;
  }

  @Override
  public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if (!(o instanceof Space)){
      return false;
    }
    Space testSpace = (Space) o;

    return ((this.xVal == testSpace.getxVal()) &&
            (this.yVal == testSpace.getyVal()) &&
            (this.terrain == testSpace.getTerrain()) &&
            (this.creature == testSpace.getCreature()) &&
            (this.hasCreature == testSpace.hasCreature())
    );
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(Math.pow(xVal,yVal));
  }
}


