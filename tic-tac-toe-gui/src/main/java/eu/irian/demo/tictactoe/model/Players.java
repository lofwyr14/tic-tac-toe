package eu.irian.demo.tictactoe.model;

public enum Players {

  player1('x', "fa-times"),
  player2('o', "fa-circle-o"),
  nobody(' ', "");


  private final char character;
  private final String icon;

  Players( final char character, final  String icon) {
    this.character = character;
    this.icon = icon;
  }

  public char getCharacter() {
    return character;
  }

  public String getIcon() {
    return icon;
  }

  public String getCssClass() {
    return name();
  }

}
