package geb.parallel.gradle.remote

import groovyx.remote.client.RemoteControl

class AuthorRemoteControl {
  RemoteControl remote = new AppRemoteControl()

  Long createAuthor(String firstName, String lastName) {
    remote {
      ctx.authorRemoteUtil.createAuthor(firstName, lastName)
    }
  }

  boolean authorExists(String lastName) {
    return (findIdByLastName(lastName) > 0)
  }

  Long findIdByLastName(String lastName) {
    remote {
      ctx.authorRemoteUtil.findByLastName(lastName)
    }
  }

  String findFirstName(String lastName) {
    remote {
      ctx.authorRemoteUtil.findFirstName(lastName)
    }
  }
}
