package jpabook.start;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LOCKER")
public class Locker {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LOCKER_ID")
	private int lockerId;
	
	@Column(name="LOCKER_NAME")
	private String lockerName;

	public int getLockerId() {
		return lockerId;
	}

	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}

	public String getLockerName() {
		return lockerName;
	}

	public void setLockerName(String lockerName) {
		this.lockerName = lockerName;
	}
	
}
