/**
 * ------------------------------------------------------------
 * Copyright (c) PUMA SE
 * This software is the proprietary information of PUMA SE
 * All Right Reserved.
 * ------------------------------------------------------------
 */
package com.github.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class IssuesController {

    public static final String GITHUB =
            "https://api.github.com/repos/lukasz-bacic/Hello-World/issues";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "/issues")
    public List<Issues> getRepository(){
        ResponseEntity<Issues[]> forEntity =
                restTemplate.getForEntity(GITHUB, Issues[].class);

        Issues[] body = forEntity.getBody();
        List<Issues> issues = Arrays.asList(body);
        return issues;
    }
}