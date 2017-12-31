package controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

public class CutFrame {

	private static String filePathBinary = "";

	public static int[][] arrayImage;
	public static int[][] arrayImageSave;
	public static int[][] arrayImageSaveWord;

	private int[][] frameWithoutText;

	private BufferedImage buffImageInput;
	private int width = 0;
	private int height = 0;

	boolean words = false;
	boolean wordr = false;
	boolean wordx = false;
	boolean wordrD = false;
	boolean wordsD = false;

	int ycalBlackColumnsUpper = 0;
	int ycalBlackColumnsBottom = 0;
	int xcalBlackColumnsRight = 0;
	int xcalBlackColumnsLeft = 0;

	String nameFile = "";
	BufferedImage image;
	BufferedImage imageFrameWithoutText;

	private ArrayList<String> lineCut = new ArrayList<String>();

	public void setImage(int[][] arrayImage, BufferedImage buffImageInput) {
		this.arrayImage = new int[arrayImage.length][arrayImage[1].length];
		this.arrayImageSave = new int[arrayImage.length][arrayImage[1].length];
		this.arrayImageSaveWord = new int[arrayImage.length][arrayImage[1].length];

		CutFrame.arrayImage = arrayImage;
		this.buffImageInput = buffImageInput;

		width = buffImageInput.getWidth();
		height = buffImageInput.getHeight();

	}

