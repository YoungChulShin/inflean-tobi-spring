package study.spring.hellospring.learingtest;

import java.time.Clock;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClockTest {

  @Test
  void clock() {
    Clock clock = Clock.systemDefaultZone();

    LocalDateTime dt1 = LocalDateTime.now(clock);
    LocalDateTime dt2 = LocalDateTime.now(clock);

    Assertions.assertThat(dt2).isAfter(dt1);
  }

  // clock을 이용해서 localDatetime.now
  // clock을 테스트에서 사용할 때, 원하는 시간을 지정해서 현재 시간을 가져올 수 있는가?

}
