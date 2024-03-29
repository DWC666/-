package com.dwc.service;

import com.dwc.error.BusinessException;
import com.dwc.service.model.ItemModel;

import java.util.List;

public interface ItemService {
    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //商品列表
    List<ItemModel> listItem();

    //商品详情
    ItemModel getItemById(Integer id);

    //减库存
    boolean decreaseStock(Integer itemId, Integer amount) throws BusinessException;

    //商品销量增加
    void increaseSales(Integer itemId, Integer amount) throws  BusinessException;
}
