package com.Rainbow.controller;

import com.Rainbow.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
/**
 * @ClassName: TestController
 * @Author: Rainbow
 * @Description: Todo
 * @Date: 2023/6/10 11:02
 * @Version: 1.0
 */
@Controller("testController")
public class TestController {
    @Autowired
    @Qualifier("testServiceImpl")
    private TestService testService;

}
