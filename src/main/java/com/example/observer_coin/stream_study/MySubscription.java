package com.example.observer_coin.stream_study;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Iterator;

// 구독 정보(1.구독자, 2.어떤 데이터를 구독할지)
public class MySubscription implements Subscription {
    private Subscriber s;
    private Iterator<Integer> it;

    public MySubscription(Subscriber<? super Integer> s, Iterable<Integer> its) {
        this.s=s;
        this.it=its.iterator();
    }

    @Override
    public void request(long n) {
        while(n > 0) {
            if(it.hasNext()) {
                s.onNext(it.next());
            } else {
                s.onComplete();
                break;
            }
            n--;
        }
    }

    @Override
    public void cancel() {

    }
}
