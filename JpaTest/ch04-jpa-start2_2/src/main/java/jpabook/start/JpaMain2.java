package jpabook.start;

import javax.persistence.*;
import java.util.List;

/**
 * @author holyeye
 */
public class JpaMain2 {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득
        
        Team teamResult = null;
        
        try {

            tx.begin(); //트랜잭션 시작
            teamResult = logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋
            
           
            

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }
        
        System.out.println("-------------------------------------------");
        System.out.println("team_id : " + teamResult.getTeamId());
        System.out.println(teamResult.getMemberList().size());
        
        for(Member m : teamResult.getMemberList()){
        	System.out.println("member id : " + m.getId() + " member name : " + m.getUsername());
        }
        
        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static Team logic(EntityManager em) throws Exception {
    	
    	int teamId = 0;
    	
    	Member member = new Member();
        member.setUsername("지한1");
        member.setAge(2);

        Member member2 = new Member();
        member2.setUsername("지한2");
        member2.setAge(2);

    	Team team = new Team();
    	team.setTeamName("TEAM1");
    	
    	member.setTeam(team);
        team.getMemberList().add(member);	//양방향 연관관계이므로 주인이 아닌 곳에도 값을 입력해준다.
        member2.setTeam(team);
        team.getMemberList().add(member2);	//양방향 연관관계이므로 주인이 아닌 곳에도 값을 입력해준다.
        
        //등록
    	em.persist(team);
    	teamId = team.getTeamId();
    	
    	em.flush();
    	em.clear();
    	
        System.out.println("teamId : " + teamId);
        return em.find(Team.class, teamId);
        
    }
}
