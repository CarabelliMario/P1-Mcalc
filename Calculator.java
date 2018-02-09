import java.util.regex.Pattern;

public class Calculator 
{
  public static String removeWhitespaces( String s )
  {
    String stringWithoutSpaces = s.replaceAll("\\s+","");
    return stringWithoutSpaces;
  }

  public static String[] splitBeforeAndAfterOperators( String s ) 
  {
    // Pattern.quote() is used to make the regex parts more readable
    String anySupportedOperator = Pattern.quote("[+-*]");
    String emptySpaceBeforeOperator = Pattern.quote(
      "?<=" + anySupportedOperator // look around
    );
    String emptySpaceAfterOperator = Pattern.quote(
     "?=" + anySupportedOperator // look ahead
    );
    String beforeAndAfterOperator = Pattern.quote(
      "(" + emptySpaceBeforeOperator + ")|(" + emptySpaceAfterOperator + ")"
    );

    String[] argumentsAndOperators = s.split( beforeAndAfterOperator ); 

    return argumentsAndOperators;
  }
  
  public static boolean expressionIsValid ( String[] expression ) 
  {
    if ( expression == null || expression.length == 0 ) {
      return false;
    }
    return true;
  }
//
//  private static String[] getBiggestValidExpression ( String[] numbersAndOperators ) {
//    return validExpression;
//  }
//  
//  private static boolean isSupportedOperator (String s) {
//    String regex = "[-+*]";
//    return ( s.matches (regex));
//  }
//
//  private static boolean isNumber (String s) {
//    try { 
//      Double.parseDouble( s );
//      return true;
//    } catch ( NumberFormatException e ) {
//      return false;
//    }
//  }
//
//  private static double calculateResult( String[] numbersAndOperators ) {
//    return result;
//  }
}
