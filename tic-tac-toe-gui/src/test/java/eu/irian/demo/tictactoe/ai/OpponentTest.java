package eu.irian.demo.tictactoe.ai;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.List;

class OpponentTest {

  @RepeatedTest(10)
  public void main() {
    final char[] field = {'x', ' ', ' ', 'o', ' ', 'x', 'o', 'x'};
    final Opponent opponent = new Opponent();
    final int result = opponent.move(field);
    final List<Integer> allowed = Arrays.asList(1, 2, 4);
    Assertions.assertTrue(allowed.contains(result));
  }
}
