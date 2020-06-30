package io.spandiar.reactive.rxjava;

import java.util.Arrays;
import java.util.List;

import io.spandiar.reactive.rxjava.connector.StockPrice;
import io.spandiar.reactive.rxjava.model.StockSymbol;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Hello world!
 *
 */
public class StockBroker 
{
    public static void main( String[] args )
    {
       List<String> stockSymbols = Arrays.asList("SBI","LEYLAND","TATA","WIPRO","MANNAR","CIPLA");
       
       Observable<StockSymbol> stockPriceFeed = StockPrice.getStockPriceFeed(stockSymbols);
       
       //stockPriceFeed.subscribe(System.out::println, System.out::println, () -> System.out.println("DONE"));
       
       stockPriceFeed.subscribe(new Subscriber<StockSymbol>() {

		@Override
		public void onCompleted() {
			
			System.out.println("Thanks...I'm Done");
			
		}

		@Override
		public void onError(Throwable e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onNext(StockSymbol ticker) {
			System.out.println(ticker);
			if(ticker.getSymbol().equalsIgnoreCase("WIPRO") && ticker.getPrice() > 40.0) {
				System.out.println("Sell Wipro - 100 units");
				unsubscribe();
			}
		}
    	   
       });
       
    }
}
