package com.bo.serviceImpl;

import com.bo.bean.Category;
import com.bo.bean.CategoryExample;
import com.bo.mapper.CategoryMapper;
import com.bo.service.CategoryService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

//加@Service   代表服务层
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllInfo(CategoryExample ex) {
        //去数据库中查询符合条件
        return categoryMapper.selectByExample(ex);
    }
}
