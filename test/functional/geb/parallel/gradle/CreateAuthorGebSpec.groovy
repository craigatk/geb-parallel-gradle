package geb.parallel.gradle

import geb.parallel.gradle.pages.AuthorCreatePage
import geb.parallel.gradle.pages.AuthorShowPage
import geb.parallel.gradle.remote.AuthorRemoteControl
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class CreateAuthorGebSpec extends GebReportingSpec {
  @Unroll
  def 'should create authors'() {
    given:
    AuthorRemoteControl authorRemoteControl = new AuthorRemoteControl()

    AuthorCreatePage authorCreatePage = to(AuthorCreatePage)

    when:
    AuthorShowPage authorShowPage = authorCreatePage.createAuthor(firstName, lastName)

    then:
    assert authorShowPage.firstName == firstName
    assert authorShowPage.lastName == lastName

    and:
    assert authorRemoteControl.authorExists(lastName)
    assert authorRemoteControl.findFirstName(lastName) == firstName

    where:
    firstName | lastName
    "George"  | "Orwell"
    "John"    | "Grisham"
    "Stephen" | "King"
  }
}
