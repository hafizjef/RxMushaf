package database;

import featureTriangle.bean.Bean_Feature;

public class Teks_DBModel {

	int teks_Id = 0;
	int mushaf = 0;
	Bean_Feature bean_Feature = new Bean_Feature();
	public int getTeks_Id() {
		return teks_Id;
	}
	public void setTeks_Id(int teks_Id) {
		this.teks_Id = teks_Id;
	}
	public int getMushaf() {
		return mushaf;
	}
	public void setMushaf(int mushaf) {
		this.mushaf = mushaf;
	}
	public Bean_Feature getBean_Feature() {
		return bean_Feature;
	}
	public void setBean_Feature(Bean_Feature bean_Feature) {
		this.bean_Feature = bean_Feature;
	}
	
}
