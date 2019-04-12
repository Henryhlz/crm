package com.hlz.crm.action;


import com.hlz.crm.domain.BaseDict;
import com.hlz.crm.service.IBaseDictService;
import com.hlz.crm.service.ICustomerService;
import com.hlz.crm.domain.CstCustomer;
import com.hlz.framework.commons.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;

/**
 * 客户动作类
 * @author Henryhlz
 */
@Controller
@ParentPackage("struts-default")
@Namespace("/customer")
@Results({
        @Result(name = "addCustomerPage", type = "dispatcher", location = "/jsp/customer/add.jsp"),
        @Result(name = "listCustomer", type = "redirectAction", location = "findAllCustomer"),
        @Result(name = "editCustomerPage", type = "dispatcher", location = "/jsp/customer/edit.jsp"),
        @Result(name = "findAllCustomer", type = "dispatcher", location = "/jsp/customer/list.jsp")
})
public class CustomerAction extends ActionSupport  {
    private CstCustomer customer = new CstCustomer();
    private List<CstCustomer> customers;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IBaseDictService baseDictService;
    private List<BaseDict> custSources;
    private List<BaseDict> custLevels;
    private int pageNum;
    private Page page;


    /**
     * 删除客户
     * * @return
     */
    @Action("removeCustomer")
    public String removeCustomer() {
        customerService.removeCustomer(customer.getCustId());
        return "listCustomer";
    }


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
        custSources = baseDictService.findAllCustSources();
        custLevels = baseDictService.findAllCustLevels();
        return "addCustomerPage";
    }

    /**
     * 编辑客户
     *
     * @return
     */
    @Action("editCustomer")
    public String editCustomer() {
        customerService.editCustomer(customer);
        return "listCustomer";
    }

    /**
     * 编辑客户页面
     *
     * @return
     */
    @Action("editCustomerPage")
    public String editCustomerPage() {
        custSources = baseDictService.findAllCustSources();
        custLevels = baseDictService.findAllCustLevels();
        customer = customerService.findById(customer.getCustId());
        return "editCustomerPage";
    }

    /**
     * 查询所有客户
     * @return
     */
    @Action("findAllCustomer")
    public String findAllCustomer() {
        //获取离线对象
        DetachedCriteria criteria = DetachedCriteria.forClass(CstCustomer.class);
        //拼装查询条件
        //判断是否输入客户名称
        if (StringUtils.isNoneBlank(customer.getCustName())) {
            criteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
        }
        //判断是否输入所属行业
        if (StringUtils.isNoneBlank(customer.getCustIndustry())) {
            criteria.add(Restrictions.like("custIndustry", "%" + customer.getCustIndustry() + "%"));
        }
        //判断是否输入客户来源
        if (customer.getCustSource() != null && StringUtils.isNoneBlank(customer.getCustSource().getDictId())) {
            criteria.add(Restrictions.eq("custSource", customer.getCustSource()));
        }
        //判断是否输入客户级别
        if (customer.getCustLevel() != null && StringUtils.isNoneBlank(customer.getCustLevel().getDictId())) {
            criteria.add(Restrictions.eq("custLevel", customer.getCustLevel()));
        }
        //根据离线条件查询客户
        page = customerService.findAllCustomer(criteria, pageNum);
        //获取客户来源
        custSources = baseDictService.findAllCustSources();
        //获取客户级别
        custLevels = baseDictService.findAllCustLevels();
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

    public List<BaseDict> getCustSources() {
        return custSources;
    }

    public void setCustSources(List<BaseDict> custSources) {
        this.custSources = custSources;
    }

    public List<BaseDict> getCustLevels() {
        return custLevels;
    }

    public void setCustLevels(List<BaseDict> custLevels) {
        this.custLevels = custLevels;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
