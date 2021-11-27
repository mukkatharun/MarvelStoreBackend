package com.example.marvelstore.MarvelStore.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {

    @Id
    private Integer id;

    private String pname;

    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "Userid")
    private Users users;

//    @OneToOne
//    private Users users;

    private Boolean active;
}
