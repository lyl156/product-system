package com.example.crud.Config;

import com.example.crud.Filter.XSSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

@Configuration
public class XssFilterConfig {
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean initXssFilterBean = new FilterRegistrationBean();
        initXssFilterBean.setFilter(new XSSFilter());
        //chain of responsibility
        initXssFilterBean.setOrder(1);
        //default enabled
        //initXssFilterBean.setEnabled(true);
        initXssFilterBean.addUrlPatterns("/*");
        initXssFilterBean.setDispatcherTypes(DispatcherType.REQUEST);
        return initXssFilterBean;
    }
}
