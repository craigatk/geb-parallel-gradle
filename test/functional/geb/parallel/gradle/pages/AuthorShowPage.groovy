package geb.parallel.gradle.pages

class AuthorShowPage extends geb.Page {
  static url = "author/show"

  static content = {
    firstNameValue(wait: true) { $("#firstName") }
    lastNameValue(wait: true) { $("#lastName") }
  }

  String getFirstName() {
    firstNameValue.text()
  }

  String getLastName() {
    lastNameValue.text()
  }
}
