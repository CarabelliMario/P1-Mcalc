// Mcalc is an simple command line calculator. because of usage of
// java.io.console it won't work in IDE's

import java.io.Console;
import java.util.ArrayList;

public class Mcalc {

  // Throws exceptions at set
  private static class Operation {
   static private double arg1 = 0;
   static private double arg2 = 0;
   static private String operator = "+";
    
    private static void setArg1 (String arg) {
      arg1 = Double.parseDouble(arg);
    } 
    private static void setArg2 (String arg) {
      arg2 = Double.parseDouble(arg);
    } 

    private static void setOperator (String arg) {
      String operatorRegex = "[-+*]";
      if (arg.matches (operatorRegex)) {
        operator = arg;
      } else {
      }
    }

    private static double calculate() {
      if ( operator.equals( "+" ) ) {
        return ( arg1 + arg2 );
      } else if ( operator.equals( "-" ) ) {
        return ( arg1 - arg2 );
      } else if ( operator.equals( "*" ) ) {
        return ( arg1 * arg2 );
      } 
      return 0.;
    }
      
  }

  public static void main(String[] args) {
    String greetingArgumentMode = "command line arguments are ignored.";

    // Argument mode
    if (args.length > 0) {
      System.out.println( greetingArgumentMode );
      // -> Changes state to Basic Mode
    }

    // Basic Mode
    double result = 0.;
    Operation operation = new Operation(); // custom class to store operation arguments and operators

    // read a line of input
    System.out.println( "Enter a calculation" );
    String[] parts = System.console().readLine().split( " " );
    
    // The first argument of an valid expression must be always a number.
    operation.setArg1( parts[ 0 ] );
    int calculatedParts = 1;
    for ( int i = 1 ; i < parts.length ; i++ ) {
      if ( ( i % 2 ) == 1 ) {  // 1, 3 ...
        operation.setOperator( parts[ i ] );
      } else { // 2, 4, ...
        operation.setArg2( parts[ i ] );
        result += operation.calculate();
        operation.setArg1( Double.toString( result ) );
        calculatedParts += 2;
      }
    }

    if (calculatedParts != parts.length) {
      System.out.println( "Due to invalid data entry only this part got evaluated: " );
      for ( int i = 0 ; i < ( calculatedParts - 1 ) ; i++ ) {
        System.out.print( parts[ i ] + " ");
      }
      System.out.println( parts[ calculatedParts - 1 ] );
    }
    System.out.println( "Result: " + result );
    System.exit( 0 );
  }
}
