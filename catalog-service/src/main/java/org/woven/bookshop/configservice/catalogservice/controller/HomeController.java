package org.woven.bookshop.configservice.catalogservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.woven.bookshop.configservice.catalogservice.config.AppProperties;

@RestController
public class HomeController {
    private final AppProperties appProperties;

    public HomeController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/")
    public String getGreeting() {
        return appProperties.getGreeting();
    }
}
