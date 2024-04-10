import java.io.PrintWriter;

public class Truncated implements TextBlock {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  public TextBlock contents;
  int maxWidth;


  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Truncated(TextBlock block, int maxWidth) throws Exception {
    this.maxWidth = maxWidth;
    PrintWriter pen = new PrintWriter(System.out, true);
    if (maxWidth >= block.width()) {
      System.err.println("Too much space in truncated.");
      System.exit(1);
    }
    //this.contents = new TextLine("");
    for (int i = 0; i < block.height(); i++) {
      String substring = "";
      for (int j = 0; j < maxWidth; j++) {
        
        substring += block.row(i).charAt(j);
      }
      //System.out.println(substring);
      
      TextBlock output = new TextLine(substring);
      //TBUtils.print(pen, output);
      if (i == 0) {
        this.contents = output;
      } else {
        this.contents = new VComposition(this.contents, output);
      }
    }

    //TBUtils.print(pen, this.contents);
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Get one row from the block.
   * 
   * @pre i == 0
   * @exception Exception if i != 0
   */
  public String row(int i) throws Exception {
    if (i > this.maxWidth || i < 0) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
    return this.contents.row(i);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return maxWidth;
  } // width()

}