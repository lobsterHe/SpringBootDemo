package com.example.demo;

import com.example.demo.enums.MailContentTypeEnum;
import com.example.demo.mail.MailSender;

import java.util.ArrayList;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/16
 * Time：12:13
 * ========================
 */
public class TextMail {
    public static void main(String[] args) throws Exception {
        new MailSender()
                .title("测试springboot发送邮件")
                .content("哆啦咪发说啦喜多")
                .contentType(MailContentTypeEnum.HTML)
                .targets(new ArrayList<String>() {{
                    add("826149872@qq.com");
                }})
                .sender();
    }
}
