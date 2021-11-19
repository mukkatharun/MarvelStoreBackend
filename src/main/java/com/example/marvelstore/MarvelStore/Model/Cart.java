package com.example.marvelstore.MarvelStore.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {

    @Id
    private Integer id;

    private String productName;

    private Integer quantity;

    @OneToOne
    private Users users;

    private Boolean active;
}
