package eu.irian.demo.tictactoe.ui;

import eu.irian.demo.tictactoe.ai.MoveService;
import eu.irian.demo.tictactoe.model.Field;
import eu.irian.demo.tictactoe.model.Players;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Named
@SessionScoped
public class Game implements Serializable {

  private static final Logger LOG = LoggerFactory.getLogger(Game.class);

  @Inject
  private MoveService moveService;
  private Field field;

  public Game() {
    reset();
  }

  @Min(0) // todo: checker
  @Max(8) // todo: checker
  public String move(final int cell) {
    LOG.info("Users move is '{}'", cell);
    field.move(cell, Players.player1);
    if (!field.isGameOver()) {
      int opponentMove = moveService.move(field.serialize());
      LOG.info("Opponents move is '{}'", opponentMove);
      field.move(opponentMove, Players.player2);
      message("Opponents last move was: " + field.coordsString(opponentMove));
    }
    if (field.isGameOver()) {
      LOG.info("Game over " + field);
      switch (field.getWinner()) {
        case nobody:
          message("It is a tie!");
          break;
        case player1:
          message("You are the winner!");
          break;
        case player2:
          message("Opponent is the winner!");
          break;
      }
    }

    return "/tic-tac-toe.xhtml";
  }

  public Field getField() {
    return field;
  }

  public void reset() {
    field = new Field();
    message("Game started - Please check a cell");
  }

  private void message(final String summary) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    facesContext.addMessage(null, new FacesMessage(summary));
  }
}
