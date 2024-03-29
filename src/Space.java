public class Space {
  Terrain terrain;
  Creature creature;

  public Space(Terrain terrain) {
    this.terrain = terrain;
  }
  public char getSymbol() {
    if (!(creature == null)){
      return creature.getSymbol();
    }
    return terrain.getSymbol();
  }
  public int getSpeedCost(){
    return terrain.getSpeedCost();
  }
  public boolean hasCharacter(){
    return (!(creature == null));
  }
  public void addCharacter(Creature creature){//Add illegal movement error
    if (!(creature == null)){
      //throw custom error here, cannot have 2 character here.
    }
    this.creature = creature;
  }
  public void removeCharacter(){
    this.creature = null;
  }
  public Creature getCharacter(){
    return this.creature;
  }
}


