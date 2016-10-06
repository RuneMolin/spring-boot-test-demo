package dk.nine.test.boundary.github;

import dk.nine.test.entity.GithubUserInfo;

/**
 * @author Rune Molin, rmo@nine.dk
 */
public interface GithubUserService {

  GithubUserInfo getUserInfo(String userName);
}
