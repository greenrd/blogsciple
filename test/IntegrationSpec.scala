package test

import org.specs2._
import play.api.test._
import play.api.test.Helpers._
import java.util.concurrent.TimeUnit

/**
 * Acceptance tests which try to check Blogsciple behaves equivalently to Blogsiple
 */
class IntegrationSpec extends Specification { def is =
  
  "Should have an edit button" ! {
      running(TestServer(3333), HTMLUNIT) { browser =>

        browser.goTo("http://localhost:3333/")
        
        browser.await.atMost(5, TimeUnit.SECONDS).until("button").withText("Edit").isPresent
        
        // If the wait above succeeded, we succeeded
        success
      }
  }.pendingUntilFixed
  
}