package com.hlz.crm.dao.impl;

import com.hlz.crm.dao.ILinkmanDao;
import com.hlz.crm.domain.CstLinkman;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Henryhlz
 */
@Repository
public class ILinkmanDaoImpl implements ILinkmanDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 根据离线条件查询
     *
     * @param criteria
     * @return
     */
    @Override
    public List<CstLinkman> findAllLinkman(DetachedCriteria criteria) {
        return (List<CstLinkman>) hibernateTemplate.findByCriteria(criteria);
    }

    /**
     * 更新
     *
     * @param linkman
     */
    @Override
    public void updateLinkman(CstLinkman linkman) {
        hibernateTemplate.update(linkman);
    }

    /**
     * 添加
     *
     * @param linkman
     */
    @Override
    public void addLinkman(CstLinkman linkman) {
        hibernateTemplate.save(linkman);
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @Override
    public void delLinkman(long id) {
        hibernateTemplate.delete(findById(id));
    }

    /**
     * 根据id查询单个
     *
     * @param id
     */
    @Override
    public CstLinkman findById(long id) {
        return hibernateTemplate.load(CstLinkman.class, id);
    }
}
