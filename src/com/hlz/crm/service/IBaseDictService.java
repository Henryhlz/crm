package com.hlz.crm.service;

import com.hlz.crm.domain.BaseDict;

import java.util.List;

/**
 * 字典表业务层接口
 *
 * @author Henryhlz
 */
public interface IBaseDictService {
    /**
     * 查询客户来源列表
     *
     * @return
     */
    List<BaseDict> findAllCustSources();

    /**
     * 查询客户级别列表
     *
     * @return
     */
    List<BaseDict> findAllCustLevels();
}
