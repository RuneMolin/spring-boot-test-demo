package dk.nine.test.control;

import dk.nine.test.boundary.db.Datastore;
import dk.nine.test.boundary.github.GithubUserService;
import dk.nine.test.entity.GithubUserInfo;
import org.springframework.stereotype.Component;

/**
 * @author Rune Molin, rmo@nine.dk
 */
@Component
public class TestController {
  private final GithubUserService githubUserService;
  private final Datastore store;

  public TestController(GithubUserService githubUserService, Datastore store) {
    this.githubUserService = githubUserService;
    this.store = store;
    System.out.println("*** CONTROLLER STARTING ***");
  }

  public void doStuff() {
    GithubUserInfo userInfo = githubUserService.getUserInfo("RuneMolin");

    store.saveInSomeDatastore(userInfo);
  }
}
