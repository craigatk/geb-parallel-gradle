package geb.parallel.gradle

import geb.parallel.gradle.pages.BookEditPage
import geb.parallel.gradle.pages.BookShowPage
import geb.parallel.gradle.remote.BookRemoteControl
import geb.spock.GebReportingSpec

class EditBookGebSpec extends GebReportingSpec {
  def 'should edit existing book'() {
    given:
    BookRemoteControl bookRemoteControl = new BookRemoteControl()

    Long bookId = bookRemoteControl.createBook("An Existing Book")

    BookEditPage bookEditPage = to BookEditPage, bookId

    String updateBookTitle = "Updated Title"

    when:
    BookShowPage bookShowPage = bookEditPage.updateTitle(updateBookTitle)

    then:
    assert bookShowPage.bookTitle == updateBookTitle

    assert bookRemoteControl.getBookTitle(bookId) == updateBookTitle
  }
}
