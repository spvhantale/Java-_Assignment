package com.problem4;

public class Thread2 implements Runnable {
	

	@Override
	public void run() {
		int sum=1;
		for(int i=1;i<=10;i++) {
			sum=sum*i;
		}
		System.out.println("Total product is "+Thread.currentThread().getName()+" "+sum);
	}

}
