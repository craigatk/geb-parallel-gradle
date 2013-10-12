package geb.parallel.gradle

class Author {

  String firstName
  String lastName

  static hasMany = [books: Book]

  static constraints = {
    firstName(nullable: false, blank: false)
    lastName(nullable: true, blank: true)
  }
}
