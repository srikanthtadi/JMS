package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		es.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("running asynchronously");
				
			}
		});
	
		es.shutdown(); // if this line is commented then the program will not shutdown as the executor service keeps on running.
	}

}
