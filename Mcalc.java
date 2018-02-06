// Mcalc is an simple command line calculator. because of usage of
// java.io.console it won't work in IDE's

import java.io.Console;
import java.util.ArrayList;

public class Mcalc {
  public static void main(String[] args) {
    String greetingArgumentMode = "command line arguments are ignored.";

    // Argument mode
    if (args.length > 0) {
      System.out.println( greetingArgumentMode );
      // -> Changes state to Basic Mode
    }

    // Basic Mode

    // read a line of input
    System.out.println( "Enter an Expression:" );
    String[] parts = System.console().readLine().split( " " );

    ArrayList<String> words = new ArrayList<String>();
    String[] expression = new String[ 3 ];
    String validExpression = ""; // number + operator + number
    String operatorRegex = "[-+*]";
    String integerOrDecimalRegex = "^([+-])?[0-9]+([,.][0-9]+)?$";

    // evalulates the input and returns the biggest valid expression which
    // could be returned by the user input.
    int partNr = 0;
    if (parts[0].matches( integerOrDecimalRegex ) == false ) {
      System.out.println("Your first argument must be a number.");
    }
    for ( String part : parts ) {
      if (partNr < 2) {
        expression[ partNr ] = part;
        partNr++;
      } else {
        expression[ partNr ] = part;
        if ( expression[1].matches( operatorRegex )
          && expression[2].matches( integerOrDecimalRegex ) ) {
            validExpression = expression[0] + expression[1] + expression[2];
            expression[0] = validExpression;
            partNr = 1;
        } else {
          break;
        }
      }
    }
    System.out.println (validExpression);
    System.exit( 0 );
  }
}
