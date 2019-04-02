package com.mypro.ssm.controller;

import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.query.QuestionQuery;
import com.mypro.ssm.service.CategoryService;
import com.mypro.ssm.service.QuestionService;
import com.mypro.ssm.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping("show_list")
    public String showList() {
        return "category-list";
    }

    @RequestMapping("show_details")
    public String showDetails(Long categoryId, Model model) {
        // 查询question列表
        List<Question> questions = questionService.findByCategoryId(categoryId);
        model.addAttribute("questions", questions);
        // 查询root category
        List<Category> categories = categoryService.findRoot();
        model.addAttribute("categories", categories);
        return "category-details";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result add(Category category) {
        categoryService.insertSelective(category);
        return Result.success();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.update(category);
        return Result.success();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result del(@PathVariable Long id) {
        categoryService.deleteById(id);
        return Result.success();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getJson(@PathVariable Long id, Model model) {
        categoryService.findById(id);
        return Result.success();
    }

    @RequestMapping("tree")
    @ResponseBody
    public Result<List<TreeNode>> listTree() {
        List<TreeNode> categoryies = categoryService.tree();
        for (TreeNode t : categoryies) {
            t.setIcon("icon-th");
        }
        return Result.success(categoryies);
    }

    @RequestMapping("root")
    @ResponseBody
    public Result root() {
        List<Category> roots = categoryService.findRoot();
        for (Category c : roots) {
            Long questionCount = questionService.findCountByCategory(c.getId(), true);
            c.setQuestionCount(questionCount);
        }
        return Result.success(roots);
    }

    @RequestMapping("{id}/children")
    @ResponseBody
    public Result children(@PathVariable Long id, QuestionQuery query) {
        List<Category> children = new ArrayList<>();
        if (id != null) {
            // 查询子目录
            children = categoryService.findChildren(id);
            // 查询数量
            for (Category c : children) {
                Long questionCount = questionService.findCountByCategory(c.getId(), true,query.getCountType());
                c.setQuestionCount(questionCount);
            }
        }
        return Result.success(children);
    }
}
