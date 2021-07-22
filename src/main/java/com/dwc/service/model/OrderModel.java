package com.dwc.service.model;

import java.math.BigDecimal;

public class OrderModel {
    //订单编号
    private String id;

    private Integer userId;

    private Integer itemId;

    //若非空，则表示以秒杀商品方式下单
    private Integer promoId;

    //订单总金额，若promoId非空，则表示秒杀总金额
    private BigDecimal orderPrice;

    //商品单价，若promoId非空，则表示秒杀价格
    private BigDecimal itemPrice;

    //商品数量
    private Integer amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }
}
