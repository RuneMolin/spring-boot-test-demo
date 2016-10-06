package dk.nine.test.boundary.db;

import dk.nine.test.entity.GithubUserInfo;

/**
 * @author Rune Molin, rmo@nine.dk
 */
public interface Datastore {
  void saveInSomeDatastore(GithubUserInfo userInfo);
}
