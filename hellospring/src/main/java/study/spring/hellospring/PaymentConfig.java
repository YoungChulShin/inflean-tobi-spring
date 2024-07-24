package study.spring.hellospring;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import study.spring.hellospring.api.ApiTemplate;
import study.spring.hellospring.exrate.RestTemplateExRateProvider;
import study.spring.hellospring.payment.ExRateProvider;
import study.spring.hellospring.exrate.WebApiExRateProvider;
import study.spring.hellospring.payment.PaymentService;

@Configuration
public class PaymentConfig {

  @Bean
  public PaymentService paymentService() {
    return new PaymentService(exRateProvider(), clock());
  }

  @Bean
  public ApiTemplate apiTemplate() {
    return new ApiTemplate();
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public ExRateProvider exRateProvider() {
    return new RestTemplateExRateProvider(restTemplate());
  }

  @Bean
  public Clock clock() {
    return Clock.systemDefaultZone();
  }
}