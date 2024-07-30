package study.spring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import study.spring.hellospring.data.OrderJpaRepository;
import study.spring.hellospring.order.OrderRepository;
import study.spring.hellospring.order.OrderService;

@Configuration
@Import(DataConfig.class)
public class OrderConfig {

  @Bean
  public OrderRepository orderRepository() {
    return new OrderJpaRepository();
  }

  @Bean
  public OrderService orderService(JpaTransactionManager transactionManager) {
    return new OrderService(orderRepository(), transactionManager);
  }

}
