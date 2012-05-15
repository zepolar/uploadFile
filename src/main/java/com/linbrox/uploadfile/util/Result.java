/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linbrox.uploadfile.util;

import java.io.Serializable;

/**
 *
 * @author zepolar
 */

public class Result implements Serializable{

    private Boolean state;
    private String message;
    private String value;
    
    public Result(){
        this.state=Boolean.FALSE;
        this.message="";
        this.value="";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }   
    
    
}
