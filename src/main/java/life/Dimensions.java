package life;

public class Dimensions {

  public static Dimensions withWidthAndHeight(int width, int height) {
    return new Dimensions(width, height);
  }

  public final int width;
  public final int height;

  private Dimensions(int width, int height) {
    this.width = width;
    this.height = height;
  }
}
