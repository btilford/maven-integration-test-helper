import org.junit.Test
import com.gargoylesoftware.htmlunit.WebClient


class IndexIT {

  @Test void index() {
    println "@Test index()"
    def browser = new WebClient()
    def page = browser.getPage("http://localhost:8989")

    assert page.getByXPath("//title")[0] == "Hello Index"
    assert page.getByXpath("//h2")[0] == "Hello World!"

  }
}



