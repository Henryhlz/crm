package com.hlz.crm.service.impl;

import com.hlz.crm.dao.ILinkmanDao;
import com.hlz.crm.domain.CstLinkman;
import com.hlz.crm.service.ILinkmanService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 联系人业务层实现类
 *
 * @author Henryhlz
 */
@Service
public class ILinkmanServiceImpl implements ILinkmanService {

    @Autowired
    private ILinkmanDao linkmanDao;

    /**
     * 根据id查询单个
     *
     * @param id
     */
    @Override
    public CstLinkman findById(long id) {
        return linkmanDao.findById(id);
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @Override
    public void delLinkman(long id) {
        linkmanDao.delLinkman(id);
    }

    /**
     * 添加
     *
     * @param linkman
     */
    @Override
    public void addLinkman(CstLinkman linkman) {
        linkmanDao.addLinkman(linkman);
    }

    /**
     * 更新
     *
     * @param linkman
     */
    @Override
    public void editLinkman(CstLinkman linkman) {
        linkmanDao.updateLinkman(linkman);
    }

    /**
     * 根据离线条件查询
     *
     * @param criteria
     * @return
     */
    @Override
    public List<CstLinkman> findAllLinkman(DetachedCriteria criteria) {
        return linkmanDao.findAllLinkman(criteria);
    }
}
