package study.spring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExRateProvider {

  BigDecimal getExRate(String currency) throws IOException;
}
