package io.spandiar.reactive.hotandcoldstarts.server;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class IntegerBank {

	public static Observable<Integer> getNextInteger() {

		return Observable.create(new OnSubscribe<Integer>() {

			public void call(Subscriber<? super Integer> nextInt) {
				returnInteger(nextInt);
			}

		});

	}

	private static void returnInteger(Subscriber<? super Integer> nextInt) {

		int count = 0;

		while (!nextInt.isUnsubscribed()) {
			nextInt.onNext(count++);
		}
		nextInt.onCompleted();
	}

}
