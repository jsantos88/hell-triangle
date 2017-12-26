package com.hell.triangle.model;

import org.junit.Assert;
import org.junit.Test;

import com.hell.triangle.exception.TriangleException;


public class HellTriangleTest {
	private HellTriangle hellTriangle;

	@Test
	public void shouldReturnMaxSumWhenTriangleHasOnlyRoot(){
		hellTriangle = new HellTriangle("[[6]]");
		Assert.assertTrue(6 == hellTriangle.getMaxSum());
	}
	
	@Test
	public void shouldReturnMaxSumWithTwoRows(){
		hellTriangle = new HellTriangle("[[2],[2,9]]");
		Assert.assertTrue(11 == hellTriangle.getMaxSum());
	}
	
	@Test
	public void shouldReturnMaxSumWithThreeRows(){
		hellTriangle = new HellTriangle("[[2],[2,9],[1,2,4]]");
		Assert.assertTrue(15 == hellTriangle.getMaxSum());
	}
	
	@Test
	public void shouldReturnMaxSumWithGivenChallangeInputExample(){
		hellTriangle = new HellTriangle("[[6],[3,5],[9,7,1],[4,6,8,4]]");
		Assert.assertTrue(26 == hellTriangle.getMaxSum());
	}
	
	@Test
	public void shouldReturnMaxSumWhenHigherValuesAreInTheLastNodeOfRow(){
		hellTriangle = new HellTriangle("[[6],[3,5],[2,7,9],[4,6,8,14]]");
		Assert.assertTrue(34 == hellTriangle.getMaxSum());
	}
	
	 @Test(expected = IllegalArgumentException.class)
	 public void shouldValidateWhenTriangleIsNull(){
		 hellTriangle = new HellTriangle(null);
	 }
	 
	 @Test(expected = TriangleException.class)
	 public void shouldValidateEquilateralTriangle(){
		 hellTriangle = new HellTriangle("[[6],[3,5],[2,7],[4,6,8,14]]");
	 }
	 
	 @Test(expected = TriangleException.class)
	 public void shouldValidateEquilateralTriangleUpSideDown(){
		 hellTriangle = new HellTriangle("[[1,2,3],[3,5],[2]]");
	 }
	
	 public void shouldParseStringToMatrix(){
		 int[][] expectedTriangle = {{6},{1,2},{3,4,5}};
		 hellTriangle = new HellTriangle("[[6],[1,2],[3,4,5]]");
		 Assert.assertArrayEquals(expectedTriangle, hellTriangle.getTriangle());
	 }
	
}
