package eu.irian.demo.tictactoe.util;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * To enable the TobagoExceptionHandler insert this class in the faces-config.xml like:
 * <pre>
 *   &lt;factory&gt;
 *     &lt;exception-handler-factory&gt;
 *       org.apache.myfaces.tobago.example.demo.TobagoExceptionHandlerFactory
 *     &lt;/exception-handler-factory&gt;
 *   &lt;/factory&gt;
 * </pre>
 *
 */
public class TobagoExceptionHandlerFactory extends ExceptionHandlerFactory {

  private ExceptionHandlerFactory parent;

  public TobagoExceptionHandlerFactory(final ExceptionHandlerFactory parent) {
    this.parent = parent;
  }

  @Override
  public ExceptionHandler getExceptionHandler() {
    ExceptionHandler result = parent.getExceptionHandler();
    result = new TobagoExceptionHandler(result);
    return result;
  }

}
