package com.javarush.test.level22.lesson18.big01;

public class Field {

    public int width, height;
    public int[][] matrix;

    public Field(int width, int height) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Field(int width, int height, int[][] matrix) {
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }

    public void print(){

        for (int i = 0; i < getHeight(); i++) {

            for (int j = 0; j <getWidth() ; j++) {

            if (matrix[i][j] == 0)
                System.out.print(".");
                else System.out.print("X");
            }
            System.out.println();
        }

    }

    public void removeFullLines(){

    }

    public Integer getValue(int x, int y){
        return null;
    }

    public void setValue(int x, int y, int value){

    }
}
