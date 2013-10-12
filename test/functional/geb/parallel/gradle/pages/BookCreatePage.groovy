package geb.parallel.gradle.pages

class BookCreatePage extends geb.Page {
  static url = "book/create"

  static content = {
    titleField(wait: true) { $("#titleField") }

    createButton(to: BookShowPage) { $("#createButton") }
  }

  def createBook(String title) {
    titleField.value(title)

    createButton.click()

    return browser.page
  }
}
