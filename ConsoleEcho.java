// This function echos User input. It is an example for the use of
// java.io.Console to get user input at command line programs

import java.io.Console;

public class ConsoleEcho {
  public static void main (String[] args) {
    Console Cmd;
    String Input;
    String Output;

    if ((Cmd = System.console()) == null) {
      System.out.println("This program works only if you execute it from the" +
      " command line.");
      System.exit(1);
    }

    Input = Cmd.readLine();
    Output = Input;
    System.out.println(Output);
  }
}
