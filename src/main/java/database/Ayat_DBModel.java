package database;

import featureTriangle.bean.Bean_Feature;

public class Ayat_DBModel {
	
	private int ayat_Id = 0;
	private int mushaf = 0;
	private int nomborAyat = 0;
	private Bean_Feature bean_Feature = new Bean_Feature();
	
	public int getAyat_Id() {
		return ayat_Id;
	}
	public void setAyat_Id(int ayat_Id) {
		this.ayat_Id = ayat_Id;
	}
	public int getMushaf() {
		return mushaf;
	}
	public void setMushaf(int mushaf) {
		this.mushaf = mushaf;
	}
	public int getNomborAyat() {
		return nomborAyat;
	}
	public void setNomborAyat(int nomborAyat) {
		this.nomborAyat = nomborAyat;
	}
	public Bean_Feature getBean_Feature() {
		return bean_Feature;
	}
	public void setBean_Feature(Bean_Feature bean_Feature) {
		this.bean_Feature = bean_Feature;
	}

}
