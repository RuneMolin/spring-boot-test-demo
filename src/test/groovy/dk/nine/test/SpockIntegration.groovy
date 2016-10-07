package dk.nine.test

import dk.nine.test.boundary.db.Datastore
import dk.nine.test.boundary.github.GithubUserService
import dk.nine.test.entity.GithubUserInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

/**
 * @author Rune Molin, rmo@nine.dk
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpockIntegration extends Specification {

  @Autowired
  WebApplicationContext context

  @Autowired
  private TestRestTemplate template;

  def "should boot up without errors"() {
    expect: "web application context exists"
    context != null
  }

  def "test with mocks"() {
    given:
    def mockService = Mock(GithubUserService)
    def mockStore = Mock(Datastore)

    when:
    def response = template.getForEntity("/process", Object.class)

    then:
    response.statusCode == HttpStatus.OK

    1 * mockService.getUserInfo(_) << new GithubUserInfo('jdoe', '42', 'foo', 'bar', 'John Doe')

    1 * mockStore.saveInSomeDatastore(_ as GithubUserInfo) >> { GithubUserInfo userInfo ->
      assert userInfo.name == 'John B. Doe'
    }
  }

}
