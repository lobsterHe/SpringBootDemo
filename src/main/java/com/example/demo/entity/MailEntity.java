package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/16
 * Time：9:40
 * ========================
 */
@Data
public class MailEntity implements Serializable {
    //填写SMTP服务器
    private String smtpService;
    //设置端口号
    private String smtpPort;
    //设置发送邮箱
    private String formAddressMail;
    //发送邮箱的SMTP口令
    private String smtpPassword;
    //邮件标题
    private String title;
    //邮件内容
    private String content;
    //内容格式(默认采用html)
    private String contentType;
    //接收邮件地址集合
    private List<String> list = new ArrayList<>();
}
