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
 * Time：16:37
 * ========================
 */
@SupportCodes({"BOB","JACK"})
@Service
public class RunningServiceImpl implements IGetDoServiceImpl {
    @Override
    public void getDoCommand() {
        System.out.println("you can running!");
    }
}
