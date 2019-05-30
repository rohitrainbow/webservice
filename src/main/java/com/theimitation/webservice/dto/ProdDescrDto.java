package com.theimitation.webservice.dto;

import javax.annotation.ManagedBean;

@ManagedBean
public class ProdDescrDto {

	private Long descrId;

	private String descr;

	private Long productId;

	public ProdDescrDto() {
		super();
	}

	public ProdDescrDto(Long descrId, String descr, Long productId) {
		super();
		this.descrId = descrId;
		this.descr = descr;
		this.productId = productId;
	}

	public Long getDescrId() {
		return descrId;
	}

	public void setDescrId(Long descrId) {
		this.descrId = descrId;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
