package geb.parallel.gradle

import geb.parallel.gradle.pages.BookEditPage
import geb.parallel.gradle.remote.BookRemoteControl
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class DeleteBookGebSpec extends GebReportingSpec {
  @Unroll
  def 'should delete an existing book'() {
    given:
    BookRemoteControl bookRemoteControl = new BookRemoteControl()

    Long bookId = bookRemoteControl.createBook(bookTitle)

    BookEditPage bookEditPage = to BookEditPage, bookId

    when:
    bookEditPage.deleteBook()

    then:
    assert !bookRemoteControl.bookExists(bookTitle)

    where:
    bookTitle         | _
    'Book1 to delete' | _
    'Book2 to delete' | _
    'Book3 to delete' | _
    'Book4 to delete' | _
  }
}
