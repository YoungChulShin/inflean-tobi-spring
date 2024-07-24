package study.spring.hellospring.exrate;

import java.math.BigDecimal;
import org.springframework.web.client.RestTemplate;
import study.spring.hellospring.payment.ExRateProvider;

public class RestTemplateExRateProvider implements ExRateProvider {

  private final RestTemplate restTemplate;

  public RestTemplateExRateProvider(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public BigDecimal getExRate(String currency) {
    String url = "https://open.er-api.com/v6/latest/" + currency;

    return restTemplate.getForObject(url, ExRateData.class).rates().get("KRW");

    // 08:28
  }
}
