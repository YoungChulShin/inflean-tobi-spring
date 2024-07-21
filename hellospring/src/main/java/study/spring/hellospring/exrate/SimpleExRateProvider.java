package study.spring.hellospring.exrate;

import java.math.BigDecimal;
import study.spring.hellospring.payment.ExRateProvider;

public class SimpleExRateProvider implements ExRateProvider {

  @Override
  public BigDecimal getExRate(String currency) {
    if (currency.equals("USD")) {
      return BigDecimal.valueOf(1000);
    }

    throw new IllegalArgumentException("구현되지 않는 통화입니다");
  }
}
