package com.hlz.crm.service;

import com.hlz.crm.domain.CstCustomer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * 客户业务层接口
 * @author Henryhlz
 */
public interface ICustomerService {
    /**
     * 保存客户
     */
    void saveCustomer(CstCustomer customer);

    /**
     * 投影查询所有客户
     */
    List<CstCustomer> findAllCustomer();

    /**
     * 根据ID查询单个客户
     *
     * @param custId
     * @return
     */
    CstCustomer findById(long custId);

    /**
     * 删除客户
     *
     * @param custId
     */
    void removeCustomer(long custId);

    /**
     * 编辑客户
     *
     * @param customer
     */
    void editCustomer(CstCustomer customer);

    /**
     * 根据离线条件查询客户
     *
     * @param criteria
     * @return
     */
    List<CstCustomer> findAllCustomer(DetachedCriteria criteria);
}
