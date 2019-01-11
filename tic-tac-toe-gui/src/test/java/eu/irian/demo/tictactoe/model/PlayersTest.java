package eu.irian.demo.tictactoe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {

  @Test
  void getIcon() {
    for (Players value : Players.values()) {
      Assertions.assertNotNull(value.getIcon());
    }
  }

  @Test
  void getCssClass() {
    for (Players value : Players.values()) {
      Assertions.assertNotNull(value.getCssClass());
    }
  }
}