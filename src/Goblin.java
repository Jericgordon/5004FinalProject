public class Goblin extends Creature{
  public Goblin(String name){
    super(name,CreatureType.Goblin,'g',4,10);
    super.addAttack(new MeleAttack(5));
  }
}
