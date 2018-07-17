package com.test.code.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseDTO implements Serializable {

    private Integer id;

    private String randomId;

}
