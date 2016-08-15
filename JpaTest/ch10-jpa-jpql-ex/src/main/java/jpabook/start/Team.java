package jpabook.start;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TEAM")
public class Team {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TEAM_ID")
	private int teamId;
	
	@Column(name="TEAM_NAME")
	private String teamName;
	
	@OneToMany(mappedBy="team", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Member> memberList = new ArrayList<Member>();
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
}
