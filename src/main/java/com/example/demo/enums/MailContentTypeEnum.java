package com.example.demo.enums;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/16
 * Time：10:12
 * ========================
 */
public enum MailContentTypeEnum {
    HTML("text/html;charset=UTF-8"),
    TEXT("text");

    private String value;

    MailContentTypeEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
