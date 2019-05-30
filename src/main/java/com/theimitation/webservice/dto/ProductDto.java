package com.theimitation.webservice.dto;

import javax.annotation.ManagedBean;

@ManagedBean
public class ProductDto {

	    private Long id;

	    private String name;
	    
	    private ProdDescrDto prodDescrDto;

	    private Double price;

	    private String pictureUrl;
	    

	    public ProductDto(Long id, String name, Double price, String pictureUrl, ProdDescrDto prodDescrDto) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	        this.pictureUrl = pictureUrl;
	        this.prodDescrDto=prodDescrDto;
	    }

	    public ProductDto() {
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

		public ProdDescrDto getProdDescr() {
			return prodDescrDto;
		}

		public void setProdDescr(ProdDescrDto prodDescrDto) {
			this.prodDescrDto = prodDescrDto;
		}
	    

}
