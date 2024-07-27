package study.spring.hellospring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.math.BigDecimal;
import study.spring.hellospring.order.Order;

public class OrderRepository {

  private final EntityManagerFactory emf;

  public OrderRepository(EntityManagerFactory emf) {
    this.emf = emf;
  }

  public void save(Order order) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();

    try {
      em.persist(order);

      transaction.commit();
    } catch (RuntimeException e) {
      if (transaction.isActive()) {
        transaction.rollback();
      }
      throw e;
    } finally {
      if (em.isOpen()) {
        em.close();;
      }
    }


    em.close();
  }

}
