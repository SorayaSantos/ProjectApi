package io.altar.jseproject.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name=Product.nameOfQuery, query="SELECT p FROM Product p")
public class Product extends BaseEntity{
	private static final long serialVersionUID=1L;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="product")
	private List<Shelf> shelvesList=new ArrayList<Shelf>();
	private double discount;
	private double iva;
	private double pvp;
	public static final String nameOfQuery="GetAllProducts";
	public Product(){}


	public Product(List<Shelf> shelvesList, double discount, double iva, double pvp) {
		super();
		this.shelvesList = shelvesList;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}
	
	public  List<Shelf> getShelvesList() {
		return  shelvesList;
	}

	public void setShelvesList(List<Shelf> shelvesList) {
		this.shelvesList = shelvesList;
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
	
//	private String getStringOfShelves(){
//		String str="";
//		for(int i=0;i<shelvesList.size();i++){
//			str+=shelvesList.get(i);
//			str+=", ";
//		}
//		return str;
//	}

//	@Override
//	public String toString() {
//		return "Product"+getId()+" [shelves_list=" + getStringOfShelves()+ " discount=" + discount + ", iva=" + iva + ", pvp=" + pvp
//				+ "]";
//	}

}
