package eu.irian.demo.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Game implements Serializable {

  private static final Logger LOG = LoggerFactory.getLogger(Game.class);

  private String name;

  public String sayHello() {
    if (LOG.isInfoEnabled()) {
      LOG.info("Action was called, name is '{}'", name);
    }
    return "/result.xhtml";
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
