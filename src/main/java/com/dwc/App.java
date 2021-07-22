package com.dwc;

import com.dwc.dao.UserDOMapper;
import com.dwc.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = {"com.dwc"})
@MapperScan("com.dwc.dao")
public class App {
/*    @Autowired
    private UserDOMapper userDOMapper;
    @RequestMapping("/")
    public String hello(){
        UserDO user = userDOMapper.selectByPrimaryKey(1);
        return user.getName();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("App STARTED!");
    }
}
