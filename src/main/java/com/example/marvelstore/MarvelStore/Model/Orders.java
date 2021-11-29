package com.example.marvelstore.MarvelStore.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {

    @Id
    @Column(name="Orderid")
    private Integer id;

    @Column(name="Amount")
    private float amount;

    @Column(name="Time")
    private Date time;

//    @Column(name="Userid")
//    private Integer userId;

    @OneToOne
    @JoinColumn(name = "Userid")
    private Users users;

    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



//    public com.example.marvelstore.MarvelStore.Model.Users getUsers() {
//        return Users;
//    }
//
//    public void setUsers(com.example.marvelstore.MarvelStore.Model.Users users) {
//        Users = users;
//    }

}
