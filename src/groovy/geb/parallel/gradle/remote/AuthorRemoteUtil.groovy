package geb.parallel.gradle.remote

import geb.parallel.gradle.Author

class AuthorRemoteUtil {
  Long createAuthor(String firstName, String lastName) {
    Author newAuthor = new Author(firstName: firstName, lastName: lastName)

    newAuthor.save()

    return newAuthor.id
  }

  Long findByLastName(String lastName) {
    Author.findByLastName(lastName)?.id
  }

  String findFirstName(String lastName) {
    Author.findByLastName(lastName)?.firstName
  }
}
