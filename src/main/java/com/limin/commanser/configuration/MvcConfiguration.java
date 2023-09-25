package com.limin.commanser.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Mvc配置
 * dingwen
 * 2021/3/20 1:05
 **/
@Configuration
public class MvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("static/images/**").addResourceLocations("file:E:\\study\\gitee-code\\images\\");
        super.addResourceHandlers(registry);
    }
}
