package com.mypro.ssm.controller;

import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.rbac.UserRole;
import com.mypro.ssm.service.UserRoleService;
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
 * Controller of UserRole
 * @author fangxin
 * @date 2019-2-25
 */
@Controller
@RequestMapping("/userRole")
public class UserRoleController{

	private final Logger log = Logger.getLogger(UserRoleController.class);
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	@ResponseBody
	public Result add(UserRole userRole) {
		userRoleService.insert(userRole);
		return Result.success();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result update(@PathVariable Long id, UserRole userRole) {
		//userRoleService.update(UserRole);
		return Result.success();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result del(@PathVariable Long id, Model model) {
		userRoleService.deleteById(id);
		return Result.success();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result getJson(@PathVariable Long id, Model model){
		userRoleService.findById(id);
		return Result.success();
	}
}
