/**
 * This exception is to be thrown if two characters are placed on the same
 * square of the board.
 */

public class IllegalMovementError extends RuntimeException{
  public IllegalMovementError(String errorMessage){
    super(errorMessage);
  }
}
