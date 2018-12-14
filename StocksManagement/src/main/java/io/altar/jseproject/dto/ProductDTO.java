package io.altar.jseproject.dto;

import io.altar.jseproject.model.BaseEntity;

public class ProductDTO{

	private long id;
	private double discount;
	private double iva;
	private double pvp;
	public ProductDTO(){}


	public ProductDTO(long id,double discount, double iva, double pvp) {
		super();
		this.id = id;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}


	@Override
	public String toString() {
		return  " discount=" + discount + ", iva=" + iva + ", pvp=" + pvp
				+ "]";
	}

}
