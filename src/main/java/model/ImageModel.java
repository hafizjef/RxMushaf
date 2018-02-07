package model;

import Utils.Constants;

import java.io.File;
import java.util.UUID;

public class ImageModel {
	
	private File mFile;
    private UUID uuid;
    private String email;
    private Constants.Status status;

    public ImageModel(File mFile, String email) {
		super();
		this.mFile = mFile;
        this.uuid = UUID.randomUUID();
        this.email = email;
        this.status = Constants.Status.PENDING;
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
	
	
}
