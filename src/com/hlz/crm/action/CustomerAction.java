package com.hlz.crm.action;

import com.hlz.crm.service.ICustomerService;
import com.hlz.crm.domain.CstCustomer;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;

/**
 * @author Henryhlz
 */
@Controller
@ParentPackage("struts-default")
@Namespace("/customer")
@Results({
        @Result(name = "addCustomerPage", type = "dispatcher", location = "/jsp/customer/add.jsp"),
        @Result(name = "listCustomer", type = "redirectAction", location = "/jsp/customer/list.jsp"),
        @Result(name = "editCustomerPage", type = "dispatcher", location = "/jsp/customer/edit.jsp"),
        @Result(name = "findAllCustomer", type = "dispatcher", location = "/jsp/customer/list.jsp")
})
public class CustomerAction extends ActionSupport  {
    private CstCustomer customer = new CstCustomer();
    private List<CstCustomer> customers;
    @Autowired
    private ICustomerService customerService;


    /**
     * 添加客户
     * @return
     */
    @Action("addCustomer")
    public  String addCustomer(){
        customerService.saveCustomer(customer);
        return "listCustomer";
    }

    /**
     * 添加客户页面
     * @return
     */
    @Action("addCustomerPage")
    public  String addCustomerPage(){
        return "addCustomerPage";
    }
    /**
     * 查询所有客户
     * @return
     */
    @Action("findAllCustomer")
    public String findAllCustomer(){
        customers = customerService.findAllCustomer();
        return "findAllCustomer";
    }

    public CstCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(CstCustomer customer) {
        this.customer = customer;
    }

    public List<CstCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CstCustomer> customers) {
        this.customers = customers;
    }

}
