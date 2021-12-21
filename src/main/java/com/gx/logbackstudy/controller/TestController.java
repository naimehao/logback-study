package com.gx.logbackstudy.controller;

import cn.hutool.json.JSONObject;
import com.gx.logbackstudy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/logStudy")
public class TestController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    private static final String FLAG = "REQUEST_ID";

    @GetMapping("/logTest")
    @ResponseBody
    public void logTest() {
        logger.debug("This class is : [{}]", TestController.class);
        logger.info("This class is : [{}]", TestController.class);
        logger.warn("This class is : [{}]", TestController.class);
        logger.error("This class is : [{}]", TestController.class);
    }


    @PostMapping("/logTest2")
    public void logTest2(@RequestBody JSONObject jsonObject) {
        logger.info("RequestBody:[{}]", jsonObject);
    }

    @GetMapping("mdcTest")
    public void mdcTest() {
        MDC.put(FLAG, UUID.randomUUID().toString());
        logger.info("MDC FLAG is : [{}]", MDC.get(FLAG));
        userService.createUser();
    }
}
