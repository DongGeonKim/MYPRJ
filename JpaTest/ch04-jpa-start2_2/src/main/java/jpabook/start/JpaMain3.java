package jpabook.start;

import javax.persistence.*;
import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain3 {

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
    	
    	int teamId = 61;
    	
        System.out.println("teamId : " + teamId);
        
        Team teamResult = em.find(Team.class, teamId);
        System.out.println("팀에 속해있는 회원 목록 조회...");
        System.out.println("team_id : " + teamResult.getTeamId() + " size : " + teamResult.getMemberList().size());
        for(Member m : teamResult.getMemberList()){
        	System.out.println("member id : " + m.getId() + " member name : " + m.getUsername());
        }
        
        System.out.println("----------------------------------");
        
        teamId = 62;
        
        System.out.println("teamId : " + teamId);
        
        List<Team> teamResultList = em.createQuery("select t from Team t", Team.class).getResultList();
        
        System.out.println("-------------------------------------");
        
        teamId = 64;
        
        System.out.println("teamId : " + teamId);
        
        teamResultList = em.createQuery("select t from Team t JOIN fetch t.memberList", Team.class).getResultList();
        System.out.println(teamResultList.size());
    }
}
