package com.example.marvelstore.MarvelStore.ModelDTO;

import com.example.marvelstore.MarvelStore.Model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    @Column(name="Amount")
    private float amount;

//    @Column(name="Time")
//    private Date time;

//    @Column(name="Userid")
    private Integer userId;

//    @OneToOne
//    @JoinColumn(name = "Userid")
//    private Users users;

    private String image;

    private String name;
}
