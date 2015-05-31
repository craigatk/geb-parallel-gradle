package geb.parallel.gradle

import geb.parallel.gradle.pages.AuthorEditPage
import geb.parallel.gradle.pages.AuthorShowPage
import geb.parallel.gradle.remote.AuthorRemoteControl
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class EditAuthorGebSpec extends GebReportingSpec {

  @Unroll
  def 'should edit existing author'() {
    given:
    AuthorRemoteControl authorRemoteControl = new AuthorRemoteControl()

    Long authorId = authorRemoteControl.createAuthor(oldFirstName, lastName)

    AuthorEditPage authorEditPage = to AuthorEditPage, authorId

    when:
    AuthorShowPage authorShowPage = authorEditPage.changeFirstName(newFirstName)

    then:
    assert authorShowPage.firstName == newFirstName

    and:
    assert authorRemoteControl.findFirstName(lastName) == newFirstName

    where:
    oldFirstName | lastName | newFirstName
    "Old1"       | "Last1"  | "New1"
    "Old2"       | "Last2"  | "New2"
    "Old3"       | "Last3"  | "New3"
    "Old4"       | "Last4"  | "New4"
  }
}
