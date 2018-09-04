package com.bo.mapper;

import com.bo.bean.Cart;
import com.bo.bean.CartItrmVo;
import com.bo.bean.Cartitem;
import com.bo.bean.CartitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartitemMapper {
    long countByExample(CartitemExample example);

    int deleteByExample(CartitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cartitem record);

    int insertSelective(Cartitem record);
    //根据车的id 获取车的详情
    List<Cartitem> selectCartitemByCid(Integer cid);
    //删除
    int BatchDeleteInfo(Integer[] ids);
    //清空购物车
    boolean deleteCartitemAll(Integer id);
    //当购物车中商品，生成订单，需要清空购物车
    int dleteInfoByPidAndCid(CartItrmVo vo);



    List<Cartitem> selectByExample(CartitemExample example);

    Cartitem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cartitem record, @Param("example") CartitemExample example);

    int updateByExample(@Param("record") Cartitem record, @Param("example") CartitemExample example);

    int updateByPrimaryKeySelective(Cartitem record);

    int updateByPrimaryKey(Cartitem record);
}