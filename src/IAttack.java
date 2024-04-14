import java.util.function.Function;
import org.bouncycastle.asn1.eac.CertificationAuthorityReference;

public abstract class IAttack {
  private int range;
  private final Function<Creature,Creature> attack;
  private String attackDescription;

  public IAttack(Function <Creature,Creature> attack, int range){

    this.attack = attack;
    this.range = range;
  }
  public Creature attack(Creature c){
    return attack.apply(c);
  }

  public void setAttackDescription(int damage,int range) {
    this.attackDescription =
    String.format("This attack deals %d damage with a range of %d)",damage,range);
  }
  public void setAttackDescription(int minDamage, int maxDamage, int range){
    this.attackDescription =
        String.format("This attack does between %d and %d damage, with a range of %d",
            minDamage,maxDamage,range);
  }
  @Override
  public String toString(){
    return this.attackDescription;
  }
}
