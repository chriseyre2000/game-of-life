package life;

class StateTransitionCalulator {

  State currentState;
  Dimensions dimensions;

  public StateTransitionCalulator(State currentState) {
    this.currentState = currentState;
    this.dimensions = currentState.dimensions;
  }

  public State next() {
    return new State(currentState.dimensions, calculateState());
  }

  public String calculateState() {
    String newState = "";
    for(int z = 0; z < dimensions.height * dimensions.width; z++) {
      newState += calculateNewState(z);
    }
    return newState;
  }

  private int countLiveNeighbours(Coordinate coordinate) {
    int count = 0;
    for(int z = 0; z < 9; z++) {
      count += countOffset(coordinate, z);
    }
    return count;
  }

  private int countOffset(Coordinate coordinate, int z) {
    if (z == 4) return 0;
    int j = (z % 3) -1;
    int k = (z / 3) -1;
    return (currentState.fetch(new Coordinate(coordinate.x + j, coordinate.y + k)).isAlive()) ? 1 : 0;
  }

  private char calculateNewState(int z) {
    int x = z % dimensions.width;
    int y = z / dimensions.height;
    Coordinate coordinate = new Coordinate(x, y);
    return Cell.transformCell(currentState.fetch(coordinate ), countLiveNeighbours(coordinate)).value;
  }
} 