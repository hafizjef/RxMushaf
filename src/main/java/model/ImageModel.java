package model;

import java.io.File;

public class ImageModel {
	
	private File mFile;
	
	public ImageModel(File mFile) {
		super();
		this.mFile = mFile;
	}
	
	public File getmFile() {
		return mFile;
	}
	public void setmFile(File mFile) {
		this.mFile = mFile;
	}
	
	
}
