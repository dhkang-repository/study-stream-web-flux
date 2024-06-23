package com.example.observer_coin.filter;


import com.example.observer_coin.EventNotify;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFluxFilter2 extends OncePerRequestFilter {

    private EventNotify eventNotify;

    public MyFluxFilter2(EventNotify eventNotify) {
        this.eventNotify = eventNotify;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("필터2 실행됨");

        // 데이터를 하나 발생시켜서 Push Event 발생
        eventNotify.add("새로운 데이터");

    }
}
