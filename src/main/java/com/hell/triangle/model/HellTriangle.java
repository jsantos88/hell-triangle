package com.hell.triangle.model;

import com.hell.triangle.exception.TriangleException;

public class HellTriangle {
	private int[][] triangle;
	

	public HellTriangle(String triangle) {
		this.triangle = parse(triangle);
	}

	public int getMaxSum() {
		
		if(triangle == null) {
			throw new IllegalArgumentException("Triângulo não pode ser nulo");
		}
		
		int maxSum = triangle[0][0];
		int index = 0;
		int triangleLength = triangle.length;
		for (int i = 1; i < triangleLength; i++) {
			validateTriangleRow(i, triangle[i]);
			if(triangle[i][index+1] > triangle[i][index]) {
				index++;
			}
			maxSum += triangle[i][index];
				
		}
		return maxSum;
	}
	
	private void validateTriangleRow(int rowPosition, int[] row) throws TriangleException {
		
		final int rowExpectedLength = rowPosition +1;
		
		if(row.length != rowExpectedLength){
			throw new TriangleException(String.format("Triângulo não equilatero"));
		}
	}
	

	public int[][] parse(String input) {
		
		if(input == null){
			throw new IllegalArgumentException("Triângulo não pode ser nulo");
		}
		
		input = input.substring(2, input.length()-2);
    	String[] triangle = input.split("\\],\\[");
    	int length = triangle.length;
    	String[] rows;
    	int rowsLength;
    	int[][] mat = new int[length][];
    	for (int i = 0; i < length ; i++) {
    	    rows = triangle[i].split(",");
    	    rowsLength = rows.length;
    	    validateTriangleRow(i, rowsLength);
    	    mat[i] = new int[rowsLength];
    	    for (int j = 0; j < rowsLength; j++) {
    	        mat[i][j] = Integer.parseInt(rows[j]);
    	    }
    	}
    	return mat;
	}

	private void validateTriangleRow(int rowPosition, int rowsLength) throws TriangleException {
		
		final int rowExpectedLength = rowPosition +1;
		
		if(rowsLength != rowExpectedLength){
			throw new TriangleException(String.format("Triângulo não equilatero"));
		}
	}
	
	public int[][] getTriangle() {
		return triangle;
	}
	

}
