package geb.parallel.gradle

import geb.parallel.gradle.pages.BookCreatePage
import geb.parallel.gradle.pages.BookShowPage
import geb.parallel.gradle.remote.BookRemoteControl
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class CreateBookGebSpec extends GebReportingSpec {
  @Unroll
  def 'should create book'() {
    given:
    BookRemoteControl bookRemoteControl = new BookRemoteControl()

    BookCreatePage bookCreatePage = to(BookCreatePage)

    when:
    BookShowPage bookShowPage = bookCreatePage.createBook(bookTitle)

    then:
    assert bookShowPage.bookTitle == bookTitle

    assert bookRemoteControl.bookExists(bookTitle)

    where:
    bookTitle              | _
    "My New Book"          | _
    "My Second new book"   | _
    "Yet another new book" | _
  }
}
