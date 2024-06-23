package com.example.observer_coin.stream_study;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {

    private Subscription s;
    private int bufferSize=3;

    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("구독자: 구독 정보 잘 받았어");
        this.s=s;
        System.out.println("구독자: 신문 한개씩 매일 매일 줘");
        s.request(bufferSize); // 신문 한개싞 매일 매일 줘! (백프레셔) 소비자가 한번에 처리할 수 있는 개수를 요청
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("구독 데이터 전달: "+ integer);

        bufferSize--;
        if(bufferSize==0) {
            bufferSize = 3;
            System.out.println("하루 지남");
            s.request(bufferSize);
        }
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("구독 중 에러");
    }

    @Override
    public void onComplete() {
        System.out.println("구독 완료");
    }
}
