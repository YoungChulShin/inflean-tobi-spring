package study.spring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.hellospring.payment.Payment;
import study.spring.hellospring.payment.PaymentService;

public class Client {

  public static void main(String[] args) throws IOException, InterruptedException {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(PaymentConfig.class);
    PaymentService paymentService = beanFactory.getBean(PaymentService.class);

    Payment payment1 = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
    System.out.println("Payment1: " + payment1);
  }

}
