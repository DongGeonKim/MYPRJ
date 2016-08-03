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
    	
        //한 건 조회
        Member findMember = em.find(Member.class, member.getId());
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge() + 
        		", team=" + findMember.getTeam() + ", team_id=" + findMember.getTeam().getTeamId());
        
       
        //목록 조회
        System.out.println("----------------");
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("멤버 목록 조회...");
        for(Member m : members){
        	System.out.println("members = " + m.getId() + ":" + m.getTeam().getTeamId());
        }
        
        
    }
}
