package com.example.demo.rsp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author helong
 * @date 2019/3/19 8:54
 * @description
 */

@Data
@ApiModel("支付响应")
public class PayRsp {

    @ApiModelProperty("订单ID")
    private String orderId;

}
