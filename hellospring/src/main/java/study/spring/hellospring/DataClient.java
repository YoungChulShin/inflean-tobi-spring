package study.spring.hellospring;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.hellospring.order.Order;

public class DataClient {

  public static void main(String[] args) {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
    EntityManagerFactory emf = beanFactory.getBean(EntityManagerFactory.class);

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    Order order = new Order("100", BigDecimal.TEN);
    System.out.println(order);
    em.persist(order);

    System.out.println(order);

    em.getTransaction().commit();
    em.close();
  }

}
