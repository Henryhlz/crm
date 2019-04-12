﻿<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<TITLE>编辑客户</TITLE>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
	<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
	<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<s:debug></s:debug>
<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/customer/editCustomer.action" method=post>
	<s:hidden name="customer.custId"></s:hidden>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
			<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg" height=20></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg" border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg">
				<IMG src="${pageContext.request.contextPath }/images/new_022.jpg" border=0>
			</TD>
			<TD vAlign=top width="100%" bgColor=#ffffff>
				<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
					<TR>
						<TD class=manageHead>当前位置：客户管理 &gt; 编辑客户</TD>
					</TR>
					<TR>
						<TD height=2></TD>
					</TR>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=5 border=0>
					<TR>
						<td>客户名称：</td>
						<td>
							<s:textfield class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50"
										 name="customer.custName"></s:textfield>
						</td>
						<td>所属行业 ：</td>
						<td>
							<s:textfield class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50"
										 name="customer.custIndustry"></s:textfield>
						</td>
					</TR>
					<TR>
						<td>信息来源 ：</td>
						<td>
							<s:select name="customer.custSource.dictId" list="custSources" listKey="dictId"
									  listValue="dictItemName"
									  headerKey="" headerValue="---请选择---" class="textbox" id="sChannel2"
									  style="WIDTH: 180px"/>
						</td>
						<td>客户级别：</td>
						<td>
							<s:select name="customer.custLevel.dictId" list="custLevels" listKey="dictId"
									  listValue="dictItemName"
									  headerKey="" headerValue="---请选择---" class="textbox" id="sChannel2"
									  style="WIDTH: 180px"/>
						</td>
					</TR>
					<TR>
						<td>联系地址 ：</td>
						<td>
							<s:textfield class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50"
										 name="customer.custAddress"></s:textfield>
						</td>
						<td>联系电话 ：</td>
						<td>
							<s:textfield class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50"
										 name="customer.custPhone"></s:textfield>
						</td>
					</TR>
					<tr>
						<td rowspan=2>
							<INPUT class=button id=sButton2 type=submit value=" 保存 " name=sButton2>
						</td>
					</tr>
				</TABLE>
			</TD>
			<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
				<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0>
			</TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg" border=0></TD>
			<TD align="center" width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg"
				height=15></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg" border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
</FORM>
</BODY>
</HTML>
