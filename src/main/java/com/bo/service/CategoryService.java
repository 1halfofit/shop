package com.bo.service;

import com.bo.bean.Category;
import com.bo.bean.CategoryExample;

import java.util.List;

public interface CategoryService {
    //查询所有的商品类别
    List<Category> getAllInfo(CategoryExample ex);

}



