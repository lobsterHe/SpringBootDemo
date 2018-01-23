package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 打印日记类
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/22
 * Time：19:20
 * ========================
 */
@Entity
@Table(name="t_loggers")//表名
@Data
public class LoggerEntity implements Serializable {
    @Id//主键
    @GeneratedValue//可以为Auto、IDENTITY、native等，Auto表示可在多个数据库间切换
    @Column(name="hehe_id")//列名
    private Long id;
    //客户端ip
    @Column(name="hehe_client_ip")
    private String clientIp;
    //请求的uri
    @Column(name="hehe_uri")
    private String uri;
    //普通请求,ajax请求
    @Column(name="hehe_type")
    private String type;
    //get/post/delete
    @Column(name="hehe_method")
    private String method;
    //请求的参数
    @Column(name="hehe_param_data")
    private String paramData;
    //session的id
    @Column(name="hehe_session_id")
    private String sessionId;
    //请求的时间
    @Column(name="hehe_time")
    private Timestamp time;
    //返回的时间
    @Column(name="hehe_return_time")
    private String returnTime;
    //返回的数据
    @Column(name="hehe_return_data")
    private String returnData;
    //返回的状态
    @Column(name="hehe_http_status_code")
    private String statusCode;
    //设置时间差
    @Column(name="hehe_time_consuming")
    private String consuming;
}