	public File upperFrame(String directData, String picName) throws IOException {
		int calBlack = 0;
		int[] aRow = new int[height];
		int[] aColumn = new int[width];
		int ycoordinate = 0;
		int xcoordinate = 0;
		boolean pitch = false;

		for (int y = 0; y <= height - 1; y++) // (int x=width-1 ; x>=0 ; x--)
		{
			for (int x = 0; x <= width - 1; x++) {
				if (arrayImage[y][x] == 0 && pitch == false) {
					ycoordinate = y;
					xcoordinate = x;
					pitch = true;

				}
			}
		}
		boolean find = false;

		for (int y = 0; y < height; y++) // (int x=width-1 ; x>=0 ; x--)
		{
			for (int x = 0; x < width; x++) {
				arrayImageSave[y][x] = 1;
			}

		}

		// arrayImageSave[44 ][265 ] = 0;

		// from upper
		int calBlackColumnsUpper = 0;

		for (int y = 1; y < height; y++) {
			if (arrayImage[y][width / 2] == 1) {
				calBlackColumnsUpper = calBlackColumnsUpper + 1;
			}

			if (arrayImage[y][width / 2] == 0) {
				calBlackColumnsUpper = 0;
			}

			if (calBlackColumnsUpper >= 27) {
				ycalBlackColumnsUpper = y;
				break;
			}

		}

		for (int a = 1; a < ycalBlackColumnsUpper; a++) {
			for (int b = 1; b < width; b++) {
				if (arrayImage[a][b] == 0) // width/4 width*0.25
				{
					arrayImageSave[a][b] = 0; // width*0.75 (width*3)/4
				}
			}

		}

		boolean startupper = false;
		int calstartupper = 0;

		for (int x = 1; x < width; x++) {
			for (int y = 1; y < height; y++) {
				if (arrayImage[y][x] == 0) {
					startupper = true;
					arrayImageSave[y][x] = 0;
					calstartupper = 0;
				}
				if (arrayImage[y][x] == 1 && startupper == true) {
					calstartupper = calstartupper + 1;
				}
				if (calstartupper >= 6) {
					break;
				}
			}
			startupper = false;
			calstartupper = 0;
		}

		boolean startupperL = false;
		int calstartupperL = 0;

		for (int x = width - 1; x > 0; x--) {
			for (int y = 1; y < height; y++) {
				if (arrayImage[y][x] == 0) {
					startupperL = true;
					arrayImageSave[y][x] = 0;
					calstartupperL = 0;
				}
				if (arrayImage[y][x] == 1 && startupperL == true) {
					calstartupperL = calstartupperL + 1;
				}
				if (calstartupperL >= 6) {
					break;
				}
			}
			startupperL = false;
			calstartupperL = 0;
		}

		// from bottom
		int calBlackColumnsBottom = 0;

		for (int y = height - 1; y > 1; y--) {
			if (arrayImage[y][width / 2] == 1) {
				calBlackColumnsBottom = calBlackColumnsBottom + 1;
			}

			if (arrayImage[y][width / 2] == 0) {
				calBlackColumnsBottom = 0;
			}

			if (calBlackColumnsBottom >= 25) {
				ycalBlackColumnsBottom = y;
				break;
			}

		}

		for (int a = height - 1; a > ycalBlackColumnsBottom; a--) {
			for (int b = 1; b < width; b++) {
				if (arrayImage[a][b] == 0) // width/4 width*0.25
				{
					arrayImageSave[a][b] = 0; // width*0.75 (width*3)/4
				}
			}

		}

		boolean startbottom = false;
		int calstartbottom = 0;

		for (int x = 1; x < width; x++) {
			for (int y = height - 1; y > 0; y--) {
				if (arrayImage[y][x] == 0) {
					startbottom = true;
					arrayImageSave[y][x] = 0;
					calstartbottom = 0;
				}
				if (arrayImage[y][x] == 1 && startbottom == true) {
					calstartbottom = calstartbottom + 1;
				}
				if (calstartbottom >= 6) {
					break;
				}
			}
			startbottom = false;
			calstartbottom = 0;
		}

		boolean startbottomL = false;
		int calstartbottomL = 0;

		for (int x = width - 1; x > 0; x--) {
			for (int y = height - 1; y > 0; y--) {
				if (arrayImage[y][x] == 0) {
					startbottomL = true;
					arrayImageSave[y][x] = 0;
					calstartbottomL = 0;
				}
				if (arrayImage[y][x] == 1 && startbottomL == true) {
					calstartbottomL = calstartbottomL + 1;
				}
				if (calstartbottomL >= 6) {
					break;
				}
			}
			startbottomL = false;
			calstartbottomL = 0;
		}

		// from right
		int calBlackColumnsRight = 0;

		for (int x = width - 1; x > 1; x--) {
			if (arrayImage[height / 2][x] == 1) {
				calBlackColumnsRight = calBlackColumnsRight + 1;
			}

			if (arrayImage[height / 2][x] == 0) {
				calBlackColumnsRight = 0;
			}

			if (calBlackColumnsRight >= 6) {
				xcalBlackColumnsRight = x;
				break;
			}
		}

		for (int x = width - 1; x > xcalBlackColumnsRight; x--) {
			for (int y = 1; y < height - 1; y++) {
				if (arrayImage[y][x] == 0) // width/4 width*0.25
				{
					arrayImageSave[y][x] = 0; // width*0.75 (width*3)/4
				}
			}
		}

		boolean startright = false;
		int calstartright = 0;
		for (int y = 1; y < height; y++) {
			for (int x = width - 1; x > 0; x--) {

				if (arrayImage[y][x] == 0) {
					startright = true;
					arrayImageSave[y][x] = 0;
					calstartright = 0;
				}
				if (arrayImage[y][x] == 1 && startright == true) {
					calstartright = calstartright + 1;
				}
				if (calstartright >= 6) {
					break;
				}
			}
			startright = false;
			calstartright = 0;
		}

		boolean startrightB = false;
		int calstartrightB = 0;
		for (int y = height - 1; y > 0; y--) {
			for (int x = width - 1; x > 0; x--) {

				if (arrayImage[y][x] == 0) {
					startrightB = true;
					arrayImageSave[y][x] = 0;
					calstartrightB = 0;
				}
				if (arrayImage[y][x] == 1 && startrightB == true) {
					calstartrightB = calstartrightB + 1;
				}
				if (calstartrightB >= 6) {
					break;
				}
			}
			startrightB = false;
			calstartrightB = 0;
		}

		// from left

		int calBlackColumnsLeft = 0;

		for (int x = 1; x > width; x++) {
			if (arrayImage[height / 2][x] == 1) {
				calBlackColumnsLeft = calBlackColumnsLeft + 1;
			}

			if (arrayImage[height / 2][x] == 0) {
				calBlackColumnsLeft = 0;
			}

			if (calBlackColumnsLeft >= 6) {
				xcalBlackColumnsLeft = x;
				break;
			}
		}

		for (int x = 1; x < xcalBlackColumnsLeft; x++) {
			for (int y = 1; y < height - 1; y++) {
				if (arrayImage[y][x] == 0) // width/4 width*0.25
				{
					arrayImageSave[y][x] = 0; // width*0.75 (width*3)/4
				}
			}
		}

		boolean startleft = false;
		int calstartleft = 0;
		for (int y = 1; y < height; y++) {
			for (int x = 1; x < width; x++) {

				if (arrayImage[y][x] == 0) {
					startleft = true;
					arrayImageSave[y][x] = 0;
					calstartleft = 0;
				}
				if (arrayImage[y][x] == 1 && startleft == true) {
					calstartleft = calstartleft + 1;
				}
				if (calstartleft >= 6) {
					break;
				}
			}
			startleft = false;
			calstartleft = 0;
		}

		boolean startleftB = false;
		int calstartleftB = 0;
		for (int y = height - 1; y > 0; y--) {
			for (int x = 1; x < width; x++) {

				if (arrayImage[y][x] == 0) {
					startleftB = true;
					arrayImageSave[y][x] = 0;
					calstartleftB = 0;
				}
				if (arrayImage[y][x] == 1 && startleftB == true) {
					calstartleftB = calstartleftB + 1;
				}
				if (calstartleftB >= 6) {
					break;
				}
			}
			startleftB = false;
			calstartleftB = 0;
		}

		upperRight();
		bottomRight();
		upperLeft();
		bottomLeft();
		leftUpper();
		rightUpper();
		leftBottom();
		rightBottom();
		setFrameWithoutText(arrayImageSave);
		print();
		File filePicWithoutFrame = cropImageWord(directData, picName);
		return filePicWithoutFrame;
	}

