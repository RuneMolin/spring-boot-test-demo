package dk.nine.test.boundary.github;

import dk.nine.test.entity.GithubUserInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rune Molin, rmo@nine.dk
 */
@Component
public class RestTemplateGithubUserService implements GithubUserService {
  private final String ENDPOINT = "https://api.github.com/users/%s";

  @Override
  public GithubUserInfo getUserInfo(String userName) {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(String.format(ENDPOINT, userName), GithubUserInfo.class);
  }
}
