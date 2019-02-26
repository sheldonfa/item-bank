package com.mypro.ssm.controller;

import com.mypro.ssm.BusinessException;
import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.service.CategoryService;
import com.mypro.ssm.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.tree.Tree;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("show_list")
    public String editList() {
        return "category-list";
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    public Result del(@PathVariable Long id) {
        try {
            categoryService.del(id);
        } catch (BusinessException e) {
            return Result.error(e.getCodeMsg());
        }
        return Result.success();
    }

    @RequestMapping("tree")
    @ResponseBody
    public Result<List<TreeNode>> listTree() {
        List<TreeNode> categoryies = categoryService.tree();
        return Result.success(categoryies);
    }
}
