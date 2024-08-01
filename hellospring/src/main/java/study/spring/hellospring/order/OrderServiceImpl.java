package study.spring.hellospring.order;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderJpaRepository;

  public OrderServiceImpl(OrderRepository orderJpaRepository) {
    this.orderJpaRepository = orderJpaRepository;
  }

  @Override
  public Order createOrder(String no, BigDecimal total) {
    Order order = new Order(no, total);
    orderJpaRepository.save(order);
    return order;
  }

  @Transactional
  @Override
  public List<Order> createOrders(List<OrderReq> reqs) {
    return reqs.stream().map(req -> createOrder(req.no(), req.total())).toList();
  }
}
