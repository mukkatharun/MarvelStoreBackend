package com.example.marvelstore.MarvelStore.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
