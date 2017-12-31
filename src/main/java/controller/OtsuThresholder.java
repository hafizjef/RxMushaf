package controller;

import java.awt.image.BufferedImage;

public class OtsuThresholder
{
	private int histData[];
	private int maxLevelValue;
	private int threshold;

	public OtsuThresholder()
	{
		histData = new int[256];
	}

	public int[] getHistData()
	{
		return histData;
	}

	public int getMaxLevelValue()
	{
		return maxLevelValue;
	}

	public int getThreshold()
	{
		return threshold;
	}

	public int doThreshold(byte[] srcData, byte[] monoData)
	{
		int ptr;

		// Clear histogram data
		// Set all values to zero
		ptr = 0;
		while (ptr < histData.length) histData[ptr++] = 0;

		// Calculate histogram and find the level with the max value
		// Note: the max level value isn't required by the Otsu method
		ptr = 0;
		maxLevelValue = 0;
		while (ptr < srcData.length)
		{
			int h = 0xFF & srcData[ptr];
			histData[h] ++;
			if (histData[h] > maxLevelValue) maxLevelValue = histData[h];
			ptr ++;
		}

		// Total number of pixels
		int total = srcData.length;

		float sum = 0;
		for (int t=0 ; t<256 ; t++) sum += t * histData[t];

		float sumB = 0;
		int wB = 0;
		int wF = 0;

		float varMax = 0;
		threshold = 0;

		for (int t=0 ; t<256 ; t++)
		{
			wB += histData[t];					// Weight Background
			if (wB == 0) continue;

			wF = total - wB;						// Weight Foreground
			if (wF == 0) break;

			sumB += (float) (t * histData[t]);

			float mB = sumB / wB;				// Mean Background
			float mF = (sum - sumB) / wF;		// Mean Foreground

			// Calculate Between Class Variance
			float varBetween = (float)wB * (float)wF * (mB - mF) * (mB - mF);	

			// Check if new maximum found
			if (varBetween > varMax) {
				varMax = varBetween;
				threshold = t;
			}
		}

		// Apply threshold to create binary image
		if (monoData != null)
		{
			ptr = 0;
			while (ptr < srcData.length)
			{
				monoData[ptr] = ((0xFF & srcData[ptr]) >= threshold) ? (byte) 255 : 0;
				ptr ++;
			}
		}

		return threshold;
	}
	
	public static BufferedImage Threshold(BufferedImage img,int requiredThresholdValue) {
		 
		int height = img.getHeight();
		int width = img.getWidth();
		BufferedImage finalThresholdImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;
		//Februari 2012
		int blue = 0;
		int red = 0;
		int green = 0;
		
 
		for (int x = 0; x < width; x++) {
//			System.out.println("Row: " + x);
			try {
 
				for (int y = 0; y < height; y++) {
					int color = img.getRGB(x, y);
		//Februari 2012
					blue = getBlue(color);
					red = getRed(color);
					green = getGreen(color);
					
 
//					System.out.println("Threshold : " + requiredThresholdValue);
						if((red+green+blue)/3 < (int) (requiredThresholdValue)) {
							finalThresholdImage.setRGB(x,y,mixColor(0,0,0));
						}
						else {
							finalThresholdImage.setRGB(x,y, mixColor(255,255,255));
						}
 
				}
			} catch (Exception e) {
				 e.getMessage();
			}
		}
 
		return finalThresholdImage;
	}
	
	
	private static int mixColor(int red, int green, int blue) {
		return red<<16|green<<8|blue;
	}
 
	public static int getRed(int color) {
		return (color & 0x00ff0000)  >> 16;
	}
 
	public static int getGreen(int color) {
		return	(color & 0x0000ff00)  >> 8;
	}
 
	public static int getBlue(int color) {
		return (color & 0x000000ff)  >> 0;
 
	}//end
	
}
