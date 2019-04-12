package com.hlz.crm.dao.impl;

import com.hlz.crm.dao.ICustomerDao;
import com.hlz.crm.domain.CstCustomer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 客户持久层实现类
 * @author Henryhlz
 */
@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    public void saveCustomer(CstCustomer customer) {
        hibernateTemplate.save(customer);
    }

    @Override
    public List<CstCustomer> findAllCustomer() {
        return (List<CstCustomer>) hibernateTemplate.find("select new CstCustomer(custId,custName) from CstCustomer ");
    }

    /**
     * 根据ID查询单个客户
     *
     * @param custId
     * @return
     */
    @Override
    public CstCustomer findById(long custId) {
        return hibernateTemplate.load(CstCustomer.class, custId);
    }

    /**
     * 删除客户
     *
     * @param custId
     */
    @Override
    public void delCustomer(long custId) {
        hibernateTemplate.delete(findById(custId));
    }

    /**
     * 编辑客户
     *
     * @param customer
     */
    @Override
    public void updateCustomer(CstCustomer customer) {
        hibernateTemplate.update(customer);
    }

    /**
     * 根据离线条件查询客户
     *
     * @param criteria
     * @return
     */
    @Override
    public List<CstCustomer> findAllCustomer(DetachedCriteria criteria) {
        return (List<CstCustomer>) hibernateTemplate.findByCriteria(criteria);
    }

    /**
     * 根据离线条件查询客户进行分页
     *
     * @param criteria
     * @param firstResult 开始行数
     * @param maxResults  要查询结果数
     * @return
     */
    @Override
    public List<CstCustomer> findAllCustomer(DetachedCriteria criteria, int firstResult, int maxResults) {
        criteria.setProjection(null);
        return (List<CstCustomer>) hibernateTemplate.findByCriteria(criteria, firstResult, maxResults);
    }

    @Override
    public int findAllRecords(DetachedCriteria criteria) {
        criteria.setProjection(Projections.count("custId"));
        List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(criteria);
        return list.isEmpty() ? 0 : list.get(0).intValue();
    }
}
