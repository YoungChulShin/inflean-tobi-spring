package study.spring.hellospring.learingtest;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClockTest {

  @Test
  void clock() {
    Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    LocalDateTime dt1 = LocalDateTime.now(clock);
    LocalDateTime dt2 = LocalDateTime.now(clock);
    LocalDateTime dt3 = LocalDateTime.now(clock).plusHours(1);

    Assertions.assertThat(dt2).isEqualTo(dt1);
    Assertions.assertThat(dt3).isEqualTo(dt1.plusHours(1));
  }

  // clock을 이용해서 localDatetime.now
  // clock을 테스트에서 사용할 때, 원하는 시간을 지정해서 현재 시간을 가져올 수 있는가?

}
