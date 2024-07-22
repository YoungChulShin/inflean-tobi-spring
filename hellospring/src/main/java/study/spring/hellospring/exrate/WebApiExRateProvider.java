package study.spring.hellospring.exrate;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import study.spring.hellospring.api.ApiTemplate;
import study.spring.hellospring.api.ErApiExRateExtractor;
import study.spring.hellospring.api.HttpClientApiExecutor;
import study.spring.hellospring.payment.ExRateProvider;

@Component
public class WebApiExRateProvider implements ExRateProvider {

  ApiTemplate apiTemplate = new ApiTemplate();

  @Override
  public BigDecimal getExRate(String currency) {
    String url = "https://open.er-api.com/v6/latest/" + currency;

    return apiTemplate.getExRate(url, new HttpClientApiExecutor(), new ErApiExRateExtractor());
  }
}
