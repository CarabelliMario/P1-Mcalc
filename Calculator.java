
public class Calculator {

  public static String[] splitAtWhitespace( String s ) {
    s = s.trim(); // delete whitespaces at start and end
    String[] numbersAndOperators = s.split("\\s+" );
    return numbersAndOperators;
  }
  
//  private static boolean expressionIsValid ( String[] expression ) {
//    
//  }
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
