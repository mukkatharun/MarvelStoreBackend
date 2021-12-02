package com.example.marvelstore.MarvelStore.ModelDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer productid;

    private String name;

    private String category;

    private Float price;

    private String image;

    private Integer userid;
}
