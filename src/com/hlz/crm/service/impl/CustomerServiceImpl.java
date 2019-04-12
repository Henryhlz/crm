package com.hlz.crm.service.impl;

import com.hlz.crm.service.ICustomerService;
import com.hlz.crm.dao.ICustomerDao;
import com.hlz.crm.domain.CstCustomer;
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
     * 查询所有客户
     */
    @Override
    public List<CstCustomer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }
}
