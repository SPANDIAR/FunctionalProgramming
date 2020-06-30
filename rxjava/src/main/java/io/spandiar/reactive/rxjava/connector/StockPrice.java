package io.spandiar.reactive.rxjava.connector;

import java.util.List;
import java.util.Random;

import io.spandiar.reactive.rxjava.model.StockSymbol;
import rx.Observable;
import rx.Subscriber;

public class StockPrice {
	
	public static Observable<StockSymbol> getStockPriceFeed(List<String> symbols){
		
		return Observable.create(subscriber -> processRequest(subscriber, symbols));
	}

	private static void processRequest(Subscriber<? super StockSymbol> subscriber, List<String> symbols) {
		
		int counter=0;
		
		System.out.println("inside processRequest...processing");
		
//		while(true) {
//			for(String symbol: symbols) {
//				subscriber.onNext(getStockPrice(symbol));
//			}
//		}
		
		while(!subscriber.isUnsubscribed()) {
			symbols.stream()
					.map(StockPrice::getStockPrice)
					.filter(data -> !subscriber.isUnsubscribed())
					.forEach(subscriber::onNext);
		}
		subscriber.onCompleted();
	}
	
	private static StockSymbol getStockPrice(String symbol){
		return new StockSymbol(symbol, (new Random().nextInt(100) + new Random().nextFloat()));
	}

}
