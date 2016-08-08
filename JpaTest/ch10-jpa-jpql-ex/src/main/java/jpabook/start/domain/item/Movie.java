package jpabook.start.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by holyeye on 2014. 3. 11..
 */
@Entity
@DiscriminatorValue("M")
public class Movie extends Item {

    private String director;

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
    
}
