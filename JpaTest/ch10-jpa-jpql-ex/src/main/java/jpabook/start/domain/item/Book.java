package jpabook.start.domain.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by holyeye on 2014. 3. 11..
 */

@Entity
@DiscriminatorValue("B")
public class Book extends Item {

    private String author;
    


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
