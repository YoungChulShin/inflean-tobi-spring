package study.spring.hellospring.payment;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.spring.hellospring.exrate.WebApiExRateProvider;

class PaymentServiceTest {

  @Test
  @DisplayName("prepare 메서드가 요구사항 3가지를 잘 충족했는지 검증")
  void prepare() throws IOException {
    PaymentService paymentService = new PaymentService(new WebApiExRateProvider());

    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    Assertions.assertThat(payment.getExRate()).isNotNull();
    Assertions.assertThat(payment.getConvertedAmount())
        .isEqualTo(payment.getExRate().multiply(payment.getForeignCurrencyAmount()));
    Assertions.assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
    Assertions.assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
  }
}