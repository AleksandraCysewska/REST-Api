package token.cysewskaa.entities;


import token.cysewskaa.validator.TypeOfPhoneValidator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by izodorczyka on 2016-08-01.
 */
@TypeOfPhoneValidator
@Entity(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "PERSON_ID")
    Long id;

    @Column(name = "FIRSTNAME")
    String fname;
    @Column(name = "LASTNAME")
    String lname;

@Column(name = "TYPE_OF_PHONE")
String typeOfPhone;


    public void setAddressEntities(List<AddressEntity> addressEntities) {
        this.addressEntities = addressEntities;
    }

    public void setTypeOfPhone(String typeOfPhone) {
        this.typeOfPhone = typeOfPhone;
    }

    public String getTypeOfPhone() {

        return typeOfPhone;
    }

    @Column(name = "DAYOFBIRTH")
    Date dob;
    @Column(name = "PHONE")
    Integer phone;


    @OneToMany(mappedBy="personEntity", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<AddressEntity> addressEntities;


    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<AddressEntity> getAddressEntities() {
        return addressEntities;
    }

    public void setAdressDAOs(List<AddressEntity> addressDAOs) {
        this.addressEntities = addressDAOs;
    }

}
