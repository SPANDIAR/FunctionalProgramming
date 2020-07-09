package io.spandiar.reactive.hotandcoldstarts;

import io.spandiar.reactive.hotandcoldstarts.server.IntegerBank;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	Observable<Integer> nextInteger = IntegerBank.getNextInteger().share();
    	Observable<Integer> nextIntegerNewThread = nextInteger.subscribeOn(Schedulers.io());
    	
    	Runnable
    	
    	nextInteger.subscribe(new Subscriber<Integer>() {

			@Override
			public void onCompleted() {
				
				System.out.println("Hey...Im Done at 500");
				
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Check this error: " + e.getLocalizedMessage());
				
			}

			@Override
			public void onNext(Integer t) {
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + " " + t);
				if(t == 500) {
					this.unsubscribe();
				}
				
			}
    		
    	});
    	
    	//Thread.sleep(50);
    	
    	nextIntegerNewThread.subscribe(new Subscriber<Integer>() {

			@Override
			public void onCompleted() {
				
				System.out.println("Hi...Im Done at 1000");
				
			}

			@Override
			public void onError(Throwable e) {
				System.out.println("Check this error: " + e.getLocalizedMessage());
				
			}

			@Override
			public void onNext(Integer t) {
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
				System.out.println(Thread.currentThread().getName() + " " + t);
				if(t == 1000) {
					this.unsubscribe();
				}
				
			}
    		
    	});
    	Thread.sleep(5000);
    }
}
