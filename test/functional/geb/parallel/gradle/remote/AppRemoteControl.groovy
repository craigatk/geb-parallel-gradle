package geb.parallel.gradle.remote

// <gist id="6999634">
class AppRemoteControl extends groovyx.remote.client.RemoteControl {
  AppRemoteControl() {
    super(new groovyx.remote.transport.http.HttpTransport(getRemoteControlUrl()))
  }

  static String getRemoteControlUrl() {
    String port = System.getProperty('server.port', '8080')

    return "http://localhost:${port}/geb-parallel-gradle/grails-remote-control"
  }
}
// </gist>
