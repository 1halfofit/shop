package com.bo.serviceImpl;

import com.bo.bean.Cartitem;
import com.bo.mapper.CartitemMapper;
import com.bo.service.CarItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CaritemServiceImpl implements CarItemService {
    @Resource
    private CartitemMapper cartitemMapper;

    @Override
    public boolean addInfo(Cartitem item) {
        int insert = cartitemMapper.insert(item);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Cartitem> getCarItemByCid(Integer cid) {
        return cartitemMapper.selectCartitemByCid(cid);
    }

    @Override
    public boolean BatchDeleteInfo(Integer[] ids) {
        int i = cartitemMapper.BatchDeleteInfo(ids);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCartitemAll(Integer id) {
        boolean b = cartitemMapper.deleteCartitemAll(id);
        if (b) {
            return true;
        } else {
            return false;
        }
    }

}
