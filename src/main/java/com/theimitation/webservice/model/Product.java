package com.theimitation.webservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;
    
    @OneToOne
	@JoinColumn(name="descr_id")
    private ProdDescr prodDescr;

    private Double price;

    private String pictureUrl;
    

    public Product(Long id, @NotNull(message = "Product name is required.") String name, Double price, String pictureUrl, ProdDescr prodDescr) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.prodDescr=prodDescr;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

	public ProdDescr getProdDescr() {
		return prodDescr;
	}

	public void setProdDescr(ProdDescr prodDescr) {
		this.prodDescr = prodDescr;
	}
    
    
}
