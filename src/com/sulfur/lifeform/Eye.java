package com.sulfur.lifeform;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Eye extends Organ{
    private final Body body;
    private final int fps;
    private final int[][] matrix;

    public Eye(Body body, int fps, int matrixX, int matrixY){
        this.body = body;
        this.fps = fps;
        this.matrix = new int[matrixX][matrixY];
        this.start();
    }

    void input(){
        try {
            elaborateImage("./res/img/img_input_test.bmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void elaborateImage(String fileName) throws IOException {
        BufferedImage image = ImageIO.read(new File(fileName));
        int width = image.getWidth();
        int height = image.getHeight();
        if(width > matrix.length){
            width = matrix.length;
        }
        if(height > matrix[0].length){
            height = matrix[0].length;
        }

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                int color = image.getRGB(j, i);
                if (color == Color.BLACK.getRGB()) {
                    matrix[i][j] = 1;
                }else {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    String output() {
        String outputString = "V";
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                outputString += ";" + matrix[i][j];
                //matrix[i][j] = 0;
            }
        }
        return outputString;
    }

    @Override
    public void run() {
        while(body.isAlive()) {
            try {
                sleep(1000/fps);
                input();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
