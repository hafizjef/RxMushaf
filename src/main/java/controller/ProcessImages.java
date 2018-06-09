package controller;

import apiDynamic.UnsupervisedTools;
import beanDynamic.BeanResult;
import database.Result;
import featureTriangle.main.Triangle;
import model.Bean_SegmentationModel;
import model.ImageModel;
import model.Segmentation;
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
        segmentation.setFileCollectionPicPage(img.getmFile());
		
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
			logger.error(err.getMessage());
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
		logger.info("{} - Extracting features from images", img.getmFile().getName());

		ArrayList<File> publish; // MASTER COLLECTION (collection of every extracted object on single rows)
		ArrayList<String[]> contentTests = new ArrayList<>(); // MASTER FEATURES COLLECTION (collection of features of every extracted object on single rows)
		ConvertImage convertImage = new ConvertImage();

		for (File fileLinesRow : fileLinesRows) {
			BufferedImage buffInputImageOBJECT = convertImage.getImageInput(fileLinesRow);    // inputFile is file directory of original image (selected image to process) and getImageInput set image into image buffer.
			BufferedImage buffOutputImageOBJECT = convertImage.getImageOutput(buffInputImageOBJECT);  // getImageOutput is process of image segmentation that called the thresholding method (gray-scale image into a binary image).
			try {
				ConvertImage.drawImage(buffOutputImageOBJECT); // drawImage is to convert image into black and white (0 or 1) and save into text format in specific directory. This method contain image processing algorithm (cut by object) name as CutAlphabet (cutimage).
				publish = convertImage.publish(); // image that already cut into pieces of every character
			} catch (IOException err) {
				logger.error("{} - {}", img.getmFile().getName(), err.getMessage());
				throw err;
			}

			// process extract features
			FeatureTriangle ft = new FeatureTriangle();
			ft.extractFeatureTriangle(publish, fileLinesRow.getAbsolutePath()); // extract feature triangle for every object
			contentTests.addAll(ft.getContentTests());
		}

		logger.info("{} - Process extract features from image complete", img.getmFile().getName());
		logger.info("{} - Process extract features model start", img.getmFile().getName());


		//******************** START : PROCESS EXTRACT FEATURES ON DATA MODEL [ConvertImage.java, FeatureTriangle.java]********************
		// note: used similarity distance tool to compare all model and all test and find the best model to used as benchmarks to the test features data
		//File inputFileA = new File("data/SP1457571234515.jpg"); // image test [note: use arrayList];

        File inputFileA = new File("output/res/spdata.jpg");
        inputFileA.getParentFile().mkdirs();

        if(!inputFileA.exists()) {
            Utils.FileUtils.copyFromResource(inputFileA);
        }

		ArrayList<File> publishA; // MASTER FEATURES COLLECTION (collection of every extracted object on single rows)
		ConvertImage convertImageA = new ConvertImage();
		BufferedImage buffInputImageA = convertImageA.getImageInput(inputFileA);
		BufferedImage buffOutputImageA = convertImageA.getImageOutput(buffInputImageA);

		try {
			ConvertImage.drawImageAfterThreasholdOnly(buffOutputImageA);
			publishA = convertImageA.publish();
		} catch (IOException err) {
			logger.error(err.getMessage());
			throw err;
		}
		// process extract features
		FeatureTriangle ftA = new FeatureTriangle();
		ftA.extractFeatureTriangle(publishA, inputFileA.getAbsolutePath()); // extract feature triangle for every object
		ArrayList<String[]> contentTestsA = new ArrayList<>(ftA.getContentTests());
		//******************** END : PROCESS EXTRACT FEATURES ON DATA MODEL********************


		logger.info("{} - Process extract features model complete", img.getmFile().getName());
		logger.info("{} - Computing similarity distance", img.getmFile().getName());


		//******************** START : SIMILARITY DISTANCE TOOLS ********************
		UnsupervisedTools unsupervisedTools = new UnsupervisedTools();
		ArrayList<BeanResult> results = unsupervisedTools.calcPraDistance(contentTestsA, contentTests); //results  = unsupervisedTools.calcPraDistance(inputData, contentTests);

		ArrayList<String> topObj = new ArrayList<>();
		ArrayList<String> topObjFile = new ArrayList<>();
		for (BeanResult r : results) {
			// to append data of distance form real data and test data
			if (r.getDistance() <= 12.0) //12.0
			{
				topObj.add(String.valueOf(r.getReffname()));
				topObjFile.add(String.valueOf(r.getType()));
			}
		}
		//******************** END : SIMILARITY DISTANCE TOOLS ********************
		logger.info("{} - Computing similarity distance complete", img.getmFile().getName());

		logger.info("{} - Verse segmentation process start", img.getmFile().getName());
		//******************** START : MARKED RED CIRCLE [MarkedRed.java, PointObjStop.java, MarkingObjectCircle.java, ConnectVerse.java]********************
		ArrayList<File> fileMarkedRed = new ArrayList<>();
		ArrayList<File> filePicVerse = new ArrayList<>();
		MarkedRed mr = new MarkedRed();
		mr.coordinateObj(topObj, topObjFile, fileLinesRows, "output", fileLinesRows, img.getmFile());
		fileMarkedRed.addAll(mr.getFileMarkedRed());
		segmentation.setFileCollectionMarkedRed(mr.getFileMarkedRed());//fileCollectionMarkedRed.addAll(mr.getFileMarkedRed());

		filePicVerse.addAll(mr.getImgVerse());
		segmentation.setFileCollectionPicVerse(mr.getImgVerse());//fileCollectionPicVerse.addAll(mr.getImgVerse());
		//******************** END : MARKED RED CIRCLE ********************
		logger.info("{} - Verse segmentation process complete", img.getmFile().getName());


		ArrayList<Bean_SegmentationModel> collectionSegmentationModel = new ArrayList<Bean_SegmentationModel>();
		Bean_SegmentationModel segmentationModel = new Bean_SegmentationModel();

		//PAGE
		ArrayList<File> arrayPage = new ArrayList<File>();
		arrayPage.add(segmentation.getFileCollectionPicPage());
		Triangle triPage = new Triangle();
		triPage.setFilesAndImages(arrayPage);
		ArrayList<featureTriangle.bean.Bean_Feature> beansCollectionPage = triPage.generateFeatures();
