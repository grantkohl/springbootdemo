package com.demo.service.impl;

import com.demo.dao.PromotionPoolMapper;
import com.demo.domain.PromotionPool;
import com.demo.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    PromotionPoolMapper promotionPoolMapper;

    /**
     * 加这里也能回滚
     * 回滚后，id仍然会自增1
     * exception需特别设定
     */
    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void insert() throws Exception {

        PromotionPool promotionPool = new PromotionPool();
        promotionPool.setSupplierId(120045);
        promotionPool.setSupplierStatus((byte)0);
        promotionPool.setPromotionType(2);

        int id = promotionPoolMapper.insert(promotionPool);
        System.out.println("==========="+id);

//        throw new Exception();
    }
}
