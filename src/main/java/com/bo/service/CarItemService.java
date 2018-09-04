package com.bo.service;

import com.bo.bean.Cartitem;

import java.util.List;

public interface CarItemService {
    boolean addInfo(Cartitem item);

    List<Cartitem> getCarItemByCid(Integer cid);

    // 删除
    boolean BatchDeleteInfo(Integer[] ids);

    //清空购物车
    boolean deleteCartitemAll(Integer id);
}
