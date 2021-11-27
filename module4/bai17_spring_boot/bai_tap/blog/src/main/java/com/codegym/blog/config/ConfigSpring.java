package com.codegym.blog.config;

import com.codegym.blog.formatter.CategoryFormatter;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigSpring implements WebMvcConfigurer {
    @Autowired
    private CategoryService categoryService;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new CategoryFormatter(categoryService));
//        registry.addFormatter(new DateFomatter());
    }
}
