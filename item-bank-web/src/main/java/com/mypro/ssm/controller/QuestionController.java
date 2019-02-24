package com.mypro.ssm.controller;

import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.service.CategoryService;
import com.mypro.ssm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("list_add")
    public String addList(Model model) {
        List<Category> root = categoryService.findRoot();
        model.addAttribute("categories", root);
        return "question-add";
    }

    @RequestMapping("list_edit/{id}")
    public String editList(@PathVariable Long id, Model model) {
        List<Category> root = categoryService.findRoot();
        Question question = questionService.findById(id);
        model.addAttribute("categories", root);
        model.addAttribute("question", question);
        return "question-edit";
    }

    @RequestMapping("add")
    public String add(Question question) {
        questionService.add(question);
        return "redirect:/";
    }

    @RequestMapping("edit")
    public String edit(Question question) {
        questionService.update(question);
        return "redirect:/";
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    public Result del(@PathVariable Long id) {
        questionService.delete(id);
        Result success = Result.success();
        return success;
    }

    @RequestMapping("list")
    public String list(Model model) {
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);
        return "question-list";
    }

    @RequestMapping("review_list")
    public String reviewList(Model model) {
        List<Question> reviews = questionService.findNeedReviews();
        model.addAttribute("questions", reviews);
        return "question-list-review";
    }
}
