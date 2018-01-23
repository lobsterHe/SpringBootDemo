package com.example.demo.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.entity.LoggerEntity;
import com.example.demo.jpa.LoggerJpa;
import com.example.demo.util.LoggerUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/22
 * Time：20:02
 * ========================
 */
public class LoggerInterceptor implements HandlerInterceptor {
    public static final String SEND_TIME = "send_time";
    public static final String DATA = "param_data";
    /**
     * 进入springMVC的controller之前开始记录日志实体
     * @param httpServletRequest request
     * @param httpServletResponse response
     * @param o 实体类
     * @return  boolean
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //创建日记实体类
        LoggerEntity entity = new LoggerEntity();
        //获得sessionId
        String sessionId = httpServletRequest.getRequestedSessionId();
        //请求地址信息
        String requestURI = httpServletRequest.getRequestURI();
        //请求参数信息(利用fastJson转换参数)
        String params = JSON.toJSONString(httpServletRequest.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        entity.setClientIp(LoggerUtil.getCliectIp(httpServletRequest));
        //设置请求方法
        entity.setMethod(httpServletRequest.getMethod());
        //设置请求类型
        entity.setType(LoggerUtil.getRequestType(httpServletRequest));
        //设置请求参数
        entity.setParamData(params);
        //设置请求地址
        entity.setUri(requestURI);
        //设置sessionId
        entity.setSessionId(sessionId);
        //设置请求开始时间
        httpServletRequest.setAttribute(SEND_TIME, System.currentTimeMillis());
        //设置请求实体到request内,方便afterCompletion调用
        httpServletRequest.setAttribute(DATA, entity);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //请求状态
        int status = httpServletResponse.getStatus();
        //当前时间
        long time = System.currentTimeMillis();
        //上次请求时间
        Long requestTime = Long.valueOf(httpServletRequest.getAttribute(SEND_TIME).toString());
        //获取请求日记的实体
        LoggerEntity entity = (LoggerEntity) httpServletRequest.getAttribute(DATA);
        //设置时间差
        entity.setConsuming(Long.valueOf(time-requestTime).toString());
        //设置错误码
        entity.setStatusCode(status+"");
        //设置返回值
        entity.setReturnData(JSON.toJSONString(httpServletRequest.getAttribute(LoggerUtil.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //通过WebApplicationContextUtils获取loggerDao
        LoggerJpa loggerDao = getDao(LoggerJpa.class,httpServletRequest);
        //将日记写入数据库
        loggerDao.save(entity);
    }

    public <T> T getDao(Class<T> clazz,HttpServletRequest request){
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return applicationContext.getBean(clazz);
    }
}
