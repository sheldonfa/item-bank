package com.mypro.ssm.controller;

import com.mypro.exception.BusinessException;
import com.mypro.ssm.common.Result;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.po.Question;
import com.mypro.ssm.query.QuestionQuery;
import com.mypro.ssm.service.CategoryService;
import com.mypro.ssm.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
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
        List<List<Category>> categories = new ArrayList<>();

        Question question = questionService.findById(id);
        Category category = categoryService.findById(question.getCategoryId());
        LinkedList<Category> cs = new LinkedList<>();
        Category parent = category;
        cs.addFirst(parent);
        while (parent.getParentId() != 0) {
            parent = categoryService.findById(parent.getParentId());
            cs.addFirst(parent);
        }
        // 查出兄弟节点，选中自己
        for (int i = 0; i < cs.size(); i++) {
            List<Category> children = categoryService.findChildren(cs.get(i).getParentId());
            for (Category selected : children) {
                if (selected.getId().equals(cs.get(i).getId())) {
                    selected.setSelected(1);
                    break;
                }
            }
            categories.add(children);
        }
        model.addAttribute("categories", categories);
        model.addAttribute("question", question);
        return "question-edit";
    }

    @RequestMapping(value = "listbycategory", method = RequestMethod.GET)
    @ResponseBody
    public Result listybycategory(QuestionQuery query) {
        List<Question> questions = questionService.findByCategoryId(query.getCategoryId(), query.getRecursion());
        return Result.success(questions);
    }

    @RequestMapping(value = "listreviewbycategory", method = RequestMethod.GET)
    @ResponseBody
    public Result listReviewByCategory(QuestionQuery query) {
        List<Question> questions = questionService.findNeedReviews(query.getCategoryId(), true);
        return Result.success(questions);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result add(@RequestBody Question question) {
        questionService.add(question);
        return Result.success();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result edit(@RequestBody Question question) {
        questionService.update(question);
        return Result.success();
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
        List<Category> rootCategories = categoryService.findRoot();
        model.addAttribute("questions", questions);
        model.addAttribute("categories", rootCategories);
        return "question-list";
    }

    @RequestMapping("review_list")
    public String reviewList(Model model) {
        List<Question> reviews = questionService.findNeedReviews();
        List<Category> rootCategories = categoryService.findRoot();
        model.addAttribute("questions", reviews);
        model.addAttribute("categories", rootCategories);
        return "question-list-review";
    }

    /**
     * 记住记不住更新
     *
     * @param id
     * @param data
     * @return
     */
    @RequestMapping("{id}/remember")
    @ResponseBody
    public Result remember(@PathVariable Long id, @RequestBody QuestionQuery data) {
        questionService.remember(id, data.getRememberFlag());
        return Result.success();
    }

    /**
     * 转换分类
     */
    @RequestMapping(value = "updates", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateByIds(@RequestBody QuestionQuery query) {
        try {
            if (query.getIds() != null
                    && query.getIds().size() > 0
                    && query.getCategoryId() != null) {
                questionService.updateByIds(query);
            }
        } catch (BusinessException e) {
            return Result.error(e.getCodeMsg());
        }

        return Result.success();
    }
}
