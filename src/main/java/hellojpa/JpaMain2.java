package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            //insert
            Member member = new Member();
            member.setId(100L);
//            member.setName("HellZZZ");
            em.persist(member);

            System.out.println("BEFORE");
            em.persist(member);
            System.out.println("AFTER");

            Member findMember = em.find(Member.class, 100L);
            System.out.println("findMember = " + member.getId());
//            System.out.println("findMember = " + member.getName());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
