package com.mypro.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.User;
import com.mypro.ssm.po.rbac.Permission;
import com.mypro.ssm.po.rbac.Role;
import com.mypro.ssm.service.PermissionService;
import org.apache.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller of Permission
 * @author fangxin
 * @date 2019-2-25
 */
@Controller
@RequestMapping("permission")
public class PermissionController{

	private final Logger log = Logger.getLogger(PermissionController.class);
	
	@Autowired
	private PermissionService permissionService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String add(Permission permission) {
		permissionService.insert(permission);
		return "redirect:/permission/show_list/1/5";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result update(@PathVariable Long id, Permission permission) {
		//permissionService.update(Permission);
		return Result.success();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result del(@PathVariable Long id, Model model) {
		permissionService.deleteById(id);
		return Result.success();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result getJson(@PathVariable Long id, Model model){
		permissionService.findById(id);
		return Result.success();
	}

	@RequestMapping(value = "show_list/{pageNum}/{pageSize}", method = RequestMethod.GET)
	public String showList(@PathVariable Integer pageNum, @PathVariable Integer pageSize, Model model) {
		PageInfo<Permission> pageInfo = permissionService.page(pageNum, pageSize);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("menuId","permission");
		return "permission-list";
	}

	@RequestMapping("show_add")
	public String showAdd(Model model) {
		return "permission-add";
	}
}
