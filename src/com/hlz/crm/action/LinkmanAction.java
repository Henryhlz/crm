package com.hlz.crm.action;

import com.hlz.crm.domain.CstCustomer;
import com.hlz.crm.domain.CstLinkman;
import com.hlz.crm.service.ICustomerService;
import com.hlz.crm.service.ILinkmanService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 联系人动作类
 *
 * @author Henryhlz
 */
@Controller
@ParentPackage("struts-default")
@Namespace("/linkman")
@Results({
        @Result(name = "addLinkmanPage", type = "dispatcher", location = "/jsp/linkman/add.jsp"),
        @Result(name = "findAllLinkman", type = "dispatcher", location = "/jsp/linkman/list.jsp"),
        @Result(name = "editLinkmanPage", type = "dispatcher", location = "/jsp/linkman/edit.jsp"),
        @Result(name = "listLinkman", type = "redirectAction", location = "findAllLinkman")
})
public class LinkmanAction {
    @Autowired
    private ILinkmanService linkmanService;
    @Autowired
    private ICustomerService customerService;
    private CstLinkman linkman = new CstLinkman();
    private List<CstLinkman> linkmans;
    private List<CstCustomer> customers;

    /**
     * 删除联系人
     *
     * @return
     */
    @Action("delLinkman")
    public String delLinkman() {
        linkmanService.delLinkman(linkman.getLkmId());
        return "listLinkman";
    }

    /**
     * 获取编辑联系人页面
     *
     * @return
     */
    @Action("editLinkmanPage")
    public String editLinkmanPage() {
        customers = customerService.findAllCustomer();
        linkman = linkmanService.findById(linkman.getLkmId());
        return "editLinkmanPage";
    }

    /**
     * 编辑联系人
     *
     * @return
     */
    @Action("editLinkman")
    public String editLinkman() {
        linkmanService.editLinkman(linkman);
        return "listLinkman";
    }

    /**
     * 获取添加联系人页面
     *
     * @return
     */
    @Action("addLinkmanPage")
    public String addLinkmanPage() {
        customers = customerService.findAllCustomer();
        return "addLinkmanPage";
    }

    /**
     * 添加联系人
     *
     * @return
     */
    @Action("addLinkman")
    public String addLinkman() {
        linkmanService.addLinkman(linkman);
        return "listLinkman";
    }

    /**
     * 获取添加联系人页面
     *
     * @return
     */
    @Action("findAllLinkman")
    public String findAllLinkman() {
        DetachedCriteria criteria = DetachedCriteria.forClass(CstLinkman.class);
        //判断是否输入联系人名称
        if (StringUtils.isNoneBlank(linkman.getLkmName())) {
            criteria.add(Restrictions.like("lkmName", "%" + linkman.getLkmName() + "%"));
        }
        //判断是否输入联系人职位
        if (StringUtils.isNoneBlank(linkman.getLkmPosition())) {
            criteria.add(Restrictions.like("lkmPosition", "%" + linkman.getLkmPosition() + "%"));
        }
        //判断是否输入联系人所属客户
        if (linkman.getCustomer() != null && linkman.getCustomer().getCustId() != 0) {
            criteria.add(Restrictions.eq("customer", linkman.getCustomer()));
        }
        //判断是否输入联系人性别
        if (StringUtils.isNoneBlank(linkman.getLkmGender())) {
            criteria.add(Restrictions.eq("lkmGender", linkman.getLkmGender()));
        }
        linkmans = linkmanService.findAllLinkman(criteria);
        customers = customerService.findAllCustomer();
        return "findAllLinkman";
    }

    public CstLinkman getLinkman() {
        return linkman;
    }

    public void setLinkman(CstLinkman linkman) {
        this.linkman = linkman;
    }

    public List<CstLinkman> getLinkmans() {
        return linkmans;
    }

    public void setLinkmans(List<CstLinkman> linkmans) {
        this.linkmans = linkmans;
    }

    public List<CstCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CstCustomer> customers) {
        this.customers = customers;
    }
}
