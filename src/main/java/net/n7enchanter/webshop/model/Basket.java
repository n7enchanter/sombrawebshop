package net.n7enchanter.webshop.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Yuri on 06.11.2016.
 */
@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "basket_product",joinColumns = @JoinColumn(name = "basket_id"),inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Basket() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
