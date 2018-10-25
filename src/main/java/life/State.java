package life;

public class State {
  
  public final String values;
  public final Dimensions dimensions;

  public State(Dimensions dimensions, String values) {
     this.values = values; 
     this.dimensions = dimensions;
     validateState();
  }

  private void validateState() {
    int initialStateLength = values.length();
    if (initialStateLength != dimensions.width * dimensions.height) {
      throw new IllegalArgumentException();
    }
  }

  public Cell fetch(Coordinate coordinate) {
    if (coordinate.inside(dimensions) && values.charAt( coordinate.x + (coordinate.y * dimensions.width )) == LivingCell.display) { 
      return new LivingCell(); 
    } 
    return new DeadCell(); 
  }
  
  public Display display() {
    Display display = new Display();
  
    for(int i=0; i < dimensions.height; i++ ) {
      generateRow(i, display);
    } 
    return display;
  }  

  private void generateRow(int y, Display display) {
    
    for(int x=0; x < dimensions.width; x++ ) {
      Cell cell = fetch( new Coordinate(x, y));
      display.addCell(cell );
    }
    display.newline();
  }
}