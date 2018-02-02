package controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class CutAlphabet {

    public static int[][] arrayImage;
    public static int[][] arrayImageSave;
    public static int[][] arrayImageLocate;
    public static int[][] trackLocate;

    private BufferedImage buffImageInput; //access pictures in bytes
    private BufferedImage image;
    private int width = 0;
    private int height = 0;
    String nameFile = "";
    private ArrayList<File> ouptuts = new ArrayList<File>();
    private int pointer = 0;

    public void setImage(int[][] arrayImage, BufferedImage buffImageInput) {
        this.arrayImage = new int[arrayImage.length][arrayImage[1].length];
        this.arrayImageSave = new int[arrayImage.length][arrayImage[1].length];
        this.arrayImageLocate = new int[arrayImage.length][arrayImage[1].length];
        this.trackLocate = new int[arrayImage.length][arrayImage[1].length];

        CutAlphabet.arrayImage = arrayImage;
        this.buffImageInput = buffImageInput;

        width = buffImageInput.getWidth();
        height = buffImageInput.getHeight();
    }

    public void upperFrame() throws IOException {
        int sign = 0;

        int ycoordinate = 0;
        int xcoordinate = 0;
        boolean pitch = false;
        int zero = 0;


        boolean check = false;

        //Untuk detect a bit by bit nombor 1 atau 0
        //detect y dari initial array paling atas sampai bawah
        for (int y = 0; y <= height - 1; y++)    //(int x=width-1 ; x>=0 ; x--)
        {
            for (int x = 0; x <= width - 1; x++) //detect x dari initial array kiri sampai pling kanan
            {
                if (arrayImage[y][x] == 0 && pitch == false) {
                    ycoordinate = y;
                    xcoordinate = x;
                    pitch = true;
                    sign = 0;
                }
            }
        }
        //Untuk kira frequency amount of 0 yg ada dalam satu-satu column
        boolean stopFlag = false;
        int calFlag = 0; // to stop do from looping
        if (sign == 0) {
            do {

                int a, b;

                for (a = 0; a <= width - 1; a++)    //(int x=width-1 ; x>=0 ; x--)
                {
                    for (b = 0; b <= height - 1; b++) {
                        if (arrayImage[b][a] == 0) {
                            zero = (arrayImage[b][a] + 1) + zero;
                        } else if (arrayImage[b][a] != 0) {
                            calFlag++;
                        }
                    }
                }

                // to checkhighest frequency in a row
                int max = 0;
                int line = 0;
                int checky = 0;
                int pointo = 0;
                for (b = 0; b <= height - 1; b++)    //(int x=width-1 ; x>=0 ; x--)
                {
                    for (a = 0; a <= width - 1; a++) {
                        if (arrayImage[b][a] == 0) {
                            checky = (arrayImage[b][a] + 1) + checky;
                        }
                        if (checky > max) {
                            max = checky;

                            line = b;
                        }
                    }
                    pointo = checky;
                    checky = 0;
                }

                int proFlag = width * height;

                if (calFlag >= proFlag) {
                    break;
                }
                calFlag = 0;
                boolean word = false;
                boolean wordr = false;
                boolean wordx = false;
                boolean find = false;


                //to print out the located huruf (create new full white canvas)
                for (int y = 0; y < height; y++)    //(int x=width-1 ; x>=0 ; x--)
                {
                    for (int x = 0; x < width; x++) {
                        arrayImageSave[y][x] = 1;
                    }
                }
                int ccoordinate = 0;
                int dcoordinate = 0;
                int trackY = 0;
                int trackX = 0;

                boolean pitchy = false;
                for (int y = 0; y < height - 1; y++) {
                    for (int x = 0; x < width - 1; x++) {
                        if (arrayImage[y][x] == 0 && pitchy == false) {
                            ccoordinate = y;
                            dcoordinate = x;
                            trackY = y;
                            trackX = x;

                            pitchy = true;
                            arrayImageSave[y][x] = arrayImage[y][x];        // point first of "0" into save then check their neighbor
                            arrayImage[y][x] = 1;
                        }
                    }
                }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		atas bawah kanan kiri

                for (int x = width - 2; x >= 1; x--) {
                    for (int y = 1; y <= height - 1; y++) {
                        int xs = x + 1;
                        int ys1 = y - 1;
                        int ys2 = y;
                        int ys3 = y + 1;

                        int xr = x - 1;
                        int yr1 = y - 1;
                        int yr2 = y;
                        int yr3 = y + 1;

                        int xx = x;
                        int yx1 = y - 1;
                        int yx2 = y;
                        int yx3 = y + 1;

                        if (arrayImage[yx1][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys1][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr1][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

//--------------------------------------------------------------

                        if (arrayImage[yx2][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys2][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }


                        if (arrayImage[yr2][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

//------------------------------------------------------------------
                        if (arrayImage[yx3][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys3][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr3][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

//-------------------------------------------------------------------

                        if (arrayImage[y][x] == 0 && word == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordr == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordx == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        word = false;
                        wordr = false;
                        wordx = false;
                    }
                }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		bawah  atas kanan kiri
                for (int x = width - 2; x >= 1; x--) {
                    for (int y = height - 2; y >= 1; y--) {

                        int xs = x + 1;
                        int ys1 = y - 1;
                        int ys2 = y;
                        int ys3 = y + 1;

                        int xr = x - 1;
                        int yr1 = y - 1;
                        int yr2 = y;
                        int yr3 = y + 1;

                        int xx = x;
                        int yx1 = y - 1;
                        int yx2 = y;
                        int yx3 = y + 1;

                        if (arrayImage[yx1][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys1][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr1][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //--------------------------------------------------------------

                        if (arrayImage[yx2][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys2][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }


                        if (arrayImage[yr2][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //------------------------------------------------------------------
                        if (arrayImage[yx3][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys3][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr3][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //-------------------------------------------------------------------

                        if (arrayImage[y][x] == 0 && word == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordr == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordx == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }
                        word = false;
                        wordr = false;
                        wordx = false;

                    }
                }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		atas bawah kiri kanan
                for (int x = 1; x <= width - 1; x++) {
                    for (int y = 1; y <= height - 1; y++) {
                        int xs = x + 1;
                        int ys1 = y - 1;
                        int ys2 = y;
                        int ys3 = y + 1;

                        int xr = x - 1;
                        int yr1 = y - 1;
                        int yr2 = y;
                        int yr3 = y + 1;

                        int xx = x;
                        int yx1 = y - 1;
                        int yx2 = y;
                        int yx3 = y + 1;

                        if (arrayImage[yx1][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys1][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr1][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //--------------------------------------------------------------

                        if (arrayImage[yx2][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys2][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }


                        if (arrayImage[yr2][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //------------------------------------------------------------------
                        if (arrayImage[yx3][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys3][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr3][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //-------------------------------------------------------------------

                        if (arrayImage[y][x] == 0 && word == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordr == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordx == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }
                        word = false;
                        wordr = false;
                        wordx = false;
                    }
                }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		bawah atas  kiri kanan

                for (int x = 1; x <= width - 1; x++) {
                    for (int y = height - 2; y <= 1; y--) {
                        int xs = x + 1;
                        int ys1 = y - 1;
                        int ys2 = y;
                        int ys3 = y + 1;

                        int xr = x - 1;
                        int yr1 = y - 1;
                        int yr2 = y;
                        int yr3 = y + 1;

                        int xx = x;
                        int yx1 = y - 1;
                        int yx2 = y;
                        int yx3 = y + 1;

                        if (arrayImage[yx1][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys1][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr1][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //--------------------------------------------------------------

                        if (arrayImage[yx2][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys2][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }


                        if (arrayImage[yr2][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //------------------------------------------------------------------
                        if (arrayImage[yx3][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys3][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr3][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //-------------------------------------------------------------------

                        if (arrayImage[y][x] == 0 && word == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordr == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordx == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }
                        word = false;
                        wordr = false;
                        wordx = false;

                    }
                }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		kiri kanan atas bawah

                for (int y = 1; y <= height - 2; y++) {
                    for (int x = 1; x <= width - 2; x++) {
                        int xs = x + 1;
                        int ys1 = y - 1;
                        int ys2 = y;
                        int ys3 = y + 1;

                        int xr = x - 1;
                        int yr1 = y - 1;
                        int yr2 = y;
                        int yr3 = y + 1;

                        int xx = x;
                        int yx1 = y - 1;
                        int yx2 = y;
                        int yx3 = y + 1;

                        if (arrayImage[yx1][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys1][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr1][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

//--------------------------------------------------------------

                        if (arrayImage[yx2][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys2][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }


                        if (arrayImage[yr2][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

//------------------------------------------------------------------
                        if (arrayImage[yx3][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys3][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr3][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

//-------------------------------------------------------------------

                        if (arrayImage[y][x] == 0 && word == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordr == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordx == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }
                        word = false;
                        wordr = false;
                        wordx = false;

                    }
                }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		kanan kiri  atas bawah

                for (int y = 1; y <= height - 2; y++) {
                    for (int x = width - 2; x >= 1; x--) {
                        int xs = x + 1;
                        int ys1 = y - 1;
                        int ys2 = y;
                        int ys3 = y + 1;

                        int xr = x - 1;
                        int yr1 = y - 1;
                        int yr2 = y;
                        int yr3 = y + 1;

                        int xx = x;
                        int yx1 = y - 1;
                        int yx2 = y;
                        int yx3 = y + 1;

                        if (arrayImage[yx1][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys1][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr1][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //--------------------------------------------------------------

                        if (arrayImage[yx2][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys2][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }


                        if (arrayImage[yr2][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //------------------------------------------------------------------
                        if (arrayImage[yx3][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys3][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr3][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //-------------------------------------------------------------------

                        if (arrayImage[y][x] == 0 && word == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordr == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordx == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        word = false;
                        wordr = false;
                        wordx = false;

                    }

                }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		kiri kanan bawah atas

                for (int y = height - 2; y >= 1; y--) {
                    for (int x = 1; x <= width - 2; x++) {
                        int xs = x + 1;
                        int ys1 = y - 1;
                        int ys2 = y;
                        int ys3 = y + 1;

                        int xr = x - 1;
                        int yr1 = y - 1;
                        int yr2 = y;
                        int yr3 = y + 1;

                        int xx = x;
                        int yx1 = y - 1;
                        int yx2 = y;
                        int yx3 = y + 1;

                        if (arrayImage[yx1][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys1][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr1][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //--------------------------------------------------------------

                        if (arrayImage[yx2][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys2][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }


                        if (arrayImage[yr2][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //------------------------------------------------------------------
                        if (arrayImage[yx3][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys3][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr3][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //-------------------------------------------------------------------

                        if (arrayImage[y][x] == 0 && word == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordr == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordx == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        word = false;
                        wordr = false;
                        wordx = false;

                    }
                }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		kanan kiri  bawah atas

                for (int y = height - 2; y >= 1; y--) {
                    for (int x = width - 2; x >= 1; x--) {

                        int xs = x + 1;
                        int ys1 = y - 1;
                        int ys2 = y;
                        int ys3 = y + 1;

                        int xr = x - 1;
                        int yr1 = y - 1;
                        int yr2 = y;
                        int yr3 = y + 1;

                        int xx = x;
                        int yx1 = y - 1;
                        int yx2 = y;
                        int yx3 = y + 1;

                        if (arrayImage[yx1][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys1][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr1][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //--------------------------------------------------------------

                        if (arrayImage[yx2][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys2][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }


                        if (arrayImage[yr2][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //------------------------------------------------------------------
                        if (arrayImage[yx3][xx] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordx = true;
                            }
                        }

                        if (arrayImage[ys3][xs] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                word = true;
                            }
                        }

                        if (arrayImage[yr3][xr] == 0) {
                            if (arrayImageSave[yx1][xx] == 0 || arrayImageSave[yx2][xx] == 0 || arrayImageSave[yx3][xx] == 0 || arrayImageSave[ys1][xs] == 0 || arrayImageSave[ys2][xs] == 0 || arrayImageSave[ys3][xs] == 0 || arrayImageSave[yr1][xr] == 0 || arrayImageSave[yr2][xr] == 0 || arrayImageSave[yr3][xr] == 0) {

                                wordr = true;
                            }
                        }

                        //-------------------------------------------------------------------

                        if (arrayImage[y][x] == 0 && word == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordr == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        if (arrayImage[y][x] == 0 && wordx == true) {
                            arrayImageSave[y][x] = 0;
                            arrayImage[y][x] = 1;
                        }

                        word = false;
                        wordr = false;
                        wordx = false;

                    }
                }

                print();

            } while (true);
        }
        pointer = 0;
    }

    public void print() throws IOException {

        image = buffImageInput;

        int count = 0;
        int countRow = 0;

        int x = arrayImageSave.length;
        ;
        int y = arrayImageSave[1].length;
        ;

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

                if (arrayImageSave[i][j] == 0) {
                    red = 0;
                    green = 0;
                    blue = 0;
                }
                pixelsR[i][j] = red;
                pixelsG[i][j] = green;
                pixelsB[i][j] = blue;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
            countRow++;
        }
        nameFile = Long.toString(new Date().getTime());

        File output = new File("output/tashih/binary/extract all object/Cut Alphabet/DT_" + nameFile + ".jpg"); // File save Data Test
        output.getParentFile().mkdirs();
        ImageIO.write(image, "jpg", output);
        ouptuts.add(output);
        pointer++;
    }

    public ArrayList<File> publish() {
        return ouptuts;
    }
}

