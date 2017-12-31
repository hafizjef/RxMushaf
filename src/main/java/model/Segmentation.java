package model;

import java.io.File;
import java.util.ArrayList;

public class Segmentation {

	 private File fileCollectionPicPage = new File("");
	 private File fileCollectionPicFrame = new File("");
	 private File fileCollectionPicText = new File("");
	 private ArrayList<File> fileCollectionLinesRowsActual = new ArrayList<File>();
	 private ArrayList<File> fileCollectionLinesRowsOverlap = new ArrayList<File>();
	 private ArrayList<File> fileCollectionMarkedRed = new ArrayList<File>();
	 private ArrayList<File> fileCollectionPicVerse = new ArrayList<File>();
	 
	public File getFileCollectionPicPage() {
		return fileCollectionPicPage;
	}
	public void setFileCollectionPicPage(File fileCollectionPicPage) {
		this.fileCollectionPicPage = fileCollectionPicPage;
	}
	public File getFileCollectionPicFrame() {
		return fileCollectionPicFrame;
	}
	public void setFileCollectionPicFrame(File fileCollectionPicFrame) {
		this.fileCollectionPicFrame = fileCollectionPicFrame;
	}
	public File getFileCollectionPicText() {
		return fileCollectionPicText;
	}
	public void setFileCollectionPicText(File fileCollectionPicText) {
		this.fileCollectionPicText = fileCollectionPicText;
	}
	public ArrayList<File> getFileCollectionLinesRowsActual() {
		return fileCollectionLinesRowsActual;
	}
	public void setFileCollectionLinesRowsActual(ArrayList<File> fileCollectionLinesRowsActual) {
		this.fileCollectionLinesRowsActual = fileCollectionLinesRowsActual;
	}
	public ArrayList<File> getFileCollectionMarkedRed() {
		return fileCollectionMarkedRed;
	}
	public void setFileCollectionMarkedRed(ArrayList<File> fileCollectionMarkedRed) {
		this.fileCollectionMarkedRed = fileCollectionMarkedRed;
	}
	public ArrayList<File> getFileCollectionPicVerse() {
		return fileCollectionPicVerse;
	}
	public void setFileCollectionPicVerse(ArrayList<File> fileCollectionPicVerse) {
		this.fileCollectionPicVerse = fileCollectionPicVerse;
	}
	public ArrayList<File> getFileCollectionLinesRowsOverlap() {
		return fileCollectionLinesRowsOverlap;
	}
	public void setFileCollectionLinesRowsOverlap(ArrayList<File> fileCollectionLinesRowsOverlap) {
		this.fileCollectionLinesRowsOverlap = fileCollectionLinesRowsOverlap;
	}

}
