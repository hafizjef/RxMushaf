package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestResp {

    private String notUsed;

    @SerializedName("ComplainantName")
    @Expose
    private String complainantName;
    @SerializedName("ComplainantMyKad")
    @Expose
    private String complainantMyKad;
    @SerializedName("ComplainantEmail")
    @Expose
    private String complainantEmail;

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

    public String getNotUsed() {
        return notUsed;
    }

    public void setNotUsed(String notUsed) {
        this.notUsed = notUsed;
    }

    @Override
    public String toString() {
        return "TestResp{" +
                "complainantName='" + complainantName + '\'' +
                ", complainantMyKad='" + complainantMyKad + '\'' +
                ", complainantEmail='" + complainantEmail + '\'' +
                '}';
    }
}
