package com.ead.authuser.configs;

import java.util.List;

import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;

public class ResolverConfig extends WebMvcConfigurationSupport{
    @Override
    public void addArgumentResolvers(@SuppressWarnings("null") List<HandlerMethodArgumentResolver> addArgumentResolvers){
        addArgumentResolvers.add(new SpecificationArgumentResolver());
        addArgumentResolvers.add(new PageableHandlerMethodArgumentResolver());

        super.addArgumentResolvers(addArgumentResolvers);

    }
}