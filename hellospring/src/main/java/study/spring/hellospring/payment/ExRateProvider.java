package study.spring.hellospring.payment;

import java.io.IOException;
import java.math.BigDecimal;

// 인터페이스는 자기를 사용하는 쪽에 있는게 더 자연스럽다
public interface ExRateProvider {

  BigDecimal getExRate(String currency) throws IOException;
}
