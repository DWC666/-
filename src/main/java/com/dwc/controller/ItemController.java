package com.dwc.controller;

import com.dwc.controller.viewobject.ItemVO;
import com.dwc.error.BusinessException;
import com.dwc.response.CommonReturnType;
import com.dwc.service.ItemService;
import com.dwc.service.model.ItemModel;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/item")
@Controller
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*") //解决跨域请求问题
public class ItemController extends BaseController {
    @Autowired
    private ItemService itemService;

    @ResponseBody
    @PostMapping(value = "/create", consumes = {CONTENT_TYPE_FORMED})
    public CommonReturnType createItem(@RequestParam(name = "title")String title,
                                       @RequestParam(name = "description")String description,
                                       @RequestParam(name = "price") BigDecimal price,
                                       @RequestParam(name = "stock")Integer stock,
                                       @RequestParam(name = "imgUrl")String imgUrl) throws BusinessException {
        //封装service请求用来创建商品
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setDescription(description);
        itemModel.setPrice(price);
        itemModel.setStock(stock);
        itemModel.setImgUrl(imgUrl);

        ItemModel itemModelForReturn = itemService.createItem(itemModel);
        ItemVO itemVO = convertFromModelToVO(itemModelForReturn);
        return CommonReturnType.create(itemVO);
    }

    @ResponseBody
    @GetMapping(value = "/get")
    public CommonReturnType getItem(@RequestParam("id") Integer id){
        ItemModel itemModel = itemService.getItemById(id);
        ItemVO itemVO = convertFromModelToVO(itemModel);
        return CommonReturnType.create(itemVO);
    }

    @ResponseBody
    @GetMapping(value = "/list")
    public CommonReturnType listItem(){
        List<ItemModel> itemModelList = itemService.listItem();
        List<ItemVO> itemVOS = itemModelList.stream().map(itemModel -> {
            ItemVO itemVO = convertFromModelToVO(itemModel);
            return itemVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(itemVOS);
    }

    private ItemVO convertFromModelToVO(ItemModel itemModel){
        if(itemModel == null){
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel,itemVO);
        if(itemModel.getPromoModel() != null){
            //有正在进行或即将进行的秒杀活动
            itemVO.setPromoStatus(itemModel.getPromoModel().getStatus());
            itemVO.setPromoId(itemModel.getPromoModel().getId());
            itemVO.setStartDate(itemModel.getPromoModel().getStartDate().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
            itemVO.setPromoPrice(itemModel.getPromoModel().getPromoItemPrice());
        }else{
            itemVO.setPromoStatus(0);
        }
        return itemVO;
    }
}
