package sec04.exam06;

import java.util.Scanner;

public class CalculatorEx {

	public static void main(String[] args) {
		
		Calculator myCal = new Calculator();
		double result1 = myCal.areaRectangle(10);
		
		double result2 = myCal.areaRectangle(10, 20);
		
		System.out.println("정사각형의 넓이 : " + result1);
		System.out.println("직사각형의 넓이 : " + result2);
	}

}
