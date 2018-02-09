import java.util.Arrays;


public class CalculatorTests 
{
  //global variables
  public static int testcasesRun = 0;
  public static int testcasesFailed = 0;
  public static void check( String testcaseName, String[] result, 
  String[] expectedResult ) 
  {   
    if (!Arrays.equals( result, expectedResult ) ) {
      System.out.println( testcaseName + ": FAILED" );
      System.out.println( "Expected result: " 
        + Arrays.toString( expectedResult ) );
      System.out.println( "Actual result: " + Arrays.toString( result ) );
      testcasesFailed++; // global variable 
    } 
  testcasesRun++; // global variable
  return;
  }

  public static void main( String[] args) 
  {
    Calculator calc = new Calculator();
    String[] result;
    String[] expectedResult;
    String testcaseName;

    // splitAtWhitspaces
    testcaseName = "trimWhitespacesAtStartAndEnd";
    result = calc.splitAtWhitespace( " 1 " );
    expectedResult = new String[]{"1"};
    check ( testcaseName, result, expectedResult );

    testcaseName = "trimWhitespacesAtStartAndEnd";
    result = calc.splitAtWhitespace( " 1    +  1 " );
    expectedResult = new String[]{"1", "+", "1"};
    check ( testcaseName, result, expectedResult );

    System.out.println( (testcasesRun - testcasesFailed) + "/" 
      + testcasesRun + " testcases run successful." );
  }
}
