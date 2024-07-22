package study.spring.hellospring.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

public class ApiTemplate {

  private final ApiExecutor apiExecutor;
  private final ExRateExtractor exRateExtractor;

  public ApiTemplate() {
    this.apiExecutor = new HttpClientApiExecutor();
    this.exRateExtractor = new ErApiExRateExtractor();
  }

  public ApiTemplate(ApiExecutor apiExecutor, ExRateExtractor exRateExtractor) {
    this.apiExecutor = apiExecutor;
    this.exRateExtractor = exRateExtractor;
  }

  public BigDecimal getExRate(String url) {
    return this.getExRate(url, apiExecutor, exRateExtractor);
  }

  public BigDecimal getExRate(String url, ApiExecutor apiExecutor, ExRateExtractor exRateExtractor) {
    URI uri;
    try {
      uri = new URI(url);
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }

    String response;
    try {
      // 변경될 것을 분리한다.
      response = apiExecutor.execute(uri);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      return exRateExtractor.extract(response);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

}
