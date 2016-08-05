package jpabook.start;

import javax.persistence.*;
import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) throws Exception {
    	    	
    	String query = "SELECT m FROM Member m  JOIN m.team t "
    			+ "WHERE t.teamName = :teamName";
    	List<Member> members = em.createQuery(query, Member.class).setParameter("teamName", "TEAM2").getResultList();
        System.out.println("조인 조회...");
        for(Member m : members){
        	System.out.println("member_id = " + m.getId() + " | team_id = " + m.getTeam().getTeamId());
        }
        
        System.out.println("------------------------");
        
        query = "SELECT m,t FROM Member m  JOIN m.team t "
    			+ "WHERE t.teamName = :teamName";
    	List<Object[] > resultList = em.createQuery(query).setParameter("teamName", "TEAM2").getResultList();
        System.out.println("멤버 목록 조회...");
        for(Object[] row : resultList){
        	Member m = (Member) row[0];
        	Team   t = (Team) row[1];
        	System.out.println("member_id = " + m.getId() + " | team_id = " + t.getTeamId());
        }
    }
}
