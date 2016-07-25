import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxDriver

waiting {
  timeout = 15
  retryInterval = 0.5
}

driver = {
  def theDriver = new FirefoxDriver()
  theDriver.manage().window().setSize(new Dimension(600, 800))

  return theDriver
}