package com.example.observer_coin.filter;


import com.example.observer_coin.EventNotify;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFluxFilter extends OncePerRequestFilter {

    private EventNotify eventNotify;
    public MyFluxFilter(EventNotify eventNotify) {
        this.eventNotify = eventNotify;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("필터 실행됨");


        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setContentType("text/plain; charset=utf-8");
        servletResponse.setContentType("text/event-stream; charset=utf-8"); //

        PrintWriter out = servletResponse.getWriter();
        // 1. Reactive Steams 라이브러리를 쓰면 표준을 지켜서 응답을 할 수 있다.
        for(int i =0; i < 5 ; i++) {
            out.print("응답 " + i + "\n");
            out.flush(); // 버퍼를 비우다.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        // 2. SSE Emitter 라이브러리를 사용하면 편하게 쓸 수 있다.
        while (true) {
            try {
                if(eventNotify.getChange()) {
                    int idx = eventNotify.getEvents().size() - 1;
                    out.print("응답 " + eventNotify.getEvents().get(idx) + "\n");
                    out.flush(); // 버퍼를 비우다.
                    eventNotify.setChange(false);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 3. WebFlux -> Reactive Streams 가 적용된 Stream (비동기 단일쓰레드 동작)
        // 4. Servlet MVC -> Reactive Streams 가 적용된 Stream (멀티 쓰레드 동작)
    }
}
