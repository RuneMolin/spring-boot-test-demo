package dk.nine.test;

import dk.nine.test.boundary.db.Datastore;
import dk.nine.test.boundary.github.GithubUserService;
import dk.nine.test.entity.GithubUserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * @author Rune Molin, rmo@nine.dk
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DummyIntegration {

  @MockBean
  private Datastore store;

  @MockBean
  private GithubUserService service;


  @Autowired
  private TestRestTemplate restTemplate;

  private final GithubUserInfo mockAnswer = new GithubUserInfo("42", "foo", "bar", "baz", "John Doe");

  @Captor
  ArgumentCaptor<GithubUserInfo> captor;

  @Test
  public void poke() {
    given(service.getUserInfo("RuneMolin")).willReturn(mockAnswer);

    ResponseEntity<Object> entity = restTemplate.getForEntity("/process", Object.class);

    verify(store).saveInSomeDatastore(captor.capture());

    Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());

    Assert.assertEquals("John Doe", captor.getValue().getName());
  }
}
