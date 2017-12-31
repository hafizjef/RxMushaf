package controller;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;



public class ConvertFrame { 
	
	
	static int [][] arrayImage;
	private static BufferedImage buffImageInput;
	static String filename="";
	private File fFrameWithoutText;
	
	public BufferedImage getImageInput(File inputFile)
	{
		filename = inputFile.getName();
		try {
			buffImageInput = ImageIO.read(inputFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return buffImageInput;
	}
	
	public BufferedImage getImageOutput(BufferedImage buffInputImage)
	{
		Raster raster = buffInputImage.getData();
		DataBuffer buffer = raster.getDataBuffer();
		DataBufferByte byteBuffer = (DataBufferByte) buffer;
		byte[] srcData = byteBuffer.getData(0);
		byte[] dstData = new byte[srcData.length];
		OtsuThresholder otsu = new OtsuThresholder();
		
		//to find the best threshold
		int threshold = otsu.doThreshold(srcData, dstData);
		//System.out.println("threshold : "+threshold);
		if(threshold==0)
			threshold=127;
	
		BufferedImage bufImageOutput = OtsuThresholder.Threshold(buffInputImage, threshold);
		return bufImageOutput;
	}
	
	public  File drawImage(BufferedImage image_dest,String parentDirectory, String picName) throws IOException {
		int w = image_dest.getWidth();
		int h = image_dest.getHeight();
		arrayImage = new int[h][w];
		FileWriter writer; 
		String nameFile = parentDirectory + "/temp/" + filename + new Long(new Date().getTime()).toString() + ".txt";
		
		
		File file = new File(nameFile);
		if(file.exists()) {
			writer = new FileWriter(file, true);
			writer.close();
		} else {
			file.getParentFile().mkdirs();
			writer = new FileWriter(file);
			for(int y=0; y<h; y++) {
				for(int x =0 ; x<w; x++) {
					if(image_dest.getRGB(x, y)==-1) {
						writer.append("1");
						arrayImage[y][x] = 1;
						writer.flush();
					} else {
						writer.append("0");
						arrayImage[y][x] = 0;
					}
				}
				
				writer.append(System.lineSeparator());
				//writer.close();
			}
		}
		
		CutFrame cutimage = new CutFrame();
		cutimage.setImage(arrayImage, buffImageInput);
		File filePicWithoutFrame = cutimage.upperFrame(parentDirectory, picName);
		int [][] iFrameWithoutText = cutimage.getFrameWithoutText();
		File fFrameWithoutText = cutimage.printFrameWithoutText(iFrameWithoutText, parentDirectory, picName);

		setfFrameWithoutText(fFrameWithoutText);
		
		return filePicWithoutFrame;
	}

	public File getfFrameWithoutText() {
		return fFrameWithoutText;
	}

	public  void setfFrameWithoutText(File fFrameWithoutText) {
		this.fFrameWithoutText = fFrameWithoutText;
	}

}