	public int[][] getFrameWithoutText() {
		return frameWithoutText;
	}

	public void setFrameWithoutText(int[][] arrayImageSave) {
		frameWithoutText = arrayImageSave;
	}

	public File printFrameWithoutText(int[][] arrayImageSave, String parentDirectory, String picName) throws IOException {
		imageFrameWithoutText = buffImageInput;

		@SuppressWarnings("unused")
		int countRow = 0;

		int x = height;
		int y = width;

		int[][] pixelsR = new int[x][y];
		int[][] pixelsG = new int[x][y];
		int[][] pixelsB = new int[x][y];

		for (int i = 0; i < height; i++) {

			for (int j = 0; j < width; j++) {

				int red = 0;
				int green = 0;
				int blue = 0;

				if (arrayImageSave[i][j] == 1) {
					red = 255;
					green = 255;
					blue = 255;
				}

				pixelsR[i][j] = red;
				pixelsG[i][j] = green;
				pixelsB[i][j] = blue;

				Color newColor = new Color(red, green, blue);
				imageFrameWithoutText.setRGB(j, i, newColor.getRGB());
			}
			countRow++;
		}

		File mOutput = new File(parentDirectory + "/tashih/processed/frame/frame/" + picName);
		
		mOutput.getParentFile().mkdirs();
		ImageIO.write(imageFrameWithoutText, "jpg", mOutput);

		return mOutput;

		// FileWriter writer;
		// String nameFile = "cutUpperFrame"+new Long(new
		// Date().getTime()).toString()+".txt";
		// File file = new File(nameFile);
		//
		// if (file.exists())
		// {
		// writer = new FileWriter(file, true);
		// }
		// else
		// {
		// writer = new FileWriter(file);
		// for (int y=1 ; y<height ; y++) //height downFamreLimitY-upFrameLimitY
		// {
		//
		// for ( int x=1 ; x< width ; x++) //( int x=0 ; x< rightFamreLimitX ; x++)
		// {
		// if (arrayImageSave[y][x] == 0)
		// {
		// writer.append("0");
		// }
		// else if (arrayImageSave[y][x] == 1)
		// {
		// writer.append("1");
		// }
		// }
		// writer.append(System.lineSeparator());
		// String s = Integer.toString(y);
		// writer.append(s);
		//
		// }
		// }

	}

