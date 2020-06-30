package io.spandiar.reactive.rxjava;

import java.util.Arrays;
import java.util.List;

import io.spandiar.reactive.rxjava.connector.StockPrice;
import io.spandiar.reactive.rxjava.model.StockSymbol;
import rx.Observable;
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
       
       stockPriceFeed.subscribe(System.out::println, System.out::println, () -> System.out.println("DONE"));
       
    }
}
