package com.example.observer_coin.config;

import com.example.observer_coin.EventNotify;
import com.example.observer_coin.filter.MyFluxFilter;
import com.example.observer_coin.filter.MyFluxFilter2;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFluxFilterConfig {

    @Autowired
    private EventNotify eventNotify;

    @Bean
    public FilterRegistrationBean<Filter> addFilter() {
        System.out.println("필터 등록됨");

        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFluxFilter(eventNotify));
        bean.addUrlPatterns("/sse");

        return bean;
    }

    @Bean
    public FilterRegistrationBean<Filter> addFilter2() {
        System.out.println("필터 등록됨");

        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFluxFilter2(eventNotify));
        bean.addUrlPatterns("/add");

        return bean;
    }
}
