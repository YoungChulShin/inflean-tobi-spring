package study.spring.hellospring.order;

import java.math.BigDecimal;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class OrderService {

  private final OrderRepository orderJpaRepository;
  private final PlatformTransactionManager transactionManager;

  public OrderService(OrderRepository orderJpaRepository, PlatformTransactionManager transactionManager) {
    this.orderJpaRepository = orderJpaRepository;
    this.transactionManager = transactionManager;
  }


  public Order createOrder(String no, BigDecimal total) {
    Order order = new Order(no, total);

    return new TransactionTemplate(transactionManager).execute(status -> {
      orderJpaRepository.save(order);
      return order;
    });
  }
}
