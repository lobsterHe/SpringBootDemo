package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJpa;
import com.example.demo.service.IGetDoServiceImpl;
import com.example.demo.util.FactoryUtil;
import com.example.demo.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

@RequestMapping
@Controller
public class helloWorldController {

    //注入UserJpa
    @Autowired
    private UserJpa userJpa;

    /**
     * 登入失败返回登入页面
     * @return 登入页面
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        IGetDoServiceImpl serviceImpl = FactoryUtil.getServiceImpl(IGetDoServiceImpl.class, "LUCY");
        serviceImpl.getDoCommand();
        return "index";
    }

    /**
     * 登入成功直接到首页
     * @return 首页
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "成功";
    }

    /**
     * 注销方法
     */
    @RequestMapping(value = "/logOut",method = RequestMethod.GET)
    @ResponseBody
    public String logOut(){
        return "成功";
    }

    /**
     * 接受页面回传参数
     */
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    @ResponseBody
    public String submit(UserEntity userEntity, HttpServletRequest request){
        System.out.println("name"+userEntity.getName()+",age"+userEntity.getPwd());
        Boolean flag = true;
        String result = "登入成功";
        UserEntity user = userJpa.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"),userEntity.getName()));
                return null;
            }
        });
        if(user == null){
            result = "用户不存在";
            flag = false;
        }else if(!userEntity.getPwd().equals(user.getPwd())){
            result = "用户密码不存在";
            flag = false;
        }
        if(flag){
            request.getSession().setAttribute("session_user",userEntity);
        }
        JSONObject object = new JSONObject();
        object.put("msg","用户"+user.getName()+"登入");
        request.setAttribute(LoggerUtil.LOGGER_RETURN,object);
        return result;
    }
}
