package com.hlz.crm.service;

import com.hlz.crm.domain.CstLinkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 联系人业务层接口
 *
 * @author Henryhlz
 */
public interface ILinkmanService {

    /**
     * 根据id查询单个
     *
     * @param id
     */
    CstLinkman findById(long id);

    /**
     * 根据id删除
     *
     * @param id
     */
    void delLinkman(long id);

    /**
     * 添加
     *
     * @param linkman
     */
    void addLinkman(CstLinkman linkman);

    /**
     * 更新
     *
     * @param linkman
     */
    void editLinkman(CstLinkman linkman);

    /**
     * 根据离线条件查询
     *
     * @param criteria
     * @return
     */
    List<CstLinkman> findAllLinkman(DetachedCriteria criteria);
}
