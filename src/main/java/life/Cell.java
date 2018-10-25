
package life;

public abstract class Cell {
  
  public final char value;

  protected Cell(char value) {
    this.value = value;
  }

  public boolean isAlive() {
    return this.value == LivingCell.display;
  }

  public static Cell transformCell(Cell cell, int numberOfNeighbours) {
    if (shouldBeAlive(cell, numberOfNeighbours)) {
      return new LivingCell();
    }
    return new DeadCell();
  }

  private static boolean shouldBeAlive(Cell cell, int numberOfNeighbours) {
    if (numberOfNeighbours == 3 ) return true;
    if ( cell.isAlive() && numberOfNeighbours == 2) return true;
    return false;
  }  
}


