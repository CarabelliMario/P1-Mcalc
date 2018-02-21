import java.util.Arrays;

public class CalculatorTests 
{
  //global variables
  public static int testcasesRun = 0;
  public static int testcasesFailed = 0;

  public static void check( String testcaseName, boolean result, 
  boolean expectedResult ) 
  {   
    if (result != expectedResult) {
      System.out.println( testcaseName + ": FAILED" );
      System.out.println( "Expected result: " + expectedResult );
      System.out.println( "Actual result: " + result );
      testcasesFailed++; // global variable 
    } 

    testcasesRun++; // global variable
    return;
  }

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
    String testcaseName = "undefined";

    // removeWhitspaces( String )
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

    
    // splitBeforeAndAfterOperators( String )
    String[] result1;
    String[] expectedResult1;

    testcaseName = "splitAt+";
    result1 = calc.splitBeforeAndAfterOperators( "1+1" );
    expectedResult1 = new String[]{  "1" , "+" , "1" };
    check ( testcaseName, result1, expectedResult1 );

    testcaseName = "splitAt-";
    result1 = calc.splitBeforeAndAfterOperators( " -1 " );
    expectedResult1 = new String[]{ " ", "-", "1 " };
    check ( testcaseName, result1, expectedResult1 );

    testcaseName = "splitAt*";
    result1 = calc.splitBeforeAndAfterOperators( "1*1" );
    expectedResult1 = new String[]{ "1", "*", "1"};
    check ( testcaseName, result1, expectedResult1 );

    // representsDouble( String ) 
    boolean result3;
    boolean expectedResult3;

    testcaseName = "1representsDouble";
    result3 = calc.representsDouble( "1" );
    expectedResult3 = true;
    check ( testcaseName, result3, expectedResult3 );

    testcaseName = "1.representsDouble";
    result3 = calc.representsDouble( "1." );
    expectedResult3 = true;
    check ( testcaseName, result3, expectedResult3 );

    testcaseName = "1,representsDouble";
    result3 = calc.representsDouble( "1," );
    
    expectedResult3 = true;
    check ( testcaseName, result3, expectedResult3 );

    testcaseName = "1.1111representsDouble";
    result3 = calc.representsDouble( "1.11111" );
    expectedResult3 = true;
    check ( testcaseName, result3, expectedResult3 );

    // representsOperator( String ) 
    boolean result2;
    boolean expectedResult2;

    testcaseName = "+representsOperator";
    result2 = calc.representsOperator( "+" );
    expectedResult2 = true;
    check ( testcaseName, result2, expectedResult2 );

    testcaseName = "+withSpacedoesntRepresentsOperator";
    result2 = calc.representsOperator( "+ " );
    expectedResult2 = false;
    check ( testcaseName, result2, expectedResult2 );

    // operatorsAndDoublesAlternate( String[] )
    boolean result4;
    boolean expectedResult4;

    testcaseName = "operatorsAndDoubleAreAlternating";
    result4 =  calc.operatorsAndDoublesAlternate ( 
      new String[]{"1", "+", "1"}
    );
    expectedResult4 = true;
    check ( testcaseName, result2, expectedResult2 ); 


    testcaseName = "operatorsAndDoubleAlternateAreNotAlternating";
    result4 =  calc.operatorsAndDoublesAlternate ( 
      new String[]{"1", "+", "-", "1"}
    );
    expectedResult4 = false;
    check ( testcaseName, result2, expectedResult2 ); 
    
    // stringToExpression( String )

    // getBiggestValidExpression ( Sting )
    
    // Test Summary
    System.out.println( (testcasesRun - testcasesFailed) + "/" 
      + testcasesRun + " testcases run successful." );
  }
}
