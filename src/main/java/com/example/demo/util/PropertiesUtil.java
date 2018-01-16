package com.example.demo.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/16
 * Time：10:49
 * ========================
 */
public class PropertiesUtil {
    private final ResourceBundle resource;
    private String fileName;

    /**
     * 构造函数实例化部分对象,获取资源文件
     * @param fileName
     */
    public PropertiesUtil(String fileName){
        this.fileName = fileName;
        Locale locale = new Locale("zh","CN");//1语言2国家
        this.resource = ResourceBundle.getBundle(this.fileName,locale);
    }

    /**
     * 获得指定字段的值
     * @param key
     * @return
     */
    public String getValue(String key){
        return this.resource.getString(key);
    }
}
