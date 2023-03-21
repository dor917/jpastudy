package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // [트랜잭션] 시작
        try {
//            Member memberA = new Member(77L, "A");
//            Member memberB = new Member(111L, "B ");
//
//            em.persist(memberA);
//            em.persist(memberB);
//
//            tx.commit(); // [트랜잭션] 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
