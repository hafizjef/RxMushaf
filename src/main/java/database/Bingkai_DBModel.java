package database;

import featureTriangle.bean.Bean_Feature;

public class Bingkai_DBModel {
	
	int bingkai_Id = 0;
	int mushaf = 0;
	Bean_Feature bean_Feature = new Bean_Feature();
	
	public int getBingkai_Id() {
		return bingkai_Id;
	}
	public void setBingkai_Id(int bingkai_Id) {
		this.bingkai_Id = bingkai_Id;
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
