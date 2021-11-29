package com.example.marvelstore.MarvelStore.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "productid")
    private Product productid;

    private Boolean active;

//    private String image;
}
