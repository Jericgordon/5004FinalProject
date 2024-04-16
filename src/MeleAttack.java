import java.util.Random;

public class MeleAttack extends IAttack{
  public MeleAttack(int damage){
    super(((c)-> c.takeDamage(damage)),1);
    super.setAttackDescription(damage,1);
  }

  public MeleAttack(int minDamage,int maxDamage){
    super((c)->
        {Random r = new Random();
          int damage = r.nextInt(minDamage,maxDamage);
          c.takeDamage(damage);
          return null;},1);
    super.setAttackDescription(minDamage,maxDamage,1);
  }
}
