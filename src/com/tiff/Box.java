package com.tiff;

public class Box implements Cuboid{
    private int len;
    private int width;
    private int height;
    private int side;
    private int top;
    private int end;

    public Box(int len, int width, int height) {
        this.len = len;
        this.width = width;
        this.height = height;
        side=this.len*this.height;
        top=this.width*this.len;
        end=this.width*this.height;
    }

    private int smallestSideArea () {
        int returnVal = end;
        if (top < returnVal) returnVal =top;
        if (side < returnVal) returnVal= side;
        return returnVal;
    }

    private int smallestSide () {
        int largest = len;
        if (width > len) largest = width;
        if (height > len) largest = height;
        return ((2*len)+(2*width)+(2*height))-(2*largest);
    }

    public int getRibbonLength() {
        return (smallestSide())+(len*width*height);
    }

    public int getWrapperSize () {
        return ((2*top) + (2*end) + (2*side)+ smallestSideArea());
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getCuboid() {
        return (2*len*height+2*width*height+2*width*len);
    }
}
