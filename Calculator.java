import java.util.regex.Pattern;
import java.util.Arrays;

public class Calculator 
{
  private static String supportedOperators = "+-*";

  public static String removeWhitespaces( String s )
  {
    String stringWithoutSpaces = s.replaceAll("\\s+","");
    return stringWithoutSpaces;
  }

  public static String[] splitBeforeAndAfterOperators( String s ) 
  {
    String anyOperator = "[\\Q" + supportedOperators + "\\E]";
    String emptySpaceBeforeOperator =  "?<=" + anyOperator;
    String emptySpaceAfterOperator =  "?=" + anyOperator;
    String beforeAndAfterOperator = (
      "(" + emptySpaceBeforeOperator + ")|(" + emptySpaceAfterOperator + ")"
    );

    String[] argumentsAndOperators = s.split( beforeAndAfterOperator ); 

    return argumentsAndOperators;
  }

  public static boolean representsDouble( String s )
  {
    try { 
      String withPointSeparator = s.replace( ',', '.' );
      Double.parseDouble( withPointSeparator );
      return true; 
    } catch (NumberFormatException e) {
      return false; 
    }
  }
  
  public static boolean representsOperator( String s )
  {
    return s.matches( "[\\Q" + supportedOperators + "\\E]" );
  }
  
  public static boolean operatorsAndDoublesAlternate( String[] expression )
  {
    boolean operatorFollowsDouble;   
    boolean doubleFollowsOperator;   

    for ( int i = 0; i < expression.length - 1; i++ ) {
      operatorFollowsDouble = representsDouble( expression[ i ] ) 
        && ( representsOperator( expression[ i + 1 ] ) );
      doubleFollowsOperator =  representsOperator( expression[ i ] )
        && ( representsDouble( expression[ i + 1 ] ) ) ;

      if ( !( operatorFollowsDouble || doubleFollowsOperator ) ) {
        return  false;
      }
    }
    return true;
  } 

  public static String[] stringToExpression ( String s )x;
  {
    String withoutSpaces = removeWhitespaces( s );
    String[] expression = splitBeforeAndAfterOperators( withoutSpaces );
    return expression;
  }

  public static boolean isValidExpression( String[] expression );
  {
    if ( expression.length == 0 ) {
      return false;
    }
    if ( !representsDouble( expression[0] ) ) {
      return false; 
    } 
    if ( !operatorsAndDoublesAlternate( expression ) ) {
      return false;
    }
    return true;
  }

  private static String[] getBiggestValidExpression ( String s ) 
  {
    String[] expression = stringToExpression ( s );
    String[] expressionToEvaluate = expression[0];

    if (!isValidExpression (expressionToEvaluate) {
      return (new String[] = {""});
    }

    String[] biggestValidExpression = expressionToEvaluate;
    static final int START_SIZE = biggestValidExpression.lenght;
    for ( int i = START_SIZE; i < expression.length; i++ ) {
      expressionToEvaluate = Arrays.copyOf( expressionToEvaluate, i + 1 )

      if ( !isValidExpression ( expressionToEvaluate ) ) {
        break;
      }
       
      biggestValidExpression = Arrays.copyOf( biggestValidExpression, i + 1 );
    } 
    return biggestValidExpression;
  }
//  
//  private static boolean isSupportedOperator (String s) {
//    String regex = [-+*]";
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

