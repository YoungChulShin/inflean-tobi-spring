package study.spring.hellospring;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import study.spring.hellospring.data.JdbcOrderRepository;
import study.spring.hellospring.order.OrderRepository;
import study.spring.hellospring.order.OrderService;
import study.spring.hellospring.order.OrderServiceImpl;

@Configuration
@Import(DataConfig.class)
@EnableTransactionManagement
public class OrderConfig {

  @Bean
  public OrderRepository orderRepository(DataSource dataSource) {
    return new JdbcOrderRepository(dataSource);
  }

  @Bean
  public OrderService orderService(
      OrderRepository orderRepository
  ) {
    return new OrderServiceImpl(orderRepository);
  }

}
