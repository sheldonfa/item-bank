package com.mypro.ssm.controller;

import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.rbac.Role;
import com.mypro.ssm.service.RoleService;
import org.apache.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Controller of Role
 * @author fangxin
 * @date 2019-2-25
 */
@Controller
@RequestMapping("/role")
public class RoleController{

	private final Logger log = Logger.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	@ResponseBody
	public Result add(Role role) {
		roleService.insert(role);
		return Result.success();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result update(@PathVariable Long id, Role role) {
		//roleService.update(Role);
		return Result.success();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result del(@PathVariable Long id, Model model) {
		roleService.deleteById(id);
		return Result.success();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result getJson(@PathVariable Long id, Model model){
		roleService.findById(id);
		return Result.success();
	}
}
