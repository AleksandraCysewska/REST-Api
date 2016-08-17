package token.cysewskaa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;

/**
 * Created by cysewskaa on 2016-08-09.
 */
@Entity(name = "COPY_OF_FLOWER")

public class CopyOfFlowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "FLOWER_COPY_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "FLOWER_ID")
    FlowersEntity flowersEntity;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    @JsonIgnore
    OrderEntity orderEntity;

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public OrderEntity getOrderEntity() {

        return orderEntity;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setFlowersEntity(FlowersEntity flowersEntity) {
        this.flowersEntity = flowersEntity;
    }

    public long getId() {

        return id;
    }


    public FlowersEntity getFlowersEntity() {
        return flowersEntity;
    }
}
