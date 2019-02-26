package com.mypro.ssm.controller;

import com.mypro.ssm.mapper.CategoryMapper;
import com.mypro.ssm.po.Category;
import com.mypro.ssm.service.CategoryService;
import com.mypro.ssm.vo.TreeNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/applicationContext-*"})
public class CategoryControllerTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Before
    public void setUp() {
        categoryMapper.deleteAll();
        // Setup初始化数据
        for (long i = 0; i < 5; i++) {
            Category c1 = new Category();
            c1.setName("目录" + i);
            c1.setParentId(0l);
            categoryService.add(c1);
            for (long j = 0; j < 5; j++) {
                Category c2 = new Category();
                c2.setParentId(c1.getId());
                c2.setName("目录" + i + j);
                categoryService.add(c2);
                for (long k = 0; k < 5; k++) {
                    Category c3 = new Category();
                    c3.setId(c2.getId());
                    c3.setName("目录" + i + j + k);
                    c3.setParentId(c2.getId());
                    categoryService.add(c3);
                }
            }
        }
    }

    @Test
    public void listTree() {
        List<TreeNode> tree = categoryService.tree();
        System.out.println(tree);
    }
}
