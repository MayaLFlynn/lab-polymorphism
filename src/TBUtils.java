import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";
  static String lotsOfTildas = "~~";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

    /**
   * Build a sequence of tildas of a specified length.
   */
  static String tildas(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfTildas.length() < len) {
      lotsOfTildas = lotsOfTildas.concat(lotsOfTildas);
    } // while
    // Extract an appropriate length substring
    return lotsOfTildas.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /**
   * Equal if contain same lines.
   */
  static boolean equal(TextBlock t1, TextBlock t2) throws Exception{
    if (t1.height() != t2.height() || t1.width() != t2.width()) {
      return false;
    }
    for (int i = 0; i < t1.height(); i++) {
      for (int j = 0; j < t1.width(); j++) {
        if (t1.row(i).charAt(j) != t2.row(i).charAt(j)) {
          return false;
        }
      }
    }
    return true;
  } // spaces(int)

  static boolean eqv(TextBlock t1, TextBlock t2) throws Exception{
    if (t1.getClass().equals(t2.getClass())) {
      return equal(t1, t2);
    }
    return false;
  } // spaces(int)

  static boolean eq(TextBlock t1, TextBlock t2) throws Exception{
    return t1 == t2;
  } // spaces(int)

} // class TBUtils
