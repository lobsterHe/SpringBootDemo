package com.example.demo.service.serviceImpl;

import com.example.demo.annotation.SupportCodes;
import com.example.demo.service.IGetDoServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/1/11
 * Time：16:35
 * ========================
 */
@SupportCodes({"LUCY","LISA"})
@Service
public class SwimmingServiceImpl implements IGetDoServiceImpl{

    @Override
    public void getDoCommand() {
        System.out.println("you can swimming!");
    }
}
