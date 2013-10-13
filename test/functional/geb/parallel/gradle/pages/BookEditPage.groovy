package geb.parallel.gradle.pages

class BookEditPage extends geb.Page {
  static url = "book/edit"

  static content = {
    titleField(wait: true) { $("#titleField") }

    updateButton(to: BookShowPage) { $("#updateButton") }
    deleteButton(to: BookListPage) { $("#deleteButton") }
  }

  BookShowPage updateTitle(String newTitle) {
    titleField.value(newTitle)

    updateButton.click()

    return browser.page
  }

  BookListPage deleteBook() {
    withConfirm(true) {
      deleteButton.click()
    }

    return browser.page
  }
}
