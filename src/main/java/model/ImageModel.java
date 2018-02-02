package model;

import java.io.File;
import java.util.UUID;

public class ImageModel {
	
	private File mFile;
    private UUID uuid;
    private String email;

    public ImageModel(File mFile, String email) {
		super();
		this.mFile = mFile;
        this.uuid = UUID.randomUUID();
        this.email = email;
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

    public void setmFile(File mFile) {
		this.mFile = mFile;
	}
	
	
}
