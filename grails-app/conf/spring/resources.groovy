import geb.parallel.gradle.remote.BookRemoteUtil
import grails.util.Environment

// Place your Spring DSL code here
beans = {
  if (Environment.current == Environment.TEST) {
    bookRemoteUtil(BookRemoteUtil)
  }
}
