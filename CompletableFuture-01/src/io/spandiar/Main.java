package io.spandiar;

import java.util.concurrent.CompletableFuture;

public class Main {
	
	public static CompletableFuture<Integer> createFuture(){
		System.out.println("createFuture " + Thread.currentThread());
		return CompletableFuture.supplyAsync(() -> compute());
	}
	
	public static int compute() {
		sleep(1000);
		System.out.println("compute " + Thread.currentThread());
		return 3;
	}
	
	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		CompletableFuture<Integer> future = createFuture();
		future.thenAccept(System.out::println)
				.thenRun(() -> System.out.println("I'm alive " + Thread.currentThread()));
		
		System.out.println("Thread Main " + Thread.currentThread());
		sleep(1000);
	}

}
