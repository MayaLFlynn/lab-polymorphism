public class HorizontallyFlipped implements TextBlock{

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  public TextBlock contents;

  public HorizontallyFlipped(TextBlock block) throws Exception{
    for (int i = 0; i < block.height(); i++) {
      String substring = "";
      for (int j = block.width() - 1; j >= 0; j--) {
        substring += block.row(i).charAt(j);
      }
      TextBlock output = new TextLine(substring);
      if (i == 0) {
        this.contents = new TextLine(substring);
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

} // class HorizontallyFlipped
