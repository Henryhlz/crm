﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<SCRIPT language=javascript>
	function dellkm(lkmId) {
		var sure = window.confirm("确定删除吗");
		if (sure) {
			window.location.href = "${pageContext.request.contextPath }/linkman/delLinkman.action?linkman.lkmId=" + lkmId;
		}
	}
</SCRIPT>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id="customerForm" name="customerForm" action="${pageContext.request.contextPath }/linkman/findAllLinkman.action"
	  method=post>
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
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<td>联系人名称：</td>
													<td>
														<s:textfield class="textbox" id="sChannel2" style="WIDTH: 180px"
																	 maxLength="50"
																	 name="linkman.lkmName"/>
													</td>
													<td>联系人职位 ：</td>
													<td>
														<s:textfield class="textbox" id="sChannel2" style="WIDTH: 180px"
																	 maxLength="50"
																	 name="linkman.lkmPosition"/>
													</td>
													<td>所属客户：</td>
													<td colspan="3">
														<s:select name="linkman.customer.custId" list="customers"
																  listKey="custId" listValue="custName"
																  headerKey="" headerValue="---请选择---"
																  style="WIDTH: 180px"/>
													</td>
													<td>联系人性别：</td>
													<td>
														<s:select name="linkman.lkmGender"
																  list="#{'male':'男','female':'女'}"
																  headerKey="" headerValue="---请选择---"
																  style="WIDTH: 180px"/>
													</td>
													<TD><INPUT class=button id=sButton2 type=submit value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD>
										<TABLE id=grid style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc" cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>邮箱</TD>
													<TD>职位</TD>
													<TD>备注</TD>
													<TD>所属客户</TD>
													<TD>操作</TD>
												</TR>
												<s:iterator value="%{page.records}">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${lkmName }</TD>
													<TD>
														<s:if test="%{lkmGender == 'male'}">男</s:if>
														<s:else>女</s:else>
													</TD>
													<TD>${lkmPhone }</TD>
													<TD>${lkmMobile }</TD>
													<TD>${lkmEmail }</TD>
													<TD>${lkmPosition }</TD>
													<TD>${lkmMemo }</TD>
													<TD>${customer.custName}</TD>
													<TD>
														<s:a action="editLinkmanPage" namespace="/linkman">
															<s:param name="linkman.lkmId" value="%{lkmId}"/>
															修改</s:a>
													&nbsp;&nbsp;
														<s:a href="javascript:dellkm(%{lkmId})">删除</s:a>
													</TD>
												</TR>
												</s:iterator>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD align="center">
										<%--分页--%>
										<%@ include file="/jsp/commons/page.jsp" %>
									</TD>
								</TR>
							</TBODY>
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
					<TD align="center" width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
