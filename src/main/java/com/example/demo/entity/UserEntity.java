package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/10
 * Time：9:08
 * ========================
 */
@Entity
@Table(name="t_user")
@Data
public class UserEntity implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="t_id")
    private Long id;

    @Column(name="t_name")
    private String name;

    @Column(name="t_pwd")
    private String pwd;

    @Column(name="t_age")
    private int age;

    @Column(name="t_address")
    private String address;
}
