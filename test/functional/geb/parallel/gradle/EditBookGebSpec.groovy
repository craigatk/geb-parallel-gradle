package geb.parallel.gradle

import geb.parallel.gradle.pages.BookEditPage
import geb.parallel.gradle.pages.BookShowPage
import geb.parallel.gradle.remote.BookRemoteControl
import geb.spock.GebReportingSpec
import spock.lang.Unroll

class EditBookGebSpec extends GebReportingSpec {
  @Unroll
  def 'should edit existing book'() {
    given:
    BookRemoteControl bookRemoteControl = new BookRemoteControl()

    Long bookId = bookRemoteControl.createBook(oldBookTitle)

    BookEditPage bookEditPage = to BookEditPage, bookId

    when:
    BookShowPage bookShowPage = bookEditPage.updateTitle(newBookTitle)

    then:
    assert bookShowPage.bookTitle == newBookTitle

    assert bookRemoteControl.getBookTitle(bookId) == newBookTitle

    where:
    oldBookTitle | newBookTitle
    'Old Book 1' | 'New Book 1'
    'Old Book 2' | 'New Book 2'
    'Old Book 3' | 'New Book 3'
    'Old Book 4' | 'New Book 4'
  }
}
