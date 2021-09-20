package com.tiff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //test box
        Box testBox = new Box(2,3,4);
        System.out.println(testBox.getWrapperSize());
        System.out.println(testBox.getRibbonLength());
        testBox = new Box(1,1,10);
        System.out.println(testBox.getWrapperSize());
        System.out.println(testBox.getRibbonLength());

        List<Box> boxList= new ArrayList<>();
        Stream<String> lines = null;
        try {
            lines = Files.lines(Path.of("resources/data.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> boxes = lines.collect(Collectors.toList());
        for (String box: boxes) {
            String[] dims= box.split("x");
            boxList.add(new Box(Integer.decode(dims[0]),Integer.decode(dims[1]),Integer.decode(dims[2])));
        }

        Integer paper = boxList.stream()
                .map(x -> x.getWrapperSize())
                .reduce(0, Integer::sum);

        System.out.println(paper);


        Integer ribbon= boxList.stream().map(x->x.getRibbonLength()).reduce(0, Integer::sum);
        System.out.println(ribbon);
    }
}
