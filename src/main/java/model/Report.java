package model;

import org.primefaces.model.UploadedFile;

import java.io.Serializable;

public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    private String reportId;
    private String complainantName;
    private String complainantMyKad;
    private String complainantEmail;
    private String reports;
    private String location;
    private String imageName;
    private String complainantDate;
    private String reportUpdateDate;
    private UploadedFile imageFile;
    private char status;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getComplainantName() {
        return complainantName;
    }

    public void setComplainantName(String complainantName) {
        this.complainantName = complainantName;
    }

    public String getComplainantMyKad() {
        return complainantMyKad;
    }

    public void setComplainantMyKad(String complainantMyKad) {
        this.complainantMyKad = complainantMyKad;
    }

    public String getComplainantEmail() {
        return complainantEmail;
    }

    public void setComplainantEmail(String complainantEmail) {
        this.complainantEmail = complainantEmail;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UploadedFile getFile() {
        return imageFile;
    }

    public void setFile(UploadedFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getComplainantDate() {
        return complainantDate;
    }

    public void setComplainantDate(String complainantDate) {
        this.complainantDate = complainantDate;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getImages() {
        return imageName;
    }

    public void setImages(String imageName) {
        this.imageName = imageName;
    }

    public String getReportUpdateDate() {
        return reportUpdateDate;
    }

    public void setReportUpdateDate(String reportUpdateDate) {
        this.reportUpdateDate = reportUpdateDate;
    }
}
