package model;

import java.util.List;

public class Result {
    private String email;
    private Integer count;
    private List<ImageModel> imageModels;

    public Result(String email) {
        this.email = email;
    }

    public Integer getCount() {
        return count;
    }

    public void setImageModels(List<ImageModel> imageModels) {
        this.count = imageModels.size();
        this.imageModels = imageModels;
    }
}
