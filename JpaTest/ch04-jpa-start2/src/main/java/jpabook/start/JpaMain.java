package jpabook.start;

import javax.persistence.*;

import org.hibernate.FlushMode;
import org.hibernate.annotations.FlushModeType;

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
        //등록
    	em.persist(team);
    	teamId = team.getTeamId();
    	
    	
    	Locker locker = new Locker();
    	locker.setLockerName("사물함1");
    	em.persist(locker);			//등록
    	
    	Locker locker2 = new Locker();
    	locker2.setLockerName("사물함2");
    	em.persist(locker2);		//등록
    	
    	
    	Member member = new Member();
        member.setUsername("지한1");
        member.setAge(2);
        member.setTeam(team);
        member.setLocker(locker);
        //team.getMemberList().add(member);	//양방향 연관관계이므로 주인이 아닌 곳에도 값을 입력해준다.
        //등록
        em.persist(member);
        
        Member member2 = new Member();
        member2.setUsername("지한2");
        member2.setAge(2);
        member2.setTeam(team);
        member2.setLocker(locker2);
        //team.getMemberList().add(member2);	//양방향 연관관계이므로 주인이 아닌 곳에도 값을 입력해준다.
        //등록
        em.persist(member2);
        
        /*System.out.println("member id : " + member.getId());
        
        //수정
        member.setAge(20);
        
        //한 건 조회
        Member findMember = em.find(Member.class, member.getId());
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge() + 
        		", team=" + findMember.getTeam() + ", team_id=" + findMember.getTeam().getTeamId() + 
        		", locker_id=" + findMember.getLocker().getLockerId() + ", locker_name=" + findMember.getLocker().getLockerName());
        
       
        //목록 조회
        System.out.println("----------------");
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("멤버 목록 조회...");
        for(Member m : members){
        	System.out.println("members = " + m.getId() + ":" + m.getTeam().getTeamId());
        }
        List<Team> teams = em.createQuery("select t from Team t", Team.class).getResultList();
        System.out.println("팀 목록 조회...");
        for(Team t : teams){
        	System.out.println("team_id = " + t.getTeamId() + ":" + t.getTeamName());
        }
        System.out.println("----------------");
        //외래키 수정
        Team updateTeam = em.find(Team.class, 22);	//team_id가 22이 있을 경우(없을경우 다른 있는것으로 수정)
        if(updateTeam != null){
        	member.setTeam(updateTeam);
        } 
        
        //수정된 목록 조회
        members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("외래키 수정된 목록 조회...");
        for(Member m : members){
        	System.out.println("members = " + m.getId() + ":" + m.getTeam().getTeamId() + ":" + m.getLocker().getLockerName());
        }
        */
        
        em.flush(); //추가
        em.clear(); //추가
        
        System.out.println("teamId : " + teamId);
        Team teamResult = em.find(Team.class, teamId);
        System.out.println("팀에 속해있는 회원 목록 조회...");
        System.out.println("team_id : " + teamResult.getTeamId() + " size : " + teamResult.getMemberList().size());
        for(Member m : teamResult.getMemberList()){
        	System.out.println("member id : " + m.getId() + " member name : " + m.getUsername());
        }
        
        System.out.println("-------------------------");
        System.out.println("teamId : " + teamId);
        Team teamResult2 = em.createQuery("select t from Team t where t.teamId = :teamId", Team.class).setParameter("teamId", teamId).getSingleResult();
        System.out.println("팀에 속해있는 회원 목록 조회...");
        System.out.println("team_id : " + teamResult2.getTeamId() + " size : " + teamResult2.getMemberList().size());
        for(Member m : teamResult2.getMemberList()){
        	System.out.println("member id : " + m.getId() + " member name : " + m.getUsername());
        }
        
        /*System.out.println("----------------");
        List<Member> members = em.createQuery("select m from Member m where m.team.teamId = :teamId", Member.class).setParameter("teamId", teamId).getResultList();
        System.out.println("멤버 목록 조회...");
        for(Member m : members){
        	System.out.println("members = " + m.getId() + ":" + m.getTeam().getTeamId());
        }*/
        
    }
}
