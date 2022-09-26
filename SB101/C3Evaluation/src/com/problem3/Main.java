package com.problem3;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number 1");
		int num1=sc.nextInt();
		System.out.println("Enter the number 2");
		int num2=sc.nextInt();
		System.out.println("Enter the number 3");
		int num3=sc.nextInt();
		System.out.println("Enter the number 4");
		int num4=sc.nextInt();
		System.out.println("Enter the number 5");
		int num5=sc.nextInt();
		System.out.println("Enter the number 6");
		int num6=sc.nextInt();
		ProductCal[] pc= {
				new ProductCal(num1),
				new ProductCal(num2),
				new ProductCal(num3),
				new ProductCal(num4),
				new ProductCal(num5),
				new ProductCal(num6)
				
		};
		
		ExecutorService ec=Executors.newFixedThreadPool(3);
		for(ProductCal i:pc) {
			Future f=ec.submit(i);

//		
		try {
			System.out.println("The product is "+f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
		ec.shutdown();
	}

}
