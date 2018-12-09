package io.altar.jseproject.model;

import java.util.ArrayList;

public class Product extends Entity{
	private static final long serialVersionUID=1L;
	
	private ArrayList<Shelf> shelvesList=new ArrayList<Shelf>();
	private double discount;
	private double iva;
	private double pvp;
	public Product(){}


	public Product(ArrayList<Shelf> shelvesList, double discount, double iva, double pvp) {
		super();
		this.shelvesList = shelvesList;
		this.discount = discount;
		this.iva = iva;
		this.pvp = pvp;
	}
	

	public ArrayList<Shelf> getShelvesList() {
		return shelvesList;
	}

	public void setShelvesList(ArrayList<Shelf> shelvesList) {
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
	private String getStringOfShelves(){
		String str="";
		for(int i=0;i<shelvesList.size();i++){
			str+=shelvesList.get(i);
			str+=", ";
		}
		return str;
	}

	@Override
	public String toString() {
		return "Product"+getId()+" [shelves_list=" + getStringOfShelves()+ " discount=" + discount + ", iva=" + iva + ", pvp=" + pvp
				+ "]";
	}

}
