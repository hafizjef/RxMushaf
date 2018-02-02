package model;

import featureTriangle.bean.Bean_Feature;

import java.util.ArrayList;

public class Bean_SegmentationModel {

    ArrayList<Bean_Feature> beansCollectionPage = new ArrayList<Bean_Feature>();
    ArrayList<Bean_Feature> beansCollectionFrame = new ArrayList<Bean_Feature>();
    ArrayList<Bean_Feature> beansCollectionText = new ArrayList<Bean_Feature>();
    ArrayList<Bean_Feature> beansCollectionRowsOverlap = new ArrayList<Bean_Feature>();
    ArrayList<Bean_Feature> beansCollectionRowsActual = new ArrayList<Bean_Feature>();
    ArrayList<Bean_Feature> beansCollectionMarkedRed = new ArrayList<Bean_Feature>();
    ArrayList<Bean_Feature> beansCollectionVerse = new ArrayList<Bean_Feature>();

    public ArrayList<Bean_Feature> getBeansCollectionPage() {
        return beansCollectionPage;
    }

    public void setBeansCollectionPage(ArrayList<Bean_Feature> beansCollectionPage) {
        this.beansCollectionPage = beansCollectionPage;
    }

    public ArrayList<Bean_Feature> getBeansCollectionFrame() {
        return beansCollectionFrame;
    }

    public void setBeansCollectionFrame(ArrayList<Bean_Feature> beansCollectionFrame) {
        this.beansCollectionFrame = beansCollectionFrame;
    }

    public ArrayList<Bean_Feature> getBeansCollectionText() {
        return beansCollectionText;
    }

    public void setBeansCollectionText(ArrayList<Bean_Feature> beansCollectionText) {
        this.beansCollectionText = beansCollectionText;
    }

    public ArrayList<Bean_Feature> getBeansCollectionRowsOverlap() {
        return beansCollectionRowsOverlap;
    }

    public void setBeansCollectionRowsOverlap(ArrayList<Bean_Feature> beansCollectionRowsOverlap) {
        this.beansCollectionRowsOverlap = beansCollectionRowsOverlap;
    }

    public ArrayList<Bean_Feature> getBeansCollectionRowsActual() {
        return beansCollectionRowsActual;
    }

    public void setBeansCollectionRowsActual(ArrayList<Bean_Feature> beansCollectionRowsActual) {
        this.beansCollectionRowsActual = beansCollectionRowsActual;
    }

    public ArrayList<Bean_Feature> getBeansCollectionMarkedRed() {
        return beansCollectionMarkedRed;
    }

    public void setBeansCollectionMarkedRed(ArrayList<Bean_Feature> beansCollectionMarkedRed) {
        this.beansCollectionMarkedRed = beansCollectionMarkedRed;
    }

    public ArrayList<Bean_Feature> getBeansCollectionVerse() {
        return beansCollectionVerse;
    }

    public void setBeansCollectionVerse(ArrayList<Bean_Feature> beansCollectionVerse) {
        this.beansCollectionVerse = beansCollectionVerse;
    }

}
