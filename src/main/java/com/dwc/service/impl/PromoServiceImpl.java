package com.dwc.service.impl;

import com.dwc.dao.PromoDOMapper;
import com.dwc.dataobject.PromoDO;
import com.dwc.service.PromoService;
import com.dwc.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDOMapper promoDOMapper;

    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        PromoDO promoDO = promoDOMapper.selectByItemId(itemId);

        PromoModel promoModel = convertFromDataObjectToModel(promoDO);
        if(promoModel == null){
            return null;
        }

        //判断秒杀活动即将开始或正在进行
        if(promoModel.getStartDate().isAfterNow()){
            promoModel.setStatus(1); //未开始
        }else if(promoModel.getEndDate().isBeforeNow()){
            promoModel.setStatus(3); //已结束
        }else{
            promoModel.setStatus(2); //进行中
        }
        return promoModel;
    }

    private PromoModel convertFromDataObjectToModel(PromoDO promoDO){
        if(promoDO == null){
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO,promoModel);
        promoModel.setPromoItemPrice(new BigDecimal(promoDO.getPromoItemPrice()));
        promoModel.setStartDate(new DateTime(promoDO.getStartDate()));
        promoModel.setEndDate(new DateTime(promoDO.getEndDate()));
        return promoModel;
    }
}
