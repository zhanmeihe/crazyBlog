package com.test.main;

public class ThreadTest implements Runnable {

	private String skip;
	 int count = 5;
	public ThreadTest(String skip) {
		this.skip = skip;
	}



	@Override
	public void run() {
		 while (count>0) {
			 try {
				thread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private  synchronized void thread() throws InterruptedException{
		
		if (count>0) {
			Thread.sleep(1000);
			System.err.println(skip+(count--));
		}
	}
	
	public static void main(String[] args) {

	Thread t1 = new Thread(new ThreadTest("a"));
	Thread t2 = new Thread(new ThreadTest("b"));
	Thread t3 = new Thread(new ThreadTest("c"));
	t1.start();
	t2.start();
	t3.start();
	}
}
