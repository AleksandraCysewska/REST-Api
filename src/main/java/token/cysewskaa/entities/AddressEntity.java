package token.cysewskaa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.List;

/**
 * Created by izodorczyka on 2016-08-04.
 */
@Entity(name = "ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ADDRESS_ID")
    private long id;
   @Column(name = "CITY")
    private String city;
   @Column(name = "STREET")
    private String street;
    @Column(name = "NUMBER")
    private String number;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="PERSON_ID")

    PersonEntity personEntity;

    public void setOrderEntity(List<OrderEntity> orderEntity) {
        this.orderEntity = orderEntity;
    }

    public List<OrderEntity> getOrderEntity() {

        return orderEntity;
    }

    @OneToMany(mappedBy="addressEntity", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<OrderEntity> orderEntity;

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }
}
