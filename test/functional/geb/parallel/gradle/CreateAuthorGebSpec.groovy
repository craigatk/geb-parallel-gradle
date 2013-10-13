package geb.parallel.gradle

import geb.parallel.gradle.pages.AuthorCreatePage
import geb.parallel.gradle.pages.AuthorShowPage
import geb.parallel.gradle.remote.AuthorRemoteControl
import geb.spock.GebReportingSpec

class CreateAuthorGebSpec extends GebReportingSpec {
  def 'should create author'() {
    given:
    AuthorRemoteControl authorRemoteControl = new AuthorRemoteControl()

    AuthorCreatePage authorCreatePage = to(AuthorCreatePage)

    String firstName = "George"
    String lastName = "Orwell"

    when:
    AuthorShowPage authorShowPage = authorCreatePage.createAuthor(firstName, lastName)

    then:
    assert authorShowPage.firstName == firstName
    assert authorShowPage.lastName == lastName

    and:
    assert authorRemoteControl.authorExists(lastName)
    assert authorRemoteControl.findFirstName(lastName) == firstName
  }
}
