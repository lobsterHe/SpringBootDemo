package com.example.demo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author helong
 * @date 2019/3/19 8:51
 * @description
 */

@Data
@ApiModel("支付请求")
public class PayReq {

    @NotNull(message = "支付金额不能为空")
    @ApiModelProperty("支付金额")
    private BigDecimal payAmount;
}
