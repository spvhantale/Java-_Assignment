package com.problem2;

public class Thread1 extends Thread {
	int product=1;
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			for(int i=1;i<=10;i++) {
				product=product*i;
			}
			this.notify();
			System.out.println("Product of 10 number is "+product);
		}
		
		
	}
}
