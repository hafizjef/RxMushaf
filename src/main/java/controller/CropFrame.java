package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CropFrame {

	public File doCrop (BufferedImage source, int x, int y, int w, int h, String parentDirectory, String picName)  throws IOException {
		File filePicWithoutFrame = new File(parentDirectory + "/tashih/processed/frame/text/" + picName);
		filePicWithoutFrame.getParentFile().mkdirs();
		FileWriter writer = new FileWriter(filePicWithoutFrame);
		BufferedImage cropImg = source.getSubimage(x, y, w, h);
		ImageIO.write(cropImg, "JPEG", filePicWithoutFrame);
		writer.close();
		return filePicWithoutFrame;
	}
}
