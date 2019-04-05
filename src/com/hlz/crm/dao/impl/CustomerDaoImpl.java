package com.hlz.crm.dao.impl;

import com.hlz.crm.dao.ICustomerDao;
import com.hlz.crm.domain.CstCustomer;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

/**
 * @author Henryhlz
 */
public class CustomerDaoImpl implements ICustomerDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void saveCustomer(CstCustomer customer) {
        hibernateTemplate.save(customer);
    }

    @Override
    public List<CstCustomer> findAllCustomer() {
        return (List<CstCustomer>) hibernateTemplate.find("from CstCustomer ");
    }
}
