package study.spring.hellospring;

import java.math.BigDecimal;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import study.spring.hellospring.order.Order;
import study.spring.hellospring.order.OrderService;
import study.spring.hellospring.order.OrderServiceImpl;

public class OrderClient {

  public static void main(String[] args) {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
    OrderService service = beanFactory.getBean(OrderService.class);

    Order order = service.createOrder("0100", BigDecimal.TEN);
    System.out.println(order);
  }
}
