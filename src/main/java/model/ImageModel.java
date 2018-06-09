package model;

import Utils.Constants;

import java.io.File;
import java.sql.Timestamp;
import java.util.UUID;

public class ImageModel {
	
	private File mFile;
    private UUID uuid;
    private String email;
    private Constants.Status status;
    private Timestamp timestamp;
    private String modelName;
    private double weight;

    public ImageModel(File mFile, String email) {
		super();
		this.mFile = mFile;
        this.uuid = UUID.randomUUID();
        this.email = email;
        this.status = Constants.Status.PENDING;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public ImageModel() {
    }

    public Constants.Status getStatus() {
        return status;
    }

    public void setStatus(Constants.Status status) {
        this.status = status;
    }
	
	public File getmFile() {
		return mFile;
	}

    public UUID getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUuid(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }

    public void setmFile(File mFile) {
		this.mFile = mFile;
	}

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
