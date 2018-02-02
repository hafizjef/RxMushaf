package beanDynamic;

public class BeanResult {

    String sourcefname;
    String reffname;
    double distance;
    String type;

    public BeanResult(String sourcefname, double distance, String reffname,
                      String type) {
        super();
        this.sourcefname = sourcefname;
        this.reffname = reffname;
        this.distance = distance;
        this.type = type;
    }

    public String getSourcefname() {
        return sourcefname;
    }

    public void setSourcefname(String sourcefname) {
        this.sourcefname = sourcefname;
    }

    public String getReffname() {
        return reffname;
    }

    public void setReffname(String reffname) {
        this.reffname = reffname;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
