package com.bo.service;

import com.bo.bean.Product;
import com.bo.bean.ProductVo;

import java.util.List;

public interface ProductService {

    List<Product> getHot(ProductVo productVo);

    List<Product> getNew(ProductVo productVo);

    //根据主键获取单一商品信息
    Product getProBypid(String id);

    List<Product> getAll();

    //根据id 更新
    boolean updateByPid(Product product);

    //保存商品
    boolean addPro(ProductVo productVo);
}


