package id.ac.ui.cs.advprog.tutorial7;

import id.ac.ui.cs.advprog.tutorial7.leap.year.controller.LeapYearController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Tutorial7ApplicationTests {
  @Autowired
  private LeapYearController myController;

  @Test
  void contextLoads() {
    assertThat(myController).isNotNull();
  }

}
