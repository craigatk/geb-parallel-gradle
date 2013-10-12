package geb.parallel.gradle

class Book {

  Author author
  String title

  static constraints = {
    author(nullable: true)
    title(nullable: false, blank: false)
  }
}
