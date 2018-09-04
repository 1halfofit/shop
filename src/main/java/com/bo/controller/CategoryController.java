package com.bo.controller;

import com.bo.bean.Category;
import com.bo.bean.CategoryExample;
import com.bo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CategoryController {
    //加@Resource  注解  不用new 是注入
    @Resource
    private CategoryService categoryService;

    //异步响应所有的商品类别信息
    @RequestMapping("showInfo")
    @ResponseBody
    public List<Category> showInfo() {
        CategoryExample categoryExample = null;
        List<Category> allInfo = categoryService.getAllInfo(categoryExample);
        return allInfo;
    }

}
