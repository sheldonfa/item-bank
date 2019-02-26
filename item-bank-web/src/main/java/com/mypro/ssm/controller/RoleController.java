package com.mypro.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.rbac.Permission;
import com.mypro.ssm.po.rbac.Role;
import com.mypro.ssm.service.PermissionService;
import com.mypro.ssm.service.RoleService;
import org.apache.log4j.Logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller of Role
 *
 * @author fangxin
 * @date 2019-2-25
 */
@Controller
@RequestMapping("role")
public class RoleController {

    private final Logger log = Logger.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(Role role) {
        roleService.insert(role);
        return "redirect:/role/show_list/1/5";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable Long id, Role role) {
        //roleService.update(Role);
        return Result.success();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result del(@PathVariable Long id, Model model) {
        roleService.deleteById(id);
        return Result.success();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getJson(@PathVariable Long id, Model model) {
        roleService.findById(id);
        return Result.success();
    }

    @RequestMapping(value = "show_list/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public String showList(@PathVariable Integer pageNum, @PathVariable Integer pageSize, Model model) {
        PageInfo<Role> pageInfo = roleService.page(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("menuId", "role");
        return "role-list";
    }

    @RequestMapping("show_add")
    public String showAdd(Model model) {
        return "role-add";
    }

    /**
     * 角色权限分配页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("show_role_permission/{id}")
    public String showUserRole(@PathVariable Long id, Model model) {
        Role role = roleService.findRolePermissions(id);
        List<Permission> permissionList = permissionService.findAll();
        // 遍历选择的角色
        List<Permission> permissions = role.getPermissions();
        for (Permission p : permissionList) {
            for (Permission p2 : permissions) {
                // 如果角色列表中有用户对应的角色，则设置checkbok=1
                if (p.getId().equals(p2.getId())) {
                    p.setChecked(1);
                    break;
                }
            }
        }
        model.addAttribute("role", role);
        model.addAttribute("permissionList", permissionList);
        return "role-permission-add";
    }

    /**
     * 更新角色资源关系
     *
     * @return
     */
    @RequestMapping("updateRolePermission")
    public String showAdd(Long roleId, Long[] ids) {
        roleService.updateRolePermission(roleId, ids);
        return "redirect:/role/show_role_permission/" + roleId;
    }
}
