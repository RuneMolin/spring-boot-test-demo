package dk.nine.test.boundary.db;

import dk.nine.test.entity.GithubUserInfo;
import org.springframework.stereotype.Component;

/**
 * @author Rune Molin, rmo@nine.dk
 */
@Component
public class SystemOutDatastore implements Datastore {
  @Override
  public void saveInSomeDatastore(GithubUserInfo userInfo) {
    System.out.println(
      String.format("Login: %s  id: %s  avatar: %s  url: %s  name: %s",
        userInfo.getLogin(),
        userInfo.getId(),
        userInfo.getAvatarUrl(),
        userInfo.getUrl(),
        userInfo.getName()));
  }
}
