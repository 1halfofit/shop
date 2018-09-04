package com.bo.mapper;

import com.bo.bean.Product;
import com.bo.bean.ProductExample;
import java.util.List;

import com.bo.bean.ProductVo;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    List<Product> selectByProductVo(ProductVo productvo);

    List<Product> selectByNewProduct(ProductVo productvo);

    Product selectByPrimaryKey(String pid);

    //保存数据
    int save(ProductVo vo);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}