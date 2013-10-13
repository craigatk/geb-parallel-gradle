package geb.parallel.gradle.pages

class AuthorCreatePage extends geb.Page {
  static url = "author/create"

  static content = {
    firstNameField(wait: true) { $("#firstNameField") }
    lastNameField(wait: true) { $("#lastNameField") }

    createButton(to: AuthorShowPage) { $("#createButton") }
  }

  AuthorShowPage createAuthor(String firstName, String lastName) {
    firstNameField.value(firstName)
    lastNameField.value(lastName)

    createButton.click()

    return browser.page
  }
}
