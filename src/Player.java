import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import org.jooq.util.derby.sys.Sys;

//Players need a way to 'Own' I'm going to put thought into that
//before I implement something
public abstract class Player {
  private String name;
  private HashMap<String,Runnable> playerCommands = new HashMap<>();
  private boolean gameOver = false;
  private HashMap<Creature,Point> creatures = new HashMap<>();
  private Board board; //serves as a intermediate point between functions
  //to pass around a board


  public Player(String name, HashMap<Creature,Point> creatureSet) {
    this.creatures = creatureSet;
    this.name = name;
  }

  public String getName() {
    return name;
  }
  public boolean isGameOver(){
    return this.gameOver;
  }
  private void moveCharacterHelper(){
    Scanner s = new Scanner(System.in);
    System.out.println("What is the X value of where you would like to move");
    int x = s.nextInt();
    System.out.println("What is the Y value of where you would like to move");
    int y = s.nextInt();
    //board.moveCreature();
  }


  private void initializePlayerCommands(){
    playerCommands.put("Move", this::moveCharacterHelper);


  }
  public void runCommand(String command){
      playerCommands.get(command).run();
  }


  public void preTurn(Board b){
    this.board = b;
    HashMap<Creature,Point> currentCreatures = b.getCreatureList();
    creatures.keySet().removeIf(c -> !currentCreatures.containsKey(c)); //remove creatures no longer on the board
    if (creatures.isEmpty()) {
      gameOver = true;
    }

  }
  public Board takeTurn(Board b) {

    this.board = b; //Set the current state to be b
    System.out.println(b.toString());
    return this.board;
  }

  private void takeAction(){
    Scanner s = new Scanner(System.in);
    //Take input add tag here
    try{
      this.runCommand(s.nextLine());
    } catch (Exception NullPointerException){
      System.out.println("Not a valid command");
    }
  }
}