//			DMLsql dmlPage = new  DMLsql();
//			dmlPage.insertPage(beansCollectionPage,mushafId); //triPage.save(beansCollectionPage);<--print
		segmentationModel.setBeansCollectionPage(beansCollectionPage);

		//FRAME
		ArrayList<File> arrayFrame = new ArrayList<>();
		arrayFrame.add(segmentation.getFileCollectionPicFrame());
		Triangle triFrame = new Triangle();
		triFrame.setFilesAndImages(arrayFrame);
		ArrayList<featureTriangle.bean.Bean_Feature> beansCollectionFrame = triFrame.generateFeatures();
//			DMLsql dmlFrame = new  DMLsql();
//			dmlFrame.insertFrame(beansCollectionFrame,mushafId);
		segmentationModel.setBeansCollectionFrame(beansCollectionFrame);

		//TEXT
		ArrayList<File> arrayText = new ArrayList<>();
		arrayText.add(segmentation.getFileCollectionPicText());
		Triangle triText = new Triangle();
		triText.setFilesAndImages(arrayText);
		ArrayList<featureTriangle.bean.Bean_Feature> beansCollectionText = triText.generateFeatures();
//			DMLsql dmlText = new  DMLsql();
//			dmlText.insertText(beansCollectionText,mushafId);
		segmentationModel.setBeansCollectionText(beansCollectionText);

		//ROWSOVERLAP
		ArrayList<File> arrayRowsOverlap = new ArrayList<File>();
		arrayRowsOverlap.addAll(segmentation.getFileCollectionLinesRowsOverlap());
		Triangle triRowsOverlap = new Triangle();
		triRowsOverlap.setFilesAndImages(arrayRowsOverlap);
		ArrayList<featureTriangle.bean.Bean_Feature> beansCollectionRowsOverlap = triRowsOverlap.generateFeatures();
//			DMLsql dmlRowsOverlap = new  DMLsql();
//			dmlRowsOverlap.insertRowsOverlap(beansCollectionRowsOverlap,mushafId);
		segmentationModel.setBeansCollectionRowsOverlap(beansCollectionRowsOverlap);

		//ROWSACTUAL
		ArrayList<File> arrayRowsActual = new ArrayList<File>();
		arrayRowsActual.addAll(segmentation.getFileCollectionLinesRowsActual());
		Triangle triRowsActual = new Triangle();
		triRowsActual.setFilesAndImages(arrayRowsActual);
		ArrayList<featureTriangle.bean.Bean_Feature> beansCollectionRowsActual = triRowsActual.generateFeatures();
//			DMLsql dmlRowsActual = new  DMLsql();
//			dmlRowsActual.insertRowsActual(beansCollectionRowsActual,mushafId);
		segmentationModel.setBeansCollectionRowsActual(beansCollectionRowsActual);

		//MARKEDRED
		ArrayList<File> arrayMarkedRed = new ArrayList<File>();
		arrayMarkedRed.addAll(segmentation.getFileCollectionMarkedRed());
		Triangle triMarkedRed = new Triangle();
		triMarkedRed.setFilesAndImages(arrayMarkedRed);
		ArrayList<featureTriangle.bean.Bean_Feature> beansCollectionMarkedRed = triMarkedRed.generateFeatures();
		//DMLsql dmlMarkedRed = new  DMLsql();
		//dmlMarkedRed.insertMarkedRed(beansCollectionMarkedRed,mushafId);
		//TODO Print Fix
		//triMarkedRed.save(beansCollectionMarkedRed);
		segmentationModel.setBeansCollectionMarkedRed(beansCollectionMarkedRed);

		//Verse
		ArrayList<File> arrayVerse = new ArrayList<File>();
		arrayVerse.addAll(segmentation.getFileCollectionPicVerse());
		Triangle triVerse = new Triangle();
		triVerse.setFilesAndImages(arrayVerse);
		ArrayList<featureTriangle.bean.Bean_Feature> beansCollectionVerse = triVerse.generateFeatures();
//			DMLsql dmlVerse = new  DMLsql();
//			dmlVerse.insertVerse(beansCollectionVerse,mushafId);
		segmentationModel.setBeansCollectionVerse(beansCollectionVerse);

		// Extract information from segmentation?
		collectionSegmentationModel.add(segmentationModel);

		Result result = new Result(collectionSegmentationModel);
		logger.info("{} - Model: {} Weight: {}", img.getmFile().getName(),
				result.getCollectionDataTablePage().get(0).get(0).getModel(),
				result.getCollectionDataTablePage().get(0).get(0).getWeight());

		img.setModelName(result.getCollectionDataTablePage().get(0).get(0).getModel());
		img.setWeight(Double.parseDouble(result.getCollectionDataTablePage().get(0).get(0).getWeight()));

		logger.info("{} - Finish processing", img.getmFile().getName());
	}
}