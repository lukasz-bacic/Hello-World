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

@RestController
public class RepositoryController {

    public static final String GITHUB = "https://api.github.com/repos/lukasz-bacic/Hello-World";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "/repository")
    public Repository getRepository(){

        ResponseEntity<Repository> forEntity = restTemplate.getForEntity(GITHUB, Repository.class);

        Repository body = forEntity.getBody();
        return body;
    }
}