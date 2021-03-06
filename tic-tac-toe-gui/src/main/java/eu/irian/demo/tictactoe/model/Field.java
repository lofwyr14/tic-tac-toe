package eu.irian.demo.tictactoe.model;

import java.util.Arrays;
import java.util.List;

public class Field {

  private final Cell[] cells;
  private boolean gameOver;
  private Players winner;
  private int move;

  public Field() {
    this.cells = new Cell[9];
    for (int i = 0; i < cells.length; i++) {
      cells[i] = new Cell();
    }
  }

  public List<Cell> getCells() {
    return Arrays.asList(cells);
  }

  public void move(int cell, Players player) {
    if (getPlayerOnTurn() != player) {
      throw new RuntimeException("Player '" + player + "' is not on turn.");
    }
    cells[cell].setOwner(player);
    updateState();
  }

  public String coordsString(final int cell)  {
    return "row=" + ((cell / 3) + 1) + " column=" + ((cell % 3) + 1);
  }

  private Players getPlayerOnTurn() {
    return move % 2 == 0 ? Players.player1 : Players.player2;
  }

  public boolean isGameOver() {
    return gameOver;
  }

  public Players getWinner() {
    return winner;
  }

  @Override
  public String toString() {
    return Arrays.toString(cells) + " winner=" + winner;
  }

  public char[] serialize() {
    final char[] chars = new char[9];
    for (int i = 0; i < cells.length; i++) {
      chars[i] = cells[i].getOwner().getCharacter();
    }
    return chars;
  }

  private void updateState() {

    // row 0,1,2
    for (int row = 0; row < 3; row++) {
      if (equalsOwner(cells[3 * row], cells[3 * row + 1], cells[3 * row + 2])) {
        winner = cells[3 * row].getOwner();
        gameOver = true;
      }
    }

    // column 0,1,2
    for (int col = 0; col < 3; col++) {
      if (equalsOwner(cells[col], cells[col + 3], cells[col + 6])) {
        winner = cells[col].getOwner();
        gameOver = true;
      }
    }

    // diagonal 1
    if (equalsOwner(cells[0], cells[4], cells[8])) {
      winner = cells[0].getOwner();
      gameOver = true;
    }

    // diagonal 2
    if (equalsOwner(cells[2], cells[4], cells[6])) {
      winner = cells[2].getOwner();
      gameOver = true;
    }

    if (!gameOver) {
      if (!isMoveIsPossible()) {
        winner = Players.nobody;
        gameOver = true;
      }
    }

    move++;
  }

  private boolean isMoveIsPossible() {
    return Arrays.stream(cells).anyMatch(cell -> cell.getOwner() == Players.nobody);
  }

  private boolean equalsOwner(final Cell a, final Cell b, final Cell c) {
    return a.getOwner() != Players.nobody && a.getOwner() == b.getOwner() && a.getOwner() == c.getOwner();
  }

}
