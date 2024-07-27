package study.spring.hellospring;

import java.math.BigDecimal;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.hellospring.data.OrderRepository;
import study.spring.hellospring.order.Order;

public class DataClient {

  public static void main(String[] args) {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
    OrderRepository repository = beanFactory.getBean(OrderRepository.class);

    Order order = new Order("100", BigDecimal.TEN);
    repository.save(order);

    System.out.println(order);
  }

}
