public class Centered implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  public TextBlock contents;
  int width;

  public Centered(TextBlock block, int width) {
    this.width = width;
    if (block.width() >= width) {
      System.err.println("Too little space in centered.");
      System.exit(1);
    } else {
      int totalSpace = width - block.width();
      if (totalSpace % 2 == 0) {
        TextBlock spacesBlock = new TextLine(TBUtils.spaces(totalSpace / 2));
        HComposition leftSide = new HComposition(spacesBlock, block);
        TextBlock toReturn = new HComposition(leftSide, spacesBlock);
        this.contents = toReturn;
      } else {
        TextBlock leftSpacesBlock = new TextLine(TBUtils.spaces((totalSpace + 1) / 2));
        TextBlock rightSpacesBlock = new TextLine(TBUtils.spaces(((totalSpace + 1) / 2) - 1));
        HComposition leftSide = new HComposition(leftSpacesBlock, block);
        TextBlock toReturn = new HComposition(leftSide, rightSpacesBlock);
        this.contents = toReturn;
      }
    } // if else
  } // centered(TextBlock, int)


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
    if (i > this.width || i < 0) {
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
    return this.width;
  } // width()

} // class Centered