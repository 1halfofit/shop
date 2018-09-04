package com.bo.serviceImpl;

import com.bo.bean.Product;
import com.bo.bean.ProductExample;
import com.bo.bean.ProductVo;
import com.bo.mapper.ProductMapper;
import com.bo.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> getHot(ProductVo productVo) {
        return productMapper.selectByProductVo(productVo);
    }

    @Override
    public List<Product> getNew(ProductVo productVo) {
        return productMapper.selectByNewProduct(productVo);
    }

    @Override
    public Product getProBypid(String id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> getAll() {
        return productMapper.selectByExample(null);
    }

    @Override
    public boolean updateByPid(Product product) {
        int count = productMapper.updateByPrimaryKeySelective(product);
        if(count>0){
            return  true;
        }
        return false;
    }

    @Override
    public boolean addPro(ProductVo productVo) {
        //商品表中加一条数据
        productMapper.insert(productVo);
        //关系表中加一条数据
        int save = productMapper.save(productVo);
        if(save>0){
            return true;
        }else{
        return false;
        }
    }


}
