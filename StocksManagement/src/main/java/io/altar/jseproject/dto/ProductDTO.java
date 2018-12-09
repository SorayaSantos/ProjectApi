package io.altar.jseproject.dto;

public class ProductDTO {
	
	private double discount;
	private double iva;
	private double pvp;
	public ProductDTO(){}


	public ProductDTO(double discount, double iva, double pvp) {
		super();
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
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
