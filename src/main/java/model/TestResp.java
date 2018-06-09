package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meme {
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Age")
    @Expose
    private Integer age;

    public Meme(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
