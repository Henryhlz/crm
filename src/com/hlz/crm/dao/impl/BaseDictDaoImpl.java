package com.hlz.crm.dao.impl;

import com.hlz.crm.dao.IBaseDictDao;
import com.hlz.crm.domain.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典表持久层实现类
 *
 * @author Henryhlz
 */
@Repository
public class BaseDictDaoImpl implements IBaseDictDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 根据类型查找字典表数据
     *
     * @param s
     * @return
     */
    @Override
    public List<BaseDict> findAllDictByTypeCode(String s) {
        return (List<BaseDict>) hibernateTemplate.find("from BaseDict where dictTypeCode = ?", s);
    }
}
