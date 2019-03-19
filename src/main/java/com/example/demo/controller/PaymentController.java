package com.example.demo.controller;

import com.example.demo.req.PayReq;
import com.example.demo.rsp.PayRsp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author helong
 * @date 2019/3/19 8:57
 * @description
 */

@RequestMapping("/demo/pay")
@RestController
public class PaymentController {

    /**
     * 农业银行支付
     * @return 首页
     */
    @RequestMapping(value = "/abc",method = RequestMethod.POST)
    @ResponseBody
    public PayRsp index(PayReq req){
        return null;
    }

}
