package com.hlz.crm.service.impl;

import com.hlz.crm.dao.IBaseDictDao;
import com.hlz.crm.domain.BaseDict;
import com.hlz.crm.service.IBaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典表业务层实现类
 *
 * @author Henryhlz
 */
@Service
public class BaseDictServiceImpl implements IBaseDictService {

    @Autowired
    private IBaseDictDao baseDictDao;

    /**
     * 查询客户来源列表
     *
     * @return
     */
    @Override
    public List<BaseDict> findAllCustSources() {
        return baseDictDao.findAllDictByTypeCode("002");
    }

    /**
     * 查询客户级别列表
     *
     * @return
     */
    @Override
    public List<BaseDict> findAllCustLevels() {
        return baseDictDao.findAllDictByTypeCode("006");
    }
}
