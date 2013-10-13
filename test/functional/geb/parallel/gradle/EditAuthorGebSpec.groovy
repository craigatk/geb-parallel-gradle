package geb.parallel.gradle

import geb.parallel.gradle.pages.AuthorEditPage
import geb.parallel.gradle.pages.AuthorShowPage
import geb.parallel.gradle.remote.AuthorRemoteControl
import geb.spock.GebReportingSpec

class EditAuthorGebSpec extends GebReportingSpec {
  def 'should edit existing author'() {
    given:
    AuthorRemoteControl authorRemoteControl = new AuthorRemoteControl()

    String oldFirstName = "Isaacc"
    String lastName = "Asimov"

    Long authorId = authorRemoteControl.createAuthor(oldFirstName, lastName)

    String newFirstName = "Isaac"

    AuthorEditPage authorEditPage = to AuthorEditPage, authorId

    when:
    AuthorShowPage authorShowPage = authorEditPage.changeFirstName(newFirstName)

    then:
    assert authorShowPage.firstName == newFirstName

    and:
    assert authorRemoteControl.findFirstName(lastName) == newFirstName
  }
}
