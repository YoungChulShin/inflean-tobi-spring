package study.spring.hellospring.payment;

import java.math.BigDecimal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.spring.hellospring.exrate.WebApiExRateProvider;

@Configuration
public class TestObjectFactory {

  @Bean
  public PaymentService paymentService() {
    return new PaymentService(exRateProvider());
  }

  @Bean
  public ExRateProvider exRateProvider() {
    return new ExRateProviderStub(BigDecimal.valueOf(1000L));
  }
}