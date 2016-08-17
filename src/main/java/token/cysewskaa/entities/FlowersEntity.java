package token.cysewskaa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
/*
 * Created by cysewskaa on 2016-08-09.
 */


@Entity(name = "FLOWER")
public class FlowersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "FLOWER_ID")
    private long id;

   @Column(name = "FLOWER_NAME")
    String flowerName;
    @Column(name = "FLOWER_COLOR")
    String flowerColor;


@JsonIgnore
    @OneToMany(mappedBy="flowersEntity", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<CopyOfFlowerEntity> copyOfFlowerEntities;

    public void setCopyOfFlowerEntities(List<CopyOfFlowerEntity> copyOfFlowerEntities) {
        this.copyOfFlowerEntities = copyOfFlowerEntities;
    }

    public List<CopyOfFlowerEntity> getCopyOfFlowerEntities() {

        return copyOfFlowerEntities;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public long getId() {

        return id;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public String getFlowerColor() {
        return flowerColor;
    }
}
