package com.example.observer_coin.stream_study;

// WebFlux = 단일스레드,비동기 + Stream 을 통해 백프레셔가 적용된 데이터만큼 간헐정 응답이 가능하다. ++ 데이터 소비가 끝나면 응답이 종료
// SSE 적용하면, (Servlet, WebFlux) = 데이터 소비가 끝나도 Stream 계속 유지
public class App {
    public static void main(String[] args) {
        MyPub pub = new MyPub(); // 신문사 생성
        MySub sub = new MySub(); // 구독자 생성

        pub.subscribe(sub);
    }
}
