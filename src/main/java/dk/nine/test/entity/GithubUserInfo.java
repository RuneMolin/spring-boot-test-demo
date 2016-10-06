package dk.nine.test.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rune Molin, rmo@nine.dk
 */

/*
 "login": "RuneMolin",
  "id": 8211969,
  "avatar_url": "https://avatars.githubusercontent.com/u/8211969?v=3",
  "gravatar_id": "",
  "url": "https://api.github.com/users/RuneMolin",
  "html_url": "https://github.com/RuneMolin",
  "followers_url": "https://api.github.com/users/RuneMolin/followers",
  "following_url": "https://api.github.com/users/RuneMolin/following{/other_user}",
  "gists_url": "https://api.github.com/users/RuneMolin/gists{/gist_id}",
  "starred_url": "https://api.github.com/users/RuneMolin/starred{/owner}{/repo}",
  "subscriptions_url": "https://api.github.com/users/RuneMolin/subscriptions",
  "organizations_url": "https://api.github.com/users/RuneMolin/orgs",
  "repos_url": "https://api.github.com/users/RuneMolin/repos",
  "events_url": "https://api.github.com/users/RuneMolin/events{/privacy}",
  "received_events_url": "https://api.github.com/users/RuneMolin/received_events",
  "type": "User",
  "site_admin": false,
  "name": "Rune Molin",
  "company": "Nine A/S",
  "blog": null,
  "location": "Copenhagen",
  "email": null,
  "hireable": null,
  "bio": null,
  "public_repos": 14,
  "public_gists": 0,
  "followers": 1,
  "following": 2,
  "created_at": "2014-07-19T22:30:03Z",
  "updated_at": "2016-10-04T08:34:41Z"
 */
public class GithubUserInfo {
  private final String login;
  private final String id;
  private final String avatarUrl;
  private final String url;
  private final String name;


  @JsonCreator

  public GithubUserInfo(@JsonProperty("login") String login,
                        @JsonProperty("id") String id,
                        @JsonProperty("avatar_url") String avatarUrl,
                        @JsonProperty("url") String url,
                        @JsonProperty("name") String name) {
    this.login = login;
    this.id = id;
    this.avatarUrl = avatarUrl;
    this.url = url;
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public String getId() {
    return id;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public String getUrl() {
    return url;
  }

  public String getName() {
    return name;
  }
}
