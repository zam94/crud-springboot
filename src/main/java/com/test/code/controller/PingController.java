package com.test.code.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pingTest/*")
public class PingController {

    public PingController(){

    }

    @RequestMapping(value = "/ping",
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getping() {
        String status="TEST PING OKE";
        return new ResponseEntity(status, HttpStatus.OK);
    }

}

