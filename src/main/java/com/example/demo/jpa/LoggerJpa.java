package com.example.demo.jpa;

import com.example.demo.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * 处理logger的CRUD
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/22
 * Time：19:56
 * ========================
 */
public interface LoggerJpa extends
        JpaRepository<LoggerEntity,Long>,
        JpaSpecificationExecutor<LoggerEntity>,
        Serializable{
}
