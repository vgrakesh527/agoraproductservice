package com.agora.agoraproductservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "Categories")
public class Category extends BaseModel {
    String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;


}


