package com.plc;

import com.plc.filter.AccessFilter;
import com.plc.filter.CrossDomainFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfigurationFilter {

	@Bean
	public FilterRegistrationBean accessFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new AccessFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("accessFilter");
		registration.setOrder(2);
		return registration;
	}

    @Bean
    public FilterRegistrationBean crossDomainFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CrossDomainFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("crossDomainFilter");
        registration.setOrder(1);
        return registration;
    }

}
