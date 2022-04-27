package com.ty.store.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class Product extends BaseEntity{
    private Integer id;//商品id
    private Integer categoryId;//目录id
    private String itemType;//商品类型
    private String title;//商品标题
    private String sellPoint;//商品卖点
    private Long price;//商品价格
    private Integer num;//商品数量
    private String image;//商品图片路径
    private Integer status;//商品状态
    private Integer priority;//显示的优先级
}
