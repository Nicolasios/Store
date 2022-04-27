package com.ty.store.mapper;

import com.ty.store.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    /**
     * 查询热销商品的名称
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /**
     * 根据id查找物品
     * @param id 商品id
     * @return 匹配到的商品，如果没有匹配到则返回null
     */
    Product findById(Integer id);
}
