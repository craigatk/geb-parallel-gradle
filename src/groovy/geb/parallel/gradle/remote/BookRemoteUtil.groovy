package geb.parallel.gradle.remote

import geb.parallel.gradle.Book

class BookRemoteUtil {
  Long createBook(String title) {
    Book newBook = new Book(title: title)

    newBook.save()

    return newBook.id
  }

  Long findByTitle(String title) {
    Book.findByTitle(title)?.id
  }

  String getBookTitle(Long bookId) {
    Book.read(bookId)?.title
  }
}
