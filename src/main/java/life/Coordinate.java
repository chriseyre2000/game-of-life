package life;

class Coordinate {
  final int x;
  final int y;
  
  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  boolean inside(Dimensions dimensions) {
    if (x < 0 || y < 0 || x >= dimensions.width || y >= dimensions.height) {
      return false;
    }
    return true;
  }
}