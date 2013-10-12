package geb.parallel.gradle

import geb.parallel.gradle.pages.BookCreatePage
import geb.parallel.gradle.pages.BookShowPage
import geb.parallel.gradle.remote.BookRemoteControl
import geb.spock.GebReportingSpec

class CreateBookGebSpec extends GebReportingSpec {
  def 'should create book'() {
    given:
    BookRemoteControl bookRemoteControl = new BookRemoteControl()

    BookCreatePage bookCreatePage = to(BookCreatePage)

    String bookTitle = "My New Book"

    when:
    BookShowPage bookShowPage = bookCreatePage.createBook(bookTitle)

    then:
    assert bookShowPage.bookTitle == bookTitle

    assert bookRemoteControl.bookExists(bookTitle)
  }
}
