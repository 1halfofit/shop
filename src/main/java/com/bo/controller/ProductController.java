package com.bo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.bo.bean.Product;
import com.bo.bean.ProductVo;
import com.bo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProductController {
    @Resource
    private ProductService productService;

    //查询商品类别
    @RequestMapping("getProBycId")
    public String getProBycId(ProductVo productVo, ModelMap mm) {
        productVo.setSize(12);
        if(productVo.getPageNum()==null){
            productVo.setPageNum(1);
        }
        PageHelper.startPage(productVo.getPageNum(),productVo.getSize());
        List<Product> hot = productService.getHot(productVo);
        PageInfo<Product> productPageInfo = new PageInfo<>(hot);
        mm.addAttribute("pagesize",productPageInfo);
        mm.addAttribute("list", hot);
        return "product_list";
    }

   //分页
    @RequestMapping("paging")
    public String paging(ModelMap mm,ProductVo productVo){
//        ProductVo productVo = new ProductVo();
//        productVo.setSize(size);
        if ( null == productVo.getPageNum())productVo.setPageNum(1);
        productVo.setSize(9);
        List<Product> newp = productService.getHot(productVo);
        productVo.setIshot(1);
        List<Product> hot = productService.getHot(productVo);
            mm.addAttribute("hotlist", hot);
            mm.addAttribute("newlist", newp);
            return "index";
    }
    //查询商品详情
    @RequestMapping("getProByPId")
    public String getProByPId(String pid, ModelMap mm) {

      Product pro = productService.getProBypid(pid);

        ModelMap pro1 = mm.addAttribute("pro", pro);
        return "product_info";
    }

}
