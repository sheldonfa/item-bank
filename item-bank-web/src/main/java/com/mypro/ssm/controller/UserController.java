package com.mypro.ssm.controller;

import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.User;
import com.mypro.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller of User
 *
 * @author fangxin
 * @date 2019-2-25
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Result add(User user) {
        userService.insert(user);
        return Result.success();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable Long id, User user) {
        //userService.update(User);
        return Result.success();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result del(@PathVariable Long id, Model model) {
        userService.deleteById(id);
        return Result.success();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getJson(@PathVariable Long id, Model model) {
        userService.findById(id);
        return Result.success();
    }
}
