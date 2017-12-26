package com.hell.triangle;

import com.hell.triangle.model.HellTriangle;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ) {	
        HellTriangle hellTriangle = new HellTriangle(args[0]);
        System.out.println(hellTriangle.getMaxSum());
    }
}
