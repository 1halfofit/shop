package com.bo.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.bo.bean.Product;
import com.bo.bean.ProductVo;
import com.bo.service.ProductService;
import com.bo.util.UUIDutil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AdminProductController {
    @Resource
    private ProductService productService;

    //查询商品信息 ，以json的格式响应给前端
    @ResponseBody
    @RequestMapping("showProInfo")
    public Map<String, Object> showProInfo(int page, int rows, ProductVo vo) {
        PageHelper.startPage(page, rows);
        List<Product> all1 = productService.getAll();
        PageInfo<Product> info = new PageInfo<>(all1);
        if (all1 != null && all1.size() > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("rows", all1);
            map.put("total", info.getTotal());
            return map;
        } else {
            return null;
        }
    }

    //更新
    @RequestMapping("updateProInfo")
    @ResponseBody
    public String updateProInfo(Product product) {
        //根据id更新数据
        boolean flag = productService.updateByPid(product);
        if (flag) {
            return "true";
        } else {
            return "false";

        }
    }

    //添加商品
    @RequestMapping("adminAddProduct")
    public String adminAddProduct(ProductVo vo, MultipartFile uploadimg, HttpServletRequest request) {
        /**
         * 中间表数据添加
         * 商品表数据保存
         * 文件上传（图片传入到项目中：项目必须要刷新）
         * 上传到本地磁盘， 直接使用不需要刷新
         */
        //上传图片
        String pimage = null;
        if (uploadimg.getSize() > 0) {
            //获取上传文件的名字
            String filename = uploadimg.getOriginalFilename();
            //存放文件的位置（图片存放的位置）  本地存放
//            String path = request.getServletContext().getRealPath("/");
//            pimage = "products/1/"+fileName;  // 这是往服务器存放文件
            String path = "D:\\jide\\ideaworkspace\\shop\\shop\\src\\main\\webapp\\products\\1";
            File file = new File(path + filename);
            try {
                //上传文件到指定位置
                uploadimg.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            vo.setPid(UUIDutil.getuuid());
            vo.setPimage(pimage);
            vo.setPdate(new java.util.Date());
            vo.setPflag(7);
            vo.setWeight(3.4);
            vo.setFloated(0.2);

        }
        //保存商品
        boolean addPro = productService.addPro(vo);
        if (addPro) {
            return "admin/main";
        }
        return null;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
