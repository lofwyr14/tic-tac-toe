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

@Named
@SessionScoped
public class Game implements Serializable {

  private static final Logger LOG = LoggerFactory.getLogger(Game.class);

  @Inject
  MoveService moveService;

  private String lastMove;
  private char[] field;
  private char winner;

  public Game() {
    field = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
  }

  @Min(0)
  @Max(8)
  public String move(final int cell) {
    if (LOG.isInfoEnabled()) {
      LOG.info("Current move is '{}'", cell);
    }

    field[cell] = 'x';
    if(gameOver()){
      LOG.info("Game over " + field);
      return "/tic-tac-toe.xhtml";
    }
    int oponentMove = moveService.move(field);
    LOG.info("Oponent move: " + oponentMove);
    field[oponentMove] = 'o';
    if(gameOver()){
      LOG.info("Game over " + field);
      return "/tic-tac-toe.xhtml";
    }

    lastMove = "" + cell;

    return "/tic-tac-toe.xhtml";
  }

  public String getLastMove() {
    return lastMove;
  }

  private boolean gameOver(){
    if(hasThreeInARow(field[0], field[1], field[2])) {
      this.winner = field[0];
      return true;
    }

    if(hasThreeInARow(field[3], field[4], field[5])) {
      this.winner =  field[3];
      return true;
    }

    if(hasThreeInARow(field[6], field[7], field[8])) {
      this.winner = field[6];
      return true;
    }

    if(hasThreeInARow(field[0], field[3], field[6])) {
      this.winner = field[0];
      return true;
    }

    if(hasThreeInARow(field[1], field[4], field[7])) {
      this.winner = field[1];
      return true;
    }

    if(hasThreeInARow(field[2], field[5], field[8])) {
      this.winner = field[2];
      return true;
    }

    if(hasThreeInARow(field[0], field[4], field[8])) {
      this.winner = field[0];
      return true;
    }

    if(hasThreeInARow(field[2], field[4], field[6])) {
      this.winner = field[2];
      return true;
    }

    if( ! isMoveIsPossible()){
      return true;
    }
    this.winner = ' ';
    return false;
  }

  private boolean isMoveIsPossible() {
    for (int i = 0; i < field.length; i++ ){
      if(field[i]== ' '){
        return true;
      }
    }
    return false;
  }

  private boolean hasThreeInARow(char a, char b, char c) {
    if( (' ' == a)  || (' ' == b) || (' ' == c)){
      return false;
    }
    if((a == b) && (a == c)){
      return true;
    }
    return false;
  }

}
