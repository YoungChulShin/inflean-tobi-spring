package study.spring.hellospring.exrate;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import study.spring.hellospring.payment.ExRateProvider;

public class CachedExRateProvider implements ExRateProvider {

  private final ExRateProvider target;

  private BigDecimal cachedExRate;
  private LocalDateTime cacheExpiaryTime;

  public CachedExRateProvider(ExRateProvider target) {
    this.target = target;
  }

  @Override
  public BigDecimal getExRate(String currency) throws IOException {
    if (cachedExRate == null || cacheExpiaryTime.isBefore(LocalDateTime.now())) {
      cachedExRate = this.target.getExRate(currency);
      cacheExpiaryTime = LocalDateTime.now().plusSeconds(3);
      System.out.println("cache update");
    }
    return cachedExRate;
  }
}
