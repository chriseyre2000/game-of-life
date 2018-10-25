package life;

public class Display {

  private StringBuilder output = new StringBuilder();

  public String print() {
    return output.toString();
  }

  public void addCell(Cell c) {
    output.append(c.value);
  }

  public void newline() {
    output.append("\n");
  }

}