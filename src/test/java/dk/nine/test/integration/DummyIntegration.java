package dk.nine.test.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Rune Molin, rmo@nine.dk
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DummyIntegration {

  @Test
  public void sanityCheck() {
    System.out.println("*** SANITY CHECK ***");
    assert true;
  }
}
