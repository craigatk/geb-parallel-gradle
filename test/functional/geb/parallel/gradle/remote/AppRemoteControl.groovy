package geb.parallel.gradle.remote

import groovyx.remote.client.RemoteControl
import groovyx.remote.transport.http.HttpTransport

class AppRemoteControl extends RemoteControl {
  AppRemoteControl() {
    super(new HttpTransport(getRemoteControlUrl()))
  }

  static String getRemoteControlUrl() {
    String port = System.getProperty('server.port', '8080')

    return "http://localhost:${port}/geb-parallel-gradle/grails-remote-control"
  }
}
