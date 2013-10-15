geb-parallel-gradle
===================

Sample project for running Grails functional Geb tests in parallel using Gradle.

This project has the Gradle wrapper installed, so it will automatically download and use the right version of Gradle.

First, compile the project with the Grails wrapper

Windows:
```
grailsw compile
```

Mac/Linux:
```
./grailsw compile
```

To run the tests in parallel, run

Windows:
```
gradlew test
```

Mac/Linux:
```
./gradlew test
```