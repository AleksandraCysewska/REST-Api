package token.cysewskaa.crudInterfaces;

import org.springframework.stereotype.Component;
import token.cysewskaa.entities.PersonEntity;

import javax.persistence.criteria.Order;
import java.util.List;

/**
 * Created by cysewskaa on 2016-08-11.
 */
@Component
public class OrderDTO {

    String lname;
    String fname;
    List<PersonEntity> flowerName;


    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getLname() {

        return lname;
    }

    public String getFname() {
        return fname;
    }


    public void setFlowerName(List<PersonEntity> flowerName) {
        this.flowerName = flowerName;
    }

    public List<PersonEntity> getFlowerName() {

        return flowerName;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "lname='" + lname + '\'' +
                ", fname='" + fname + '\'' +
                ", flowerName=" + flowerName +

                '}';
    }
}
