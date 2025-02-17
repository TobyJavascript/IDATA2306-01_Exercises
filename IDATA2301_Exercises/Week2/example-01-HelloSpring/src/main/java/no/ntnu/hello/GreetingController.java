package no.ntnu.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST API controller which responds to HTTP requests.
 */
@RestController
@RequestMapping("/")
public class GreetingController {

  /**
   * Responds to HTTP GET requests for /hello.
   *
   * @return a greeting message
   */
  @GetMapping("/hello")
  public String greeting() {
    return "Hei, World!";
  }

  /**
   * Responds to HTTP GET requests for /hei with a 301 redirect.
   *
   * @return a ResponseEntity with status 301 and a message in the body
   */
  @GetMapping("/hei")
  public ResponseEntity<String> redirectHei() {
    return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
                         .body("Use /hello");
  }

  /**
   * Handles DELETE requests to /hello and responds with 401 Unauthorized.
   *
   * @return a ResponseEntity with status 401
   */
  @DeleteMapping("/hello")
  public ResponseEntity<String> deleteHello() {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                         .body("Unauthorized");
  }
}