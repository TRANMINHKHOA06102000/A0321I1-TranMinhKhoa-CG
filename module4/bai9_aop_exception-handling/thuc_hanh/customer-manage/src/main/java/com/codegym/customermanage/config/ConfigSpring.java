package com.codegym.customermanage.config;

import com.codegym.customermanage.formatter.ProvinceFormatter;
import com.codegym.customermanage.service.ProvinceService;
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
