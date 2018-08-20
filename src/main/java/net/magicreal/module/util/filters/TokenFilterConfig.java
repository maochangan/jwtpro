package net.magicreal.module.util.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: maochangan
 * @date: 2018/7/24 10:24
 * @description:
 */
@Configuration
public class TokenFilterConfig {

    @Bean
    public FilterRegistrationBean<TokenAuthorFilter> filterRegistrationBean() {
        FilterRegistrationBean<TokenAuthorFilter> filterRegistrationBean = new FilterRegistrationBean<TokenAuthorFilter>();
        TokenAuthorFilter tokenAuthorFilter = new TokenAuthorFilter();
        filterRegistrationBean.setFilter(tokenAuthorFilter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        return filterRegistrationBean;
    }

}
