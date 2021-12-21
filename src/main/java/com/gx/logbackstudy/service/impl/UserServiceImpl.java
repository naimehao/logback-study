package com.gx.logbackstudy.service.impl;

import com.gx.logbackstudy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public void createUser() {
      log.info("进入创建用户SERVICE");
      MDC.remove("REQUEST_ID");
    }
}
