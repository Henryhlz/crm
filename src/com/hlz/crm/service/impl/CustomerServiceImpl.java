package com.hlz.crm.service.impl;

import com.hlz.crm.service.ICustomerService;
import com.hlz.crm.dao.ICustomerDao;
import com.hlz.crm.domain.CstCustomer;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户业务层接口的实现类
 * @author Henryhlz
 */
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Resource(name = "customerDao")
    private ICustomerDao customerDao;


    /**
     * 保存客户
     */
    @Override
    public void saveCustomer(CstCustomer customer) {
        customerDao.saveCustomer(customer);
    }

    /**
     * 投影查询所有客户
     */
    @Override
    public List<CstCustomer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }

    /**
     * 根据ID查询单个客户
     *
     * @param custId
     * @return
     */
    @Override
    public CstCustomer findById(long custId) {
        return customerDao.findById(custId);
    }

    /**
     * 删除客户
     *
     * @param custId
     */
    @Override
    public void removeCustomer(long custId) {
        customerDao.delCustomer(custId);
    }

    /**
     * 编辑客户
     *
     * @param customer
     */
    @Override
    public void editCustomer(CstCustomer customer) {
        customerDao.updateCustomer(customer);
    }

    /**
     * 根据离线条件查询客户
     *
     * @param criteria
     * @return
     */
    @Override
    public List<CstCustomer> findAllCustomer(DetachedCriteria criteria) {
        return customerDao.findAllCustomer(criteria);
    }
}
