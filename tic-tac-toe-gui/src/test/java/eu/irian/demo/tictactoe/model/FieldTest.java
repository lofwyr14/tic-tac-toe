package eu.irian.demo.tictactoe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FieldTest {

  @Test
  void test() {
    Field field = new Field();
    Assertions.assertFalse(field.isGameOver());
    field.move(0, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    try {
      field.move(1, Players.player1);
      Assertions.fail("double move");
    } catch (Exception e) {
      // ignore
    }
    Assertions.assertFalse(field.isGameOver());
    try {
      field.move(0, Players.player2);
      Assertions.fail("field not free");
    } catch (Exception e) {
      // ignore
    }
    Assertions.assertFalse(field.isGameOver());
    field.move(1, Players.player2);
    Assertions.assertFalse(field.isGameOver());
    field.move(2, Players.player1);
    Assertions.assertFalse(field.isGameOver());
    try {
      field.move(3, Players.nobody);
      Assertions.fail("nobody is not a valid player");
    } catch (Exception e) {
      // ignore
    }
    Assertions.assertFalse(field.isGameOver());

  }
}
