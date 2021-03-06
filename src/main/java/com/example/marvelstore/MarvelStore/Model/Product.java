package com.example.marvelstore.MarvelStore.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
public class Product {

    @Id
    @Column(name = "productid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productid;

    private String name;

    private String category;

    private Float price;

    private String image;

    @OneToOne
    @JoinColumn(name = "Userid")
    private Users users;

    public Integer getId() {
        return productid;
    }

    public void setId(Integer id) {
        this.productid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
