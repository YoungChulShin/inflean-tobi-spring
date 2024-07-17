package study.spring.hellospring.payment;

import static java.math.BigDecimal.valueOf;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.spring.hellospring.ObjectFactory;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestObjectFactory.class)
class PaymentServiceSpringTest {

  @Autowired
  private PaymentService paymentService;
  @Autowired
  private ExRateProviderStub exRateProviderStub;

  @Test
  void convertAmount() throws IOException {
    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(1_000));
    Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(valueOf(10_000));
  }

  private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount) throws IOException {
    PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate));

    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
    Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
  }
}