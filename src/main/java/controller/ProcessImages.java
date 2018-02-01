package controller;

import model.ImageModel;
import model.Segmentation;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessImages {
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessImages.class);

	public static void doProcess(ImageModel img) throws IOException, InterruptedException {
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
		File mFrameRemoved;
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
		logger.info("{} - Segmentation Process", img.getmFile().getName());

		ArrayList<File> fileLinesRows = new ArrayList<>(); // MASTER COLLECTION (input file line images)
		ArrayList<File> fileLinesOverlaps = new ArrayList<>(); // MASTER COLLECTION (input file line images)
		ArrayList<String> lineCut = new ArrayList<>(); // pages to line
		ArrayList<String> overlapLines = new ArrayList<>(); // pages to line overlap
		PointObjStop convertImageCutLine = new PointObjStop();

		BufferedImage buffInputImageLINES = convertImageCutLine.getImageInput(mFrameRemoved); // set file name and set bufferImage
		BufferedImage buffOutputImageLINES = convertImageCutLine.getImageOutput(buffInputImageLINES); // threshold the buffer image --> result threshold save into buffOutputImage

		try {
			convertImageCutLine.drawImage(buffOutputImageLINES); // binarize the threshold buffered image
			logger.info("90 Process Images");
			convertImageCutLine.cutline(mFrameRemoved.getName(), "output");
			lineCut.addAll(convertImageCutLine.getDirectory()); // the place saved directory followed by [pathDirectory.doCrop.CropImage]
			overlapLines.addAll(convertImageCutLine.getOverlapLines());
		} catch (IOException | InterruptedException e1) {
			logger.error("{} - Processing Error", e1.getMessage());
			throw e1;
		}

		for (String aLineCut : lineCut) {
			fileLinesRows.add(new File(aLineCut));
		}
		for (String overlapLine : overlapLines) {
			fileLinesOverlaps.add(new File(overlapLine));
		}
		segmentation.setFileCollectionLinesRowsActual(fileLinesRows);
		segmentation.setFileCollectionLinesRowsOverlap(fileLinesOverlaps);

		logger.info("{} - Process segmentation lines complete", img.getmFile().getName());
	}
}