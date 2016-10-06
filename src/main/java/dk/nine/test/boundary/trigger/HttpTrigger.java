package dk.nine.test.boundary.trigger;

import dk.nine.test.control.TestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rune Molin, rmo@nine.dk
 */
@RestController
public class HttpTrigger {
  private final TestController controller;

  public HttpTrigger(TestController controller) {
    this.controller = controller;
  }

  @RequestMapping(path = "/process")
  void trigger() {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        controller.doStuff();
      }
    });

    thread.setName("HTTP trigger");
    thread.setDaemon(true);
    thread.start();
  }

}
