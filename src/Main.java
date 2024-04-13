import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
    Controller c = new Controller(new InputStreamReader(System.in),System.out);
    c.playGame(new TwoPlayerGameModel(),new TestBoard());
  }
}
