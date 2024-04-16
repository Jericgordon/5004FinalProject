public class Goblin extends Creature{
  public Goblin(PlayerNumber owner, String name){
    super(owner,name,CreatureType.Goblin,'g',4,10);
    super.addAttack(new MeleAttack(5));
  }
}
