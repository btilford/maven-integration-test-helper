

using "geb"

scenario "hello index", {
  when "index is visited", {
    go "http://localhost:8989"
  }
  then "we should be at the index page", {
    page.title.shouldBe "Hello Index"
  }
  and "there should be a Hello World! heading", {
    $("h2",0).text().shouldBe "Hello World!"
  }
}