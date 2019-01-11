package eu.irian.demo.tictactoe.ui;

import eu.irian.demo.tictactoe.ai.MoveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Arrays;

@Named
@SessionScoped
public class Game implements Serializable {

  private static final Logger LOG = LoggerFactory.getLogger(Game.class);

  private static final char P1 = 'x';
  private static final char P2 = 'o';
  private static final char FREE = ' ';

  @Inject
  MoveService moveService;

  private String status;
  private char[] field;
  private char winner;

  public Game() {
    reset();
  }

  @Min(0) // todo: checker
  @Max(8) // todo: checker
  public String move(final int cell) {
    if (LOG.isInfoEnabled()) {
      LOG.info("Current move is '{}'", cell);
    }

    field[cell] = P1;
    if (isOver()) {
      LOG.info("Game over " + Arrays.toString(field));
      status = "You are the winner!";
      return "/tic-tac-toe.xhtml";
    }
    int oponentMove = moveService.move(field);
    LOG.info("Opponent move: " + oponentMove);
    field[oponentMove] = P2;
    if (isOver()) {
      LOG.info("Game over " + Arrays.toString(field));
      status = "Opponent is the winner!";
      return "/tic-tac-toe.xhtml";
    }

    status = "Opponents last move was: row=" + ((cell / 3) + 1) + " column=" + ((cell % 3) + 1);

    return "/tic-tac-toe.xhtml";
  }

  public String image(final int cell) {
    if (field[cell] == P1) { // todo
      return "fa-times";
    } else if (field[cell] == P2) {
      return "fa-circle-o";
    } else {
      return "";
    }
  }

  public String css(final int cell) {
    if (field[cell] == P1) { // todo
      return "player-1";
    } else if (field[cell] == P2) {
      return "player-2";
    } else {
      return "free";
    }
  }

  public boolean free(final int cell) {
    return field[cell] == FREE;
  }

  public String getStatus() {
    return status;
  }

  // XXX cache this value
  public boolean isOver() {
    if (hasThreeInARow(field[0], field[1], field[2])) {
      this.winner = field[0];
      return true;
    }

    if (hasThreeInARow(field[3], field[4], field[5])) {
      this.winner = field[3];
      return true;
    }

    if (hasThreeInARow(field[6], field[7], field[8])) {
      this.winner = field[6];
      return true;
    }

    if (hasThreeInARow(field[0], field[3], field[6])) {
      this.winner = field[0];
      return true;
    }

    if (hasThreeInARow(field[1], field[4], field[7])) {
      this.winner = field[1];
      return true;
    }

    if (hasThreeInARow(field[2], field[5], field[8])) {
      this.winner = field[2];
      return true;
    }

    if (hasThreeInARow(field[0], field[4], field[8])) {
      this.winner = field[0];
      return true;
    }

    if (hasThreeInARow(field[2], field[4], field[6])) {
      this.winner = field[2];
      return true;
    }

    if (!isMoveIsPossible()) {
      return true;
    }
    this.winner = FREE;
    return false;
  }

  private boolean isMoveIsPossible() {
    for (int i = 0; i < field.length; i++) {
      if (field[i] == FREE) {
        return true;
      }
    }
    return false;
  }

  private boolean hasThreeInARow(char a, char b, char c) {
    if ((FREE == a) || (FREE == b) || (FREE == c)) {
      return false;
    }
    if ((a == b) && (a == c)) {
      return true;
    }
    return false;
  }

  public void reset() {
    field = new char[]{FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE};
    status = "Game started - Please check a cell";
    winner = FREE;
  }
}
