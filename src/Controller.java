import java.io.IOException;
import java.util.Scanner;

public class Controller {
  Readable in;
  Appendable out;

  public Controller(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
  }
  private void setUpGame(GameModel m,BoardSetTwoPlayer p){
    try { //Try catch just for IO exception with in/out setup
      //Set up the game
      Scanner s = new Scanner(in);
      out.append("What is Player one's name?");
      String p1Name = s.nextLine();
      out.append("What is Player two's name?");
      String p2Name = s.nextLine();
      m.createNewGame(p,p1Name,p2Name);
    } catch (IOException ioException){
      System.out.println("Not a valid setup inputs");
      throw new IllegalStateException("Reconfigure setup please");
    }
  }
  private PlayerAction getPlayerAction(){
    try { //Try catch just for IO exception with in/out setup
      //Set up the game
      Scanner s = new Scanner(in);
      String command = s.nextLine();
      try{
        return PlayerAction.valueOf(command);
      } catch (IllegalArgumentException illegalArgumentException){
        out.append("Invalid command, Please try again");
        return getPlayerAction();
      }
    } catch (IOException ioException){
      System.out.println("Not a valid setup inputs");
      throw new IllegalStateException("Reconfigure setup please");
    }
  }

  public void playGame(GameModel m,BoardSetTwoPlayer p){
    try { //Try catch just for IO exception with in/out setup
        //set up the game
      setUpGame(m,p);
      while (!m.isGameOver()){
        //display board
        out.append(m.getBoardString());

        //Print out whose turn it is
        out.append(String.format("\nIt is now %s's turn\n",m.getCurrentPlayerName()));

        //go through the creatures for a player that turn
        while (true) {
          //Print out the details of the current creature
          out.append(m.getCurrentCreatureInformation());

          //Ask what the player would like to do, and implement that action
          //Implementing an action for a creature automatically increments to the next creature
          PlayerAction action = this.getPlayerAction();
          switch (action){
            case Move:
              Point toMove = getXYFromPlayer(m.getXMaxCoord(),m.getYMaxCoord());
              while (!m.canCurrentCreatureMove(toMove.getXCoord(),toMove.getYCoord())) {
                out.append("Not enough movement to reach there. Try again");
                toMove = getXYFromPlayer(m.getXMaxCoord(),m.getYMaxCoord());
              }
              m.moveCurrentCreature(toMove.getXCoord(), toMove.getYCoord());

            case Attack:
              break;
            case Info:
              Point info = getXYFromPlayer(m.getXMaxCoord(),m.getYMaxCoord());
              out.append(m.getCreatureInformation(info.getXCoord(), info.getYCoord()));
              break;
            case Help:
              out.append("Below is a list of Valid commands" +"\n");
              for (PlayerAction value: PlayerAction.values()) {
                out.append(value.name()).append("\n");
              }
              break;
          }


          //Check if there's a next creature in this turn
          if (!m.isThereANextCreatureInThisTurn()){
            break;
          }
        }
        //play the next turn
        m.nextTurn();
      }
    } catch (IOException ioException){
      System.out.println("Not a valid setup inputs");
      throw new IllegalStateException("Reconfigure setup please");
    }
  }
  private Point getXYFromPlayer(int xLimit,int yLimit){
    try{
      Scanner s = new Scanner(in);
      out.append("What is the target X coordinate for action");
      int x = s.nextInt();
      if (x > xLimit){
        out.append("Invalid input, Please try again");
        return getXYFromPlayer(xLimit,yLimit);
      }
      out.append("What is the target Y coordinate for action");
      int y = s.nextInt();
      if (y > yLimit) {
        out.append("Invalid input, Please try again");
        return getXYFromPlayer(xLimit, yLimit);
      }
      return new Point(x,y);
    } catch (IOException ioException){
      System.out.println("Not a valid setup inputs");
      return null;
    }
  }

}
