package eu.irian.demo.tictactoe.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Named
@SessionScoped
public class Game implements Serializable {

  private static final Logger LOG = LoggerFactory.getLogger(Game.class);

  private String lastMove;

  @Min(0)
  @Max(8)
  public String move(final int cell) {
    if (LOG.isInfoEnabled()) {
      LOG.info("Current move is '{}'", cell);
    }

    lastMove = "" + cell;

    return "/tic-tac-toe.xhtml";
  }

  public String getLastMove() {
    return lastMove;
  }

}
