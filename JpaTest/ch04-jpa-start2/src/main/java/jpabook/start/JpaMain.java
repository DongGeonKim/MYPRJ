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
    	
    	int teamId = 0;
    	
    	Team team = new Team();
    	team.setTeamName("TEAM1");
    	em.persist(team);
    	teamId = team.getTeamId();
    	
        Member member = new Member();
        
        member.setUsername("지한");
        member.setAge(2);
        member.setTeam(team);
        //등록
        em.persist(member);
        
        System.out.println("member id : " + member.getId());
        
        //수정
        member.setAge(20);
        
        //한 건 조회
        Member findMember = em.find(Member.class, member.getId());
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge() + ", team=" + findMember.getTeam() + ", team_id=" + findMember.getTeam().getTeamId());
        
        System.out.println("teamId : " + teamId);
        Team teamResult = em.find(Team.class, teamId);
        System.out.println("팀에 속해있는 회원 목록 조회...");
        System.out.println("size : " + teamResult.getMemberList().size());
        for(Member m : teamResult.getMemberList()){
        	System.out.println("member id : " + m.getId() + " member name : " + m.getUsername());
        }
        
        
        //목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("목록 조회...");
        for(Member m : members){
        	System.out.println("members = " + m.getId() + ":" + m.getTeam().getTeamId());
        }
        
        //외래키 수정
        Team updateTeam = em.find(Team.class, 17);	//team_id가 17이 있을 경우(없을경우 다른 있는것으로 수정)
        if(updateTeam != null){
        	member.setTeam(updateTeam);
        }
        
        //수정된 목록 조회
        members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("외래키 수정된 목록 조회...");
        for(Member m : members){
        	System.out.println("members = " + m.getId() + ":" + m.getTeam().getTeamId());
        }
        
       
    }
}
