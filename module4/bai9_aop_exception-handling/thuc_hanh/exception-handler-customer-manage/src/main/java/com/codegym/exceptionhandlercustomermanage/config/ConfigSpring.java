package com.codegym.exceptionhandlercustomermanage.config;

import com.codegym.exceptionhandlercustomermanage.formatter.ProvinceFormatter;
import com.codegym.exceptionhandlercustomermanage.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigSpring implements WebMvcConfigurer {
    @Autowired
    private ProvinceService provinceService;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new ProvinceFormatter(provinceService));
//        registry.addFormatter(new DateFomatter());
    }
}
