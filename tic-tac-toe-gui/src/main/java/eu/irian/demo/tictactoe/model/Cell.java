package eu.irian.demo.tictactoe.model;

public class Cell {

  private Players owner = Players.nobody;

  public Players getOwner() {
    return owner;
  }

  public void setOwner(Players owner) {
    if (this.owner != Players.nobody) {
      throw new RuntimeException("Cell already used by '" + owner + "'");
    }
    this.owner = owner;
  }

  public boolean isFree() {
    return owner == Players.nobody;
  }

  @Override
  public String toString() {
    return owner.toString();
  }
}
