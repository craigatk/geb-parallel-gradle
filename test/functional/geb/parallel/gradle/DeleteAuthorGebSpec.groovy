package geb.parallel.gradle

import geb.parallel.gradle.pages.AuthorEditPage
import geb.parallel.gradle.remote.AuthorRemoteControl
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class DeleteAuthorGebSpec extends GebReportingSpec {
  @Unroll
  def 'should delete existing author'() {
    given:
    AuthorRemoteControl authorRemoteControl = new AuthorRemoteControl()

    Long authorId = authorRemoteControl.createAuthor(firstName, lastName)

    AuthorEditPage authorEditPage = to AuthorEditPage, authorId

    when:
    authorEditPage.deleteAuthor()

    then:
    assert !authorRemoteControl.authorExists(lastName)

    where:
    firstName | lastName
    "Richard" | "Castle"
    "Author"  | "Remove1"
    "Author"  | "Remove2"
    "Author"  | "Remove3"
    "Author"  | "Remove4"
  }
}
