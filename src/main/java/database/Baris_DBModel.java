package database;

import featureTriangle.bean.Bean_Feature;

public class Baris_DBModel {
	
	int baris_Id = 0;
	int mushaf = 0;
	int nomborBaris = 0;
	Bean_Feature bean_Feature = new Bean_Feature();
	
	public int getBaris_Id() {
		return baris_Id;
	}
	public void setBaris_Id(int baris_Id) {
		this.baris_Id = baris_Id;
	}
	public int getMushaf() {
		return mushaf;
	}
	public void setMushaf(int mushaf) {
		this.mushaf = mushaf;
	}
	public int getNomborBaris() {
		return nomborBaris;
	}
	public void setNomborBaris(int nomborBaris) {
		this.nomborBaris = nomborBaris;
	}
	public Bean_Feature getBean_Feature() {
		return bean_Feature;
	}
	public void setBean_Feature(Bean_Feature bean_Feature) {
		this.bean_Feature = bean_Feature;
	}
	
}
