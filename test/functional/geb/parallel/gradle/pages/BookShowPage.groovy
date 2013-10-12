package geb.parallel.gradle.pages

class BookShowPage extends geb.Page {
  static content = {
    titleField(wait: true) { $("#titleValue") }
  }

  String getBookTitle() {
    titleField.text()
  }
}
