package database;

import featureTriangle.bean.Bean_Feature;

public class WakafPadaBaris_DBModel {

	private int wakafPadaBaris_Id = 0;
	private int wakaf = 0;
	private int mushaf = 0;
	private int baris = 0;
	Bean_Feature bean_Feature = new Bean_Feature();
	public int getWakafPadaBaris_Id() {
		return wakafPadaBaris_Id;
	}
	public void setWakafPadaBaris_Id(int wakafPadaBaris_Id) {
		this.wakafPadaBaris_Id = wakafPadaBaris_Id;
	}
	public int getWakaf() {
		return wakaf;
	}
	public void setWakaf(int wakaf) {
		this.wakaf = wakaf;
	}
	public int getMushaf() {
		return mushaf;
	}
	public void setMushaf(int mushaf) {
		this.mushaf = mushaf;
	}
	public int getBaris() {
		return baris;
	}
	public void setBaris(int baris) {
		this.baris = baris;
	}
	public Bean_Feature getBean_Feature() {
		return bean_Feature;
	}
	public void setBean_Feature(Bean_Feature bean_Feature) {
		this.bean_Feature = bean_Feature;
	}


}
