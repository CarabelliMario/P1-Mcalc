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

  public static void check( String testcaseName, String result, 
  String expectedResult ) 
  {   
    if (!result.equals( expectedResult ) ) {
      System.out.println( testcaseName + ": FAILED" );
      System.out.println( "Expected result: " + expectedResult );
      System.out.println( "Actual result: " + result );
      testcasesFailed++; // global variable 
    } 
  testcasesRun++; // global variable
  return;
  }


  // main: here are the testcases run
  public static void main( String[] args) 
  {
    // class Calculator
    Calculator calc = new Calculator();
    String testcaseName;

    // removeWhitspaces()
    String result;
    String expectedResult;

    testcaseName = "trimWhitespacesAtStartAndEnd";
    result = calc.removeWhitespaces( " 1 " );
    expectedResult = "1";
    check ( testcaseName, result, expectedResult );

    testcaseName = "removeMultipleWhitspaces";
    result = calc.removeWhitespaces( "1    +  1" );
    expectedResult = "1+1";
    check ( testcaseName, result, expectedResult );

    
    // splitBeforeAndAfterOperators
    String[] result1;
    String[] expectedResult1;

    testcaseName = "splitAt+";
    result1 = calc.splitBeforeAndAfterOperators( "+" );
    expectedResult1 = new String[]{  "" , "+" , "" };
    check ( testcaseName, result, expectedResult );

    testcaseName = "splitAt-";
    result1 = calc.splitBeforeAndAfterOperators( "-" );
    expectedResult1 = new String[]{ "", "-", "" };
    check ( testcaseName, result, expectedResult );

    testcaseName = "splitAt*";
    result1 = calc.splitBeforeAndAfterOperators( "*" );
    expectedResult1 = new String[]{ "", "*", ""};
    check ( testcaseName, result, expectedResult );
    
    // Test Summary
    System.out.println( (testcasesRun - testcasesFailed) + "/" 
      + testcasesRun + " testcases run successful." );
  }
}
