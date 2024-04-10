public class VerticallyFlipped implements TextBlock{

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  public TextBlock contents;

  public VerticallyFlipped(TextBlock block) throws Exception{
    for (int i = block.height() - 1; i >= 0; i--) {
      TextBlock output = new TextLine(block.row(i));
      if (i == block.height() - 1) {
        this.contents = output;
      } else {
        this.contents = new VComposition(this.contents, output);
      }
    }
  }

  public String row(int i) throws Exception {
    if (i > this.contents.width() || i < 0) {
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
    return this.contents.width();
  } // width()

} // class VerticallyFlipped