package geb.parallel.gradle

import geb.parallel.gradle.pages.BookEditPage
import geb.parallel.gradle.remote.BookRemoteControl
import geb.spock.GebReportingSpec

class DeleteBookGebSpec extends GebReportingSpec {
  def 'should delete an existing book'() {
    given:
    BookRemoteControl bookRemoteControl = new BookRemoteControl()

    String bookTitle = "My Book To Delete"

    Long bookId = bookRemoteControl.createBook(bookTitle)

    BookEditPage bookEditPage = to BookEditPage, bookId

    when:
    bookEditPage.deleteBook()

    then:
    assert !bookRemoteControl.bookExists(bookTitle)
  }
}