	public void upperRight() throws IOException {
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ atas bawah
		// kanan kiri

		for (int x = width - 3; x >= 2; x--) // (int x=width-1 ; x>=0 ; x--)
		{
			for (int y = 2; y <= height - 3; y++) // int y= 1 ; y<=height-1 ; y++
			{

				int xs = x + 1;
				int ys1 = y - 1;
				int ys2 = y;
				int ys3 = y + 1;
				int ys4 = y - 2;
				int ys5 = y + 2;

				int xr = x - 1;
				int yr1 = y - 1;
				int yr2 = y;
				int yr3 = y + 1;
				int yr4 = y - 2;
				int yr5 = y + 2;

				int xx = x;
				int yx1 = y - 1;
				int yx2 = y;
				int yx3 = y + 1;
				int yx4 = y - 2;
				int yx5 = y + 2;

				int xsD = x + 2;
				int ysD1 = y - 1;
				int ysD2 = y;
				int ysD3 = y + 1;
				int ysD4 = y - 2;
				int ysD5 = y + 2;

				int xrD = x - 2;
				int yrD1 = y - 1;
				int yrD2 = y;
				int yrD3 = y + 1;
				int yrD4 = y - 2;
				int yrD5 = y + 2;

				// boolean words = false;
				// boolean wordr = false;
				// boolean wordx = false;
				// boolean wordrD = false;
				// boolean wordsD = false;

				// if (arrayImageSave[y][x] ==0)
				// {
				// || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 ||
				// arrayImageSave[yr3][xr] == 0
				// }

				if (arrayImage[yx1][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys1][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr1][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD1][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD1][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// --------------------------------------------------------------

				if (arrayImage[yx2][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys2][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr2][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD2][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD2][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// ------------------------------------------------------------------
				if (arrayImage[yx3][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys3][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr3][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD3][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD3][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// -------------------------------------------------------------------

				if (arrayImage[yx4][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys4][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr4][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD4][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD4][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}
				// ------------------------------------------------------------------------------

				if (arrayImage[yx5][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys5][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr5][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD5][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD5][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// boolean words = false;
				// boolean wordr = false;
				// boolean wordx = false;
				// boolean wordrD = false;
				// boolean wordsD = false;

				if (arrayImage[y][x] == 0 && words == true) {
					// arrayImageSave[y][x] = arrayImage[y][x];
					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordr == true) {
					// arrayImageSave[y][x] = arrayImage[y][x];
					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordx == true) {
					// arrayImageSave[y][x] = arrayImage[y][x];
					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordrD == true) {
					// arrayImageSave[y][x] = arrayImage[y][x];
					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordsD == true) {
					// arrayImageSave[y][x] = arrayImage[y][x];
					arrayImageSave[y][x] = 0;
				}

				// if ( word== false && wordr== false)
				// {
				// break;
				// }

				words = false;
				wordr = false;
				wordx = false;
				wordrD = false;
				wordsD = false;

			}

			words = false;
			wordr = false;
			wordx = false;
			wordrD = false;
			wordsD = false;

		}

		words = false;
		wordr = false;
		wordx = false;
		wordrD = false;
		wordsD = false;

	}

	public void bottomRight() throws IOException {
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ bawah atas
		// kanan kiri

		for (int x = width - 3; x >= 2; x--) // (int x=width-1 ; x>=0 ; x--)
		{
			for (int y = height - 3; y >= 2; y--) // int y= 1 ; y<=height-1 ; y++
			{

				int xs = x + 1;
				int ys1 = y - 1;
				int ys2 = y;
				int ys3 = y + 1;
				int ys4 = y - 2;
				int ys5 = y + 2;

				int xr = x - 1;
				int yr1 = y - 1;
				int yr2 = y;
				int yr3 = y + 1;
				int yr4 = y - 2;
				int yr5 = y + 2;

				int xx = x;
				int yx1 = y - 1;
				int yx2 = y;
				int yx3 = y + 1;
				int yx4 = y - 2;
				int yx5 = y + 2;

				int xsD = x + 2;
				int ysD1 = y - 1;
				int ysD2 = y;
				int ysD3 = y + 1;
				int ysD4 = y - 2;
				int ysD5 = y + 2;

				int xrD = x - 2;
				int yrD1 = y - 1;
				int yrD2 = y;
				int yrD3 = y + 1;
				int yrD4 = y - 2;
				int yrD5 = y + 2;

				if (arrayImage[yx1][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys1][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr1][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD1][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD1][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// --------------------------------------------------------------

				if (arrayImage[yx2][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys2][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr2][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD2][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD2][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// ------------------------------------------------------------------
				if (arrayImage[yx3][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys3][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr3][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD3][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD3][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// -------------------------------------------------------------------

				if (arrayImage[yx4][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys4][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr4][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD4][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD4][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}
				// ------------------------------------------------------------------------------

				if (arrayImage[yx5][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys5][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr5][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD5][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD5][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				if (arrayImage[y][x] == 0 && words == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordr == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordx == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordrD == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordsD == true) {

					arrayImageSave[y][x] = 0;
				}

				words = false;
				wordr = false;
				wordx = false;
				wordrD = false;
				wordsD = false;

			}

			words = false;
			wordr = false;
			wordx = false;
			wordrD = false;
			wordsD = false;

		}

		words = false;
		wordr = false;
		wordx = false;
		wordrD = false;
		wordsD = false;

	}

	public void upperLeft() throws IOException {

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ atas bawah kiri
		// kanan

		for (int x = 2; x <= width - 3; x++) // (int x=width-1 ; x>=0 ; x--)
		{
			for (int y = 2; y <= height - 3; y++) // int y= 1 ; y<=height-1 ; y++
			{

				int xs = x + 1;
				int ys1 = y - 1;
				int ys2 = y;
				int ys3 = y + 1;
				int ys4 = y - 2;
				int ys5 = y + 2;

				int xr = x - 1;
				int yr1 = y - 1;
				int yr2 = y;
				int yr3 = y + 1;
				int yr4 = y - 2;
				int yr5 = y + 2;

				int xx = x;
				int yx1 = y - 1;
				int yx2 = y;
				int yx3 = y + 1;
				int yx4 = y - 2;
				int yx5 = y + 2;

				int xsD = x + 2;
				int ysD1 = y - 1;
				int ysD2 = y;
				int ysD3 = y + 1;
				int ysD4 = y - 2;
				int ysD5 = y + 2;

				int xrD = x - 2;
				int yrD1 = y - 1;
				int yrD2 = y;
				int yrD3 = y + 1;
				int yrD4 = y - 2;
				int yrD5 = y + 2;

				if (arrayImage[yx1][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys1][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr1][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD1][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD1][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// --------------------------------------------------------------

				if (arrayImage[yx2][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys2][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr2][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD2][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD2][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// ------------------------------------------------------------------
				if (arrayImage[yx3][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys3][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr3][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD3][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD3][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// -------------------------------------------------------------------

				if (arrayImage[yx4][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys4][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr4][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD4][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD4][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}
				// ------------------------------------------------------------------------------

				if (arrayImage[yx5][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys5][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr5][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD5][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD5][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				if (arrayImage[y][x] == 0 && words == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordr == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordx == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordrD == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordsD == true) {

					arrayImageSave[y][x] = 0;
				}

				words = false;
				wordr = false;
				wordx = false;
				wordrD = false;
				wordsD = false;

			}

			words = false;
			wordr = false;
			wordx = false;
			wordrD = false;
			wordsD = false;

		}

		words = false;
		wordr = false;
		wordx = false;
		wordrD = false;
		wordsD = false;

	}

	public void bottomLeft() throws IOException {

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ bawah atas kiri
		// kanan

		for (int x = 2; x <= width - 3; x++) // (int x=width-1 ; x>=0 ; x--)
		{
			for (int y = height - 3; y <= 2; y--) // int y= 1 ; y<=height-1 ; y++
			{

				int xs = x + 1;
				int ys1 = y - 1;
				int ys2 = y;
				int ys3 = y + 1;
				int ys4 = y - 2;
				int ys5 = y + 2;

				int xr = x - 1;
				int yr1 = y - 1;
				int yr2 = y;
				int yr3 = y + 1;
				int yr4 = y - 2;
				int yr5 = y + 2;

				int xx = x;
				int yx1 = y - 1;
				int yx2 = y;
				int yx3 = y + 1;
				int yx4 = y - 2;
				int yx5 = y + 2;

				int xsD = x + 2;
				int ysD1 = y - 1;
				int ysD2 = y;
				int ysD3 = y + 1;
				int ysD4 = y - 2;
				int ysD5 = y + 2;

				int xrD = x - 2;
				int yrD1 = y - 1;
				int yrD2 = y;
				int yrD3 = y + 1;
				int yrD4 = y - 2;
				int yrD5 = y + 2;

				if (arrayImage[yx1][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys1][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr1][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD1][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD1][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// --------------------------------------------------------------

				if (arrayImage[yx2][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys2][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr2][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD2][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD2][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// ------------------------------------------------------------------
				if (arrayImage[yx3][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys3][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr3][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD3][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD3][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// -------------------------------------------------------------------

				if (arrayImage[yx4][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys4][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr4][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD4][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD4][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}
				// ------------------------------------------------------------------------------

				if (arrayImage[yx5][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys5][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr5][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD5][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD5][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				if (arrayImage[y][x] == 0 && words == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordr == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordx == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordrD == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordsD == true) {

					arrayImageSave[y][x] = 0;
				}

				words = false;
				wordr = false;
				wordx = false;
				wordrD = false;
				wordsD = false;

			}

			words = false;
			wordr = false;
			wordx = false;
			wordrD = false;
			wordsD = false;

		}

		words = false;
		wordr = false;
		wordx = false;
		wordrD = false;
		wordsD = false;

	}

	public void leftUpper() throws IOException {

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ kiri kanan atas
		// bawah

		for (int y = 2; y <= height - 3; y++) // (int x=width-1 ; x>=0 ; x--)
		{
			for (int x = 2; x <= width - 3; x++) // int y= 1 ; y<=height-1 ; y++
			{

				int xs = x + 1;
				int ys1 = y - 1;
				int ys2 = y;
				int ys3 = y + 1;
				int ys4 = y - 2;
				int ys5 = y + 2;

				int xr = x - 1;
				int yr1 = y - 1;
				int yr2 = y;
				int yr3 = y + 1;
				int yr4 = y - 2;
				int yr5 = y + 2;

				int xx = x;
				int yx1 = y - 1;
				int yx2 = y;
				int yx3 = y + 1;
				int yx4 = y - 2;
				int yx5 = y + 2;

				int xsD = x + 2;
				int ysD1 = y - 1;
				int ysD2 = y;
				int ysD3 = y + 1;
				int ysD4 = y - 2;
				int ysD5 = y + 2;

				int xrD = x - 2;
				int yrD1 = y - 1;
				int yrD2 = y;
				int yrD3 = y + 1;
				int yrD4 = y - 2;
				int yrD5 = y + 2;

				if (arrayImage[yx1][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys1][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr1][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD1][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD1][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// --------------------------------------------------------------

				if (arrayImage[yx2][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys2][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr2][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD2][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD2][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// ------------------------------------------------------------------
				if (arrayImage[yx3][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys3][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr3][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD3][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD3][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// -------------------------------------------------------------------

				if (arrayImage[yx4][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys4][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr4][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD4][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD4][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}
				// ------------------------------------------------------------------------------

				if (arrayImage[yx5][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys5][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr5][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD5][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD5][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				if (arrayImage[y][x] == 0 && words == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordr == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordx == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordrD == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordsD == true) {

					arrayImageSave[y][x] = 0;
				}

				words = false;
				wordr = false;
				wordx = false;
				wordrD = false;
				wordsD = false;

			}

			words = false;
			wordr = false;
			wordx = false;
			wordrD = false;
			wordsD = false;

		}

		words = false;
		wordr = false;
		wordx = false;
		wordrD = false;
		wordsD = false;

	}

	public void rightUpper() throws IOException {

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ kanan kiri atas
		// bawah

		for (int y = 2; y <= height - 3; y++) // (int x=width-1 ; x>=0 ; x--)
		{
			for (int x = width - 3; x >= 2; x--) // int y= 1 ; y<=height-1 ; y++
			{

				int xs = x + 1;
				int ys1 = y - 1;
				int ys2 = y;
				int ys3 = y + 1;
				int ys4 = y - 2;
				int ys5 = y + 2;

				int xr = x - 1;
				int yr1 = y - 1;
				int yr2 = y;
				int yr3 = y + 1;
				int yr4 = y - 2;
				int yr5 = y + 2;

				int xx = x;
				int yx1 = y - 1;
				int yx2 = y;
				int yx3 = y + 1;
				int yx4 = y - 2;
				int yx5 = y + 2;

				int xsD = x + 2;
				int ysD1 = y - 1;
				int ysD2 = y;
				int ysD3 = y + 1;
				int ysD4 = y - 2;
				int ysD5 = y + 2;

				int xrD = x - 2;
				int yrD1 = y - 1;
				int yrD2 = y;
				int yrD3 = y + 1;
				int yrD4 = y - 2;
				int yrD5 = y + 2;

				if (arrayImage[yx1][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys1][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr1][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD1][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD1][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// --------------------------------------------------------------

				if (arrayImage[yx2][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys2][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr2][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD2][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD2][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// ------------------------------------------------------------------
				if (arrayImage[yx3][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys3][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr3][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD3][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD3][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// -------------------------------------------------------------------

				if (arrayImage[yx4][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys4][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr4][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD4][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD4][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}
				// ------------------------------------------------------------------------------

				if (arrayImage[yx5][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys5][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr5][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD5][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD5][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				if (arrayImage[y][x] == 0 && words == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordr == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordx == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordrD == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordsD == true) {

					arrayImageSave[y][x] = 0;
				}

				words = false;
				wordr = false;
				wordx = false;
				wordrD = false;
				wordsD = false;

			}

			words = false;
			wordr = false;
			wordx = false;
			wordrD = false;
			wordsD = false;

		}

		words = false;
		wordr = false;
		wordx = false;
		wordrD = false;
		wordsD = false;

	}

	public void leftBottom() throws IOException {
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ kiri kanan
		// bawah atas

		for (int y = height - 3; y >= 2; y--) // (int x=width-1 ; x>=0 ; x--) int y=1 ; y<=height-2 ; y++
		{
			for (int x = 2; x <= width - 3; x++) // int y= 1 ; y<=height-1 ; y++ int x=1 ; x<=width-2 ; x++
			{

				int xs = x + 1;
				int ys1 = y - 1;
				int ys2 = y;
				int ys3 = y + 1;
				int ys4 = y - 2;
				int ys5 = y + 2;

				int xr = x - 1;
				int yr1 = y - 1;
				int yr2 = y;
				int yr3 = y + 1;
				int yr4 = y - 2;
				int yr5 = y + 2;

				int xx = x;
				int yx1 = y - 1;
				int yx2 = y;
				int yx3 = y + 1;
				int yx4 = y - 2;
				int yx5 = y + 2;

				int xsD = x + 2;
				int ysD1 = y - 1;
				int ysD2 = y;
				int ysD3 = y + 1;
				int ysD4 = y - 2;
				int ysD5 = y + 2;

				int xrD = x - 2;
				int yrD1 = y - 1;
				int yrD2 = y;
				int yrD3 = y + 1;
				int yrD4 = y - 2;
				int yrD5 = y + 2;

				if (arrayImage[yx1][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys1][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr1][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD1][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD1][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// --------------------------------------------------------------

				if (arrayImage[yx2][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys2][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr2][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD2][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD2][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// ------------------------------------------------------------------
				if (arrayImage[yx3][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys3][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr3][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD3][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD3][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// -------------------------------------------------------------------

				if (arrayImage[yx4][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys4][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr4][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD4][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD4][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}
				// ------------------------------------------------------------------------------

				if (arrayImage[yx5][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys5][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr5][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD5][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD5][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				if (arrayImage[y][x] == 0 && words == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordr == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordx == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordrD == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordsD == true) {

					arrayImageSave[y][x] = 0;
				}

				words = false;
				wordr = false;
				wordx = false;
				wordrD = false;
				wordsD = false;

			}

			words = false;
			wordr = false;
			wordx = false;
			wordrD = false;
			wordsD = false;

		}

		words = false;
		wordr = false;
		wordx = false;
		wordrD = false;
		wordsD = false;

	}

	public void rightBottom() throws IOException {
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ kanan kiri
		// bawah atas

		for (int y = height - 3; y >= 2; y--) // (int x=width-1 ; x>=0 ; x--) int y=1 ; y<=height-2 ; y++
		{
			for (int x = width - 3; x >= 2; x--) // int y= 1 ; y<=height-1 ; y++ int x=1 ; x<=width-2 ; x++
			{

				int xs = x + 1;
				int ys1 = y - 1;
				int ys2 = y;
				int ys3 = y + 1;
				int ys4 = y - 2;
				int ys5 = y + 2;

				int xr = x - 1;
				int yr1 = y - 1;
				int yr2 = y;
				int yr3 = y + 1;
				int yr4 = y - 2;
				int yr5 = y + 2;

				int xx = x;
				int yx1 = y - 1;
				int yx2 = y;
				int yx3 = y + 1;
				int yx4 = y - 2;
				int yx5 = y + 2;

				int xsD = x + 2;
				int ysD1 = y - 1;
				int ysD2 = y;
				int ysD3 = y + 1;
				int ysD4 = y - 2;
				int ysD5 = y + 2;

				int xrD = x - 2;
				int yrD1 = y - 1;
				int yrD2 = y;
				int yrD3 = y + 1;
				int yrD4 = y - 2;
				int yrD5 = y + 2;

				if (arrayImage[yx1][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys1][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr1][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD1][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD1][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// --------------------------------------------------------------

				if (arrayImage[yx2][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys2][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr2][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD2][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD2][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// ------------------------------------------------------------------
				if (arrayImage[yx3][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys3][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr3][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD3][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD3][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				// -------------------------------------------------------------------

				if (arrayImage[yx4][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys4][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr4][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD4][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD4][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}
				// ------------------------------------------------------------------------------

				if (arrayImage[yx5][xx] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordx = true;
					}
				}

				if (arrayImage[ys5][xs] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						words = true;
					}
				}

				if (arrayImage[yr5][xr] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordr = true;
					}
				}

				if (arrayImage[ysD5][xsD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordsD = true;
					}
				}

				if (arrayImage[yrD5][xrD] == 0) {
					if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0
							|| arrayImageSave[yx4][xx] == 0 || arrayImageSave[yx5][xx] == 0
							|| arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0
							|| arrayImageSave[ys3][xs] == 0 || arrayImageSave[ys4][xs] == 0
							|| arrayImageSave[ys5][xs] == 0 || arrayImageSave[yr1][xr] == 0
							|| arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0
							|| arrayImageSave[yr4][xr] == 0 || arrayImageSave[yr5][xr] == 0
							|| arrayImageSave[ysD1][xsD] == 0 || arrayImageSave[ysD2][xsD] == 0
							|| arrayImageSave[ysD3][xsD] == 0 || arrayImageSave[ysD4][xsD] == 0
							|| arrayImageSave[ysD5][xsD] == 0 || arrayImageSave[yrD1][xrD] == 0
							|| arrayImageSave[yrD2][xrD] == 0 || arrayImageSave[yrD3][xrD] == 0
							|| arrayImageSave[yrD4][xrD] == 0 || arrayImageSave[yrD5][xrD] == 0) {

						wordrD = true;
					}
				}

				if (arrayImage[y][x] == 0 && words == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordr == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordx == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordrD == true) {

					arrayImageSave[y][x] = 0;
				}

				if (arrayImage[y][x] == 0 && wordsD == true) {

					arrayImageSave[y][x] = 0;
				}

				words = false;
				wordr = false;
				wordx = false;
				wordrD = false;
				wordsD = false;

			}

			words = false;
			wordr = false;
			wordx = false;
			wordrD = false;
			wordsD = false;

		}

		words = false;
		wordr = false;
		wordx = false;
		wordrD = false;
		wordsD = false;

		for (int y = 0; y < height; y++) // (int x=width-1 ; x>=0 ; x--)
		{
			for (int x = 0; x < width; x++) {

			}

		}

		for (int y = 1; y < height; y++) {
			for (int x = 1; x < width; x++) {
				if (arrayImageSave[y][x] == 0 && arrayImage[y][x] == 0) {
					arrayImageSaveWord[y][x] = 1;
				}

				if (arrayImage[y][x] == 0 && arrayImageSave[y][x] == 1) {
					arrayImageSaveWord[y][x] = 0;
				}

				if (arrayImage[y][x] == 1 && arrayImageSave[y][x] == 1) {
					arrayImageSaveWord[y][x] = 1;
				}
			}

		}

	}

	public void print() throws IOException {
		image = buffImageInput;

		@SuppressWarnings("unused")
		int countRow = 0;

		int x = height;
		int y = width;

		int[][] pixelsR = new int[x][y];
		int[][] pixelsG = new int[x][y];
		int[][] pixelsB = new int[x][y];

		for (int i = 0; i < height; i++) {

			for (int j = 0; j < width; j++) {

				int red = 0;
				int green = 0;
				int blue = 0;

				if (arrayImageSaveWord[i][j] == 1) {
					red = 255;
					green = 255;
					blue = 255;
				}

				pixelsR[i][j] = red;
				pixelsG[i][j] = green;
				pixelsB[i][j] = blue;

				Color newColor = new Color(red, green, blue);
				image.setRGB(j, i, newColor.getRGB());
			}
			countRow++;
		}

		nameFile = new Long(new Date().getTime()).toString();

	}

	public File cropImageWord(String directData, String picName) throws IOException {
		int[] aRow = new int[height];
		int[] aColumn = new int[width];

		int calZeroRow = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (arrayImageSaveWord[y][x] == 0) {
					calZeroRow = calZeroRow + 1;
				}
			}
			aRow[y] = calZeroRow;
			calZeroRow = 0;
		}

		int calZeroColumn = 0;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (arrayImageSaveWord[y][x] == 0) {
					calZeroColumn = calZeroColumn + 1;
				}
			}
			aColumn[x] = calZeroColumn;
			calZeroColumn = 0;
		}

		int starterUpper = 0;
		int cutRowUpper = 0;
		for (int r = 0; r < height; r++) {
			if (aRow[r] > 2) {
				starterUpper = starterUpper + 1;
			}

			if (aRow[r] < 2) {
				starterUpper = 0;
			}

			if (starterUpper > 9) {

				cutRowUpper = r - 20;
				starterUpper = 0;
				break;
			}

		}

		int starterBottom = 0;
		int cutRowBottom = 0;
		for (int r = height - 1; r >= 1; r--) {
			if (aRow[r] > 2) {
				starterBottom = starterBottom + 1;
			}

			if (aRow[r] < 2) {
				starterBottom = 0;
			}

			if (starterBottom > 9) {
				cutRowBottom = r + 20;
				starterBottom = 0;
				break;
			}

		}

		int starterLeft = 0;
		int cutRowLeft = 0;
		for (int r = 0; r < width; r++) {
			if (aColumn[r] > 2) {
				starterLeft = starterLeft + 1;
			}

			if (aColumn[r] < 2) {
				starterLeft = 0;
			}

			if (starterLeft > 9) {
				cutRowLeft = r - 20;
				starterLeft = 0;
				break;
			}

		}

		int starterRight = 0;
		int cutRowRight = 0;
		for (int r = width - 1; r >= 1; r--) {
			if (aColumn[r] > 2) {
				starterRight = starterRight + 1;
			}

			if (aColumn[r] < 2) {
				starterRight = 0;
			}

			if (starterRight > 9) {
				cutRowRight = r + 20;
				starterRight = 0;
				break;
			}

		}

		int w = cutRowRight - cutRowLeft;
		int h = cutRowBottom - cutRowUpper;

		CropFrame cropImg = new CropFrame();
		File filePicWithoutFrame = cropImg.doCrop(this.image, cutRowLeft, cutRowUpper, w, h, directData, picName);
		return filePicWithoutFrame;
	}

}
