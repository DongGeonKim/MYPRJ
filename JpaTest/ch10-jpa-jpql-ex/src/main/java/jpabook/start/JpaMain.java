package jpabook.start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
    	String query = "";
    	/*query = "SELECT m FROM Member m  JOIN m.team t "
    			+ "WHERE t.teamName = :teamName";
    	List<Member> members = em.createQuery(query, Member.class).setParameter("teamName", "TEAM2").getResultList();
        System.out.println("조인 조회...");
        for(Member m : members){
        	System.out.println("member_id = " + m.getId() + " | team_id = " + m.getTeam().getTeamId());
        }
        
        System.out.println("------------------------");
        
        query = "SELECT m, t FROM Member m JOIN m.team t "
    			+ "WHERE t.teamName = :teamName";
    	List<Object[] > resultList = em.createQuery(query).setParameter("teamName", "TEAM2").getResultList();
        System.out.println("멤버 목록 조회...");
        for(Object[] row : resultList){
        	Member m = (Member) row[0];
        	Team   t = (Team) row[1];
        	System.out.println("member_id = " + m.getId() + " | team_id = " + t.getTeamId());
        }
        
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("------------------------");
       
    	query = "SELECT m FROM Member m JOIN m.team t ";
		
        List<Member> members = em.createQuery(query, Member.class).getResultList();
        System.out.println("일반 조인 조회...");
        for(Member m : members){
        	System.out.println(m + ":" + m.getTeam() + " | member_id = " + m.getId() + " | team_id = " + m.getTeam().getTeamId());
        }
       
        System.out.println("------------------------");
        
        query = "SELECT m FROM Member m JOIN fetch m.team t ";
    			
    	members = em.createQuery(query, Member.class).getResultList();
        System.out.println("페치 조인 조회...");
        for(Member m : members){
        	System.out.println(m + ":" + m.getTeam() + " | member_id = " + m.getId() + " | team_id = " + m.getTeam().getTeamId());
        }
        
        
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("------------------------");
        
        String query = "SELECT t FROM Team t JOIN t.memberList m where t.teamName = :teamName ";
		
        List<Team> teams = em.createQuery(query, Team.class).setParameter("teamName", "TEAM2").getResultList();
        System.out.println("조인 조회...");
        for(Team t : teams){
        	System.out.println("team_id = " + t.getTeamId() + " | member = " + t.getMemberList());
        }
        System.out.println("------------------------");
        
        query = "SELECT t FROM Team t JOIN t.memberList m where t.teamName = :teamName ";
		
        teams = em.createQuery(query, Team.class).setParameter("teamName", "TEAM2").getResultList();
        System.out.println("페치 조인 조회...");
        for(Team t : teams){
        	System.out.println(t);
        	for(Member m : t.getMemberList()){
        		System.out.println("->>" + m);
        	}
        }
        System.out.println("------------------------");
        query = "SELECT distinct t FROM Team t JOIN fetch t.memberList where t.teamName = 'TEAM2' ";
		
        teams = em.createQuery(query, Team.class).getResultList();
        System.out.println("페치 조인 조회...");
        for(Team t : teams){
        	System.out.println(t);
        	for(Member m : t.getMemberList()){
        		System.out.println("->>" + m);
        	}
        }*/
    	        
        /*String query = "SELECT m.id, m.age FROM Member m";
        List<Object[] > resultList = em.createQuery(query).getResultList();
        System.out.println("조회...");
        for(Object[] row : resultList){
        	int id = (Integer) row[0];
        	int age = (Integer) row[1];
        	
        	System.out.println("member_id = " + id + " | age = " + age);
        }*/
    	
    	/*Book book = new Book();
    	book.setName("aaa");
    	book.setAuthor("author");
    	Item item = book;
        //등록
        em.persist(item);*/
    	
    	 System.out.println("------------------------");
         query = "SELECT t FROM Team t join fetch t.memberList";
 		
         List<Team> teams = em.createQuery(query, Team.class).getResultList();
         System.out.println("페치 조인 조회...");
         for(Team t : teams){
        	 System.out.println("---------------------------------");
         	System.out.println(t + ":"+ t.getMemberList().size());
         	
         }
    }
}
