package com.example.marvelstore.MarvelStore.ModelDTO;

import com.example.marvelstore.MarvelStore.Model.Product;
import com.example.marvelstore.MarvelStore.Model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDTO {

    @Id
    private Integer id;

    private String pname;

    private Integer quantity;

    private Integer userid;

    private Integer productid;

    private Boolean active;

//    private String image;
}
