package study.spring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.spring.hellospring.exrate.CachedExRateProvider;
import study.spring.hellospring.payment.ExRateProvider;
import study.spring.hellospring.exrate.WebApiExRateProvider;
import study.spring.hellospring.payment.PaymentService;

@Configuration
public class ObjectFactory {

  @Bean
  public PaymentService paymentService() {
    return new PaymentService(exRateProvider());
  }

  @Bean
  public ExRateProvider exRateProvider() {
    return new WebApiExRateProvider();
  }

//  @Bean
//  public ExRateProvider cachedExRateProvider() {
//    return new CachedExRateProvider(exRateProvider());
//  }

}