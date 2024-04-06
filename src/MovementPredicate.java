import java.util.function.Predicate;

public class MovementPredicate implements Predicate<Space> {
  int moveLeft;
  MovementPredicate(int moveVal){
    moveLeft = moveVal;
  }
  public boolean test(Space s){
    if (moveLeft - s.getSpeedCost() >=0){
      moveLeft -= s.getSpeedCost();
      return true;
    }
    return false;
  }
}
