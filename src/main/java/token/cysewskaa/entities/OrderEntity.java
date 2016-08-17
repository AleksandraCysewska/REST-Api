package token.cysewskaa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/*
** Created by cysewskaa on 2016-08-09.
*/

@Entity(name = "ORDER")
public class OrderEntity {
    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", addressEntity=" + addressEntity +
                ", copyOfFlowerEntities=" + copyOfFlowerEntities +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ORDER_ID")
    long id;
    @Column(name = "ORDER_NAME")
    String orderName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ADDRESS_ID")
    AddressEntity addressEntity;

    public void setCopyOfFlowerEntities(List<CopyOfFlowerEntity> copyOfFlowerEntities) {
        this.copyOfFlowerEntities = copyOfFlowerEntities;
    }

    public List<CopyOfFlowerEntity> getCopyOfFlowerEntities() {

        return copyOfFlowerEntities;
    }

    @OneToMany(mappedBy="orderEntity", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<CopyOfFlowerEntity> copyOfFlowerEntities;

    public void setId(long id) {
        this.id = id;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }


    public long getId() {

        return id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public AddressEntity getAddressEntity() {

        return addressEntity;
    }
}
