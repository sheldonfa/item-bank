package com.mypro.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.ssm.po.User;
import com.mypro.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list/{pageNum}/{pageSize}")
    public String pageList(@PathVariable Integer pageNum, @PathVariable Integer pageSize, Model model) {
        pageNum = 1;
        pageSize = 10;
        PageInfo<User> all = userService.findAll(pageNum, pageSize);
        model.addAttribute("users", all);
        return "user-list";
    }

}
