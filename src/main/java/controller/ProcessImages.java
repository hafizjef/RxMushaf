package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.ImageModel;
import model.Segmentation;

public class ProcessImages {
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessImages.class);
	
	public static void doProcess(ImageModel img) throws IOException {
		Segmentation segmentation = new Segmentation();
		File fPage = new File("output/copies/" + img.getmFile().getName());
		
		try {
			FileUtils.copyFile(img.getmFile(), fPage);
		} catch(IOException err) {
			throw err;
		}
		
		segmentation.setFileCollectionPicPage(fPage);
		
		// Frame Removal
		logger.info("{} - Removing Frame", img.getmFile().getName());
		File mFrameRemoved = new File("");
		ConvertFrame mConvertFrame = new ConvertFrame();
		BufferedImage mBuffInput = mConvertFrame.getImageInput(img.getmFile());
		BufferedImage mBuffOutput = mConvertFrame.getImageOutput(mBuffInput);
		
		try {
			mFrameRemoved = mConvertFrame.drawImage(mBuffOutput, "output", img.getmFile().getName());
			segmentation.setFileCollectionPicText(mFrameRemoved);
			segmentation.setFileCollectionPicFrame(mConvertFrame.getfFrameWithoutText());
		} catch (IOException err) {
			throw err;
		}
		
		logger.info("{} - Frame Removed", img.getmFile().getName());
	}
}