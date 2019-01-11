package eu.irian.demo.tictactoe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

  @Test
  void setOwner() {
    Cell cell = new Cell();
    Assertions.assertEquals(Players.nobody, cell.getOwner());
    cell.setOwner(Players.player1);
    Assertions.assertEquals(Players.player1, cell.getOwner());
    try {
      cell.setOwner(Players.player2);
      Assertions.fail("A set cell can't be reset!");
    } catch (Exception e) {
      // okay
    }
  }
}
