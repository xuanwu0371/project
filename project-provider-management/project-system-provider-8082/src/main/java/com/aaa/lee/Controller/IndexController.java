package com.aaa.lee.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toIndex")
    public String getIndex() {
        return "index";
    }


    @GetMapping("/user")
    public String toUser() {
        return "user";
    }
}
