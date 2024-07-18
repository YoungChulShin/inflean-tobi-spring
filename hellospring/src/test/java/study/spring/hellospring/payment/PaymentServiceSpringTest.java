package study.spring.hellospring.payment;

import static java.math.BigDecimal.valueOf;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
class PaymentServiceSpringTest {

  @Autowired
  private PaymentService paymentService;
  @Autowired
  private Clock clock;

  @Test
  void convertAmount() throws IOException {
    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(1_000));
    Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(valueOf(10_000));
  }
}