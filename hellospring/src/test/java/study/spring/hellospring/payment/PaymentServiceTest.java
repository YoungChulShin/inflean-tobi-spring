package study.spring.hellospring.payment;

import static java.math.BigDecimal.valueOf;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

  @Test
  @DisplayName("prepare 메서드가 요구사항 3가지를 잘 충족했는지 검증")
  void prepare() throws IOException {

    Set<Long> a = new HashSet<>();
    Set<Long> b = new HashSet<>();

    List<Object> objects = new ArrayList<>();
    objects.add("a");

    testAmount(valueOf(500), valueOf(5000));
    testAmount(valueOf(1_000), valueOf(10_000));
    testAmount(valueOf(3_000), valueOf(30_000));


//    Assertions.assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
//    Assertions.assertThat(payment.getValidUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
  }

  private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount) throws IOException {
    PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate));

    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    Assertions.assertThat(payment.getExRate()).isEqualByComparingTo(exRate);
    Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
  }
}