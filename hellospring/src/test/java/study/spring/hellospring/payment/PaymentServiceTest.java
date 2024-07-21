package study.spring.hellospring.payment;

import static java.math.BigDecimal.valueOf;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

  Clock clock;

  @BeforeEach
  void beforeEach() {
    this.clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
  }

  @Test
  @DisplayName("prepare 메서드가 요구사항 3가지를 잘 충족했는지 검증")
  void prepare() {
    testAmount(valueOf(500), valueOf(5000), this.clock);
    testAmount(valueOf(1_000), valueOf(10_000), this.clock);
    testAmount(valueOf(3_000), valueOf(30_000), this.clock);


//    Assertions.assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
//    Assertions.assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
  }

  @Test
  void validUntil() {
    PaymentService paymentService = new PaymentService(new ExRateProviderStub(valueOf(1_000)), clock);

    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    LocalDateTime now = LocalDateTime.now(this.clock);
    LocalDateTime expectedValidUntil = now.plusMinutes(30L);

    Assertions.assertThat(payment.getValidUntil()).isEqualTo(expectedValidUntil);
  }

  private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount, Clock clock) {
    PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate), clock);

    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
    Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
  }
}