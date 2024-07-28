package study.spring.hellospring.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import study.spring.hellospring.order.Order;

public class OrderRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public void save(Order order) {
    entityManager.persist(order);

//    EntityManager em = emf.createEntityManager();
//    EntityTransaction transaction = em.getTransaction();
//    transaction.begin();
//
//    try {
//      em.persist(order);
//      em.flush();
//
//      transaction.commit();
//    } catch (RuntimeException e) {
//      if (transaction.isActive()) {
//        transaction.rollback();
//      }
//      throw e;
//    } finally {
//      if (em.isOpen()) {
//        em.close();;
//      }
//    }
//    em.close();
  }

}
