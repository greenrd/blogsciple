package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

/**
 * This code is unchanged from the Play 2 Scala g8 template - ignore it! 
 */
class ApplicationSpec extends Specification {
  
  "Application" should {
    
    "send 404 on a bad request" in {
      running(FakeApplication()) {
        routeAndCall(FakeRequest(GET, "/boum")) must beNone        
      }
    }
    
    "render the index page" in {
      running(FakeApplication()) {
        val home = routeAndCall(FakeRequest(GET, "/")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("Your new application is ready.")
      }
    }
  }
}