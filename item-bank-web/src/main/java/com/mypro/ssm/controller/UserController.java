package com.mypro.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.User;
import com.mypro.ssm.po.rbac.Role;
import com.mypro.ssm.service.RoleService;
import com.mypro.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller of User
 *
 * @author fangxin
 * @date 2019-2-25
 */
@Controller
@RequestMapping("user")
public class UserController {

    private final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(User user) {
        userService.insert(user);
        return "redirect:/user/show_list/1/5";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable Long id, User user) {
        //userService.update(User);
        return Result.success();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result del(@PathVariable Long id, Model model) {
        userService.deleteById(id);
        return Result.success();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getJson(@PathVariable Long id, Model model) {
        User user = userService.findUserRoles(id);
        model.addAttribute("user", user);
        return "user-detail";
    }

    @RequestMapping("show_list/{pageNum}/{pageSize}")
    public String show_list(@PathVariable Integer pageNum, @PathVariable Integer pageSize, Model model) {
        PageInfo<User> pageInfo = userService.page(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("menuId", "user");
        return "user-list";
    }

    @RequestMapping("show_add")
    public String showAdd(Model model) {
        return "user-add";
    }

    /**
     * 用户角色分配页面回显
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("show_user_role/{id}")
    public String showUserRole(@PathVariable Long id, Model model) {
        User user = userService.findUserRoles(id);
        List<Role> roleList = roleService.findAll();
        // 遍历选择的角色
        List<Role> userRoleList = user.getRoles();
        for (Role role : roleList) {
            for (Role ur : userRoleList) {
                // 如果角色列表中有用户对应的角色，则设置checkbok=1
                if (role.getId().equals(ur.getId())) {
                    role.setChecked(1);
                    break;
                }
            }
        }
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "user-role-add";
    }

    /**
     * 更新用户角色关系
     *
     * @return
     */
    @RequestMapping("updateUserRole")
    public String showAdd(Long userId, Long[] ids) {
        userService.updateUserRole(userId, ids);
        return "redirect:/user/show_user_role/" + userId;
    }
}
