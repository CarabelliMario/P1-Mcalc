// Mcalc is an simple command line calculator. because of usage of
// java.io.console it won't work in IDE's

import java.io.Console;
import java.util.ArrayList;

public class Mcalc {

  public static void main(String[] args) {
    System.out.println( "Enter a calculation" );
    String input = System.console().readLine(); 
    
 //   Calculator calc = new Calculator();
 //   double result = calc.calculate( validExpression );   
    double result = 0.0;
    System.out.println("Result: " + result );
  }

}
