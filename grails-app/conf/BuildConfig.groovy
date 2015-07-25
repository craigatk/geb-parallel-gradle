grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

def gebVersion = "0.10.0"
def webdriverVersion = "2.46.0"

grails.project.dependency.resolution = {
  // inherit Grails' default dependencies
  inherits("global") {
    // specify dependency exclusions here; for example, uncomment this to disable ehcache:
    // excludes 'ehcache'
  }
  log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
  checksums true // Whether to verify checksums on resolve
  legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

  repositories {
    inherits true // Whether to inherit repository definitions from plugins

    grailsPlugins()
    grailsHome()
    grailsCentral()

    mavenLocal()
    mavenCentral()

    // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
    //mavenRepo "http://snapshots.repository.codehaus.org"
    //mavenRepo "http://repository.codehaus.org"
    //mavenRepo "http://download.java.net/maven/2/"
    //mavenRepo "http://repository.jboss.com/maven2/"
  }

  dependencies {
    // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.

    test "org.gebish:geb-spock:${gebVersion}"

    test "org.seleniumhq.selenium:selenium-support:${webdriverVersion}"
    test "org.seleniumhq.selenium:selenium-chrome-driver:${webdriverVersion}"
    test "org.seleniumhq.selenium:selenium-firefox-driver:${webdriverVersion}"

    test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
  }

  plugins {
    // plugins for the build system only
    build ":tomcat:7.0.55"

    // plugins for the compile step
    compile ":scaffolding:2.1.2"
    compile ':cache:1.1.8'

    // plugins needed at runtime but not for compilation
    runtime ":hibernate4:4.3.6.1" // or ":hibernate:3.6.10.18"
    runtime ":database-migration:1.4.0"

    compile ":asset-pipeline:2.3.8"

    test ":remote-control:1.5"
    test ":geb:${gebVersion}"

    compile ":github-gist:0.2"
  }
}
