package study.spring.hellospring.exrate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import study.spring.hellospring.api.SimpleApiExecutor;
import study.spring.hellospring.payment.ExRateProvider;

@Component
public class WebApiExRateProvider implements ExRateProvider {

  @Override
  public BigDecimal getExRate(String currency) {
    String url = "https://open.er-api.com/v6/latest/" + currency;

    return runApiForExRate(url);
  }

  private static BigDecimal runApiForExRate(String url) {
    URI uri;
    try {
      uri = new URI(url);
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }

    String response;
    try {
      // 변경될 것을 분리한다.
      response = new SimpleApiExecutor().execute(uri);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      return extractExRate(response);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  private static BigDecimal extractExRate(String response) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    ExRateData data = mapper.readValue(response, ExRateData.class);
    return data.rates().get("KRW");
  }
}
