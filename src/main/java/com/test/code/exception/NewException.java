package com.test.code.exception;

import com.test.code.util.StatusCode;

public class NewException extends RuntimeException {

    private StatusCode code = StatusCode.ERROR;

    public NewException(){
        super();
    }

    public NewException(String message){
        super(message);
    }

    public NewException (StatusCode code, String message) {
        super(message);
        this.code = code;
    }

    public StatusCode getCode() {
        return code;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }

}