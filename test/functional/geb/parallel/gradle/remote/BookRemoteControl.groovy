package geb.parallel.gradle.remote

import groovyx.remote.client.RemoteControl

class BookRemoteControl {
  RemoteControl remote = new AppRemoteControl()

  Long createBook(String title) {
    remote {
      ctx.bookRemoteUtil.createBook(title)
    }
  }

  boolean bookExists(String title) {
    (findIdByTitle(title) > 0)
  }

  Long findIdByTitle(String title) {
    remote {
      ctx.bookRemoteUtil.findByTitle(title)
    }
  }

  String getBookTitle(Long bookId) {
    remote {
      ctx.bookRemoteUtil.getBookTitle(bookId)
    }
  }
}
