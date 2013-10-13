package geb.parallel.gradle

import geb.parallel.gradle.pages.AuthorEditPage
import geb.parallel.gradle.remote.AuthorRemoteControl
import geb.spock.GebReportingSpec

class DeleteAuthorGebSpec extends GebReportingSpec {
  def 'should delete existing author'() {
    given:
    AuthorRemoteControl authorRemoteControl = new AuthorRemoteControl()

    String firstName = "Richard"
    String lastName = "Castle"

    Long authorId = authorRemoteControl.createAuthor(firstName, lastName)

    AuthorEditPage authorEditPage = to AuthorEditPage, authorId

    when:
    authorEditPage.deleteAuthor()

    then:
    assert !authorRemoteControl.authorExists(lastName)
  }
}
