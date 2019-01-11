package eu.irian.demo.tictactoe.ai;

import java.io.Serializable;

public interface MoveService extends Serializable {

  int move(char[] field);
}
