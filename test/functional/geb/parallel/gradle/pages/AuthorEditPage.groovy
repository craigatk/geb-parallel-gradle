package geb.parallel.gradle.pages

class AuthorEditPage extends geb.Page {
  static url = "author/edit"

  static content = {
    firstNameField(wait: true) { $("#firstNameField") }

    updateButton(wait: true, to: AuthorShowPage) { $("#updateButton") }
    deleteButton(wait: true, to: AuthorListPage) { $("#deleteButton") }
  }

  AuthorShowPage changeFirstName(String newFirstName) {
    firstNameField.value(newFirstName)

    updateButton.click()

    return browser.page
  }

  AuthorListPage deleteAuthor() {
    withConfirm(true) {
      deleteButton.click()
    }

    return browser.page
  }
}
