package com.hlz.crm.dao;

import com.hlz.crm.domain.BaseDict;

import java.util.List;

/**
 * 字典表持久层接口
 *
 * @author Henryhlz
 */
public interface IBaseDictDao {
    /**
     * 根据类型查找字典表数据
     *
     * @param s
     * @return
     */
    List<BaseDict> findAllDictByTypeCode(String s);
}
