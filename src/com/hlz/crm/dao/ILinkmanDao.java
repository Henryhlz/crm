package com.hlz.crm.dao;

import com.hlz.crm.domain.CstLinkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 联系人持久层接口
 *
 * @author Henryhlz
 */
public interface ILinkmanDao {
    /**
     * 根据离线条件查询
     *
     * @param criteria
     * @return
     */
    List<CstLinkman> findAllLinkman(DetachedCriteria criteria);

    /**
     * 更新
     *
     * @param linkman
     */
    void updateLinkman(CstLinkman linkman);

    /**
     * 添加
     *
     * @param linkman
     */
    void addLinkman(CstLinkman linkman);

    /**
     * 根据id删除
     *
     * @param id
     */
    void delLinkman(long id);

    /**
     * 根据id查询单个
     *
     * @param id
     */
    CstLinkman findById(long id);
}
