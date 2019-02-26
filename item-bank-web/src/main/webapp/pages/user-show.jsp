<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- 页面meta -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>数据后台管理 - 用户</title>
		<meta name="description" content="用户">
		<meta name="keywords" content="用户">
		<!-- Tell the browser to be responsive to screen width -->
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

		<!-- 引入css -->
		<jsp:include page="common/css.jsp"></jsp:include>
		<!-- 引入css /-->
	</head>

<body class="hold-transition skin-blue sidebar-mini" style="overflow:scroll;overflow-x:hidden">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="common/header.jsp"></jsp:include>
		<!-- 页面头部 /-->

		<!-- 导航侧栏 -->
		<jsp:include page="common/aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				用户管理 <small>全部用户</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/user/list/1/5">用户管理</a></li>

				<li class="active">全部用户</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content"> <!-- .box-body -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">列表</h3>
				</div>

				<div class="box-body">

					<!-- 数据表格 -->
					<div class="table-box">

						<!--数据列表-->
						<div class="tab-pane" id="tab-treetable">
							<table id="collapse-table"
								class="table table-bordered table-hover dataTable">
								<thead>
									<tr colspan="2">
										<th>用户名称：${user.username}</th>
									</tr>
								</thead>

								<tbody>
                                    <tr>
                                        <td colspan="2">用户角色：</td>
                                    </tr>
									<c:forEach items="${user.roleList}" var="role">
										<tr data-tt-id="1" data-tt-parent-id="0" style="color: red;">
											<td style="padding-left: 80px;">
                                                    ${role.roleName }
                                            </td>
											<td>${role.roleDesc }</td>
										</tr>
										<c:forEach items="${role.permissionList}" var="permission">
											<tr data-tt-id="1-1" data-tt-parent-id="1">
												<td style="padding-left: 160px;">
                                                        ${permission.permissionName}
                                                </td>
												<td>${permission.url}</td>
											</tr>

										</c:forEach>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!--数据列表/-->

					</div>
					<!-- 数据表格 /-->

				</div>
				<!-- /.box-body -->

				<!-- .box-footer-->
				<%--<jsp:include page="common/page.jsp"></jsp:include>--%>
				<!-- /.box-footer-->

			</div>

			</section>
			<!-- 正文区域 /-->

		</div>
		<!-- @@close -->
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<jsp:include page="common/footer.jsp"></jsp:include>
		<!-- 底部导航 /-->

	</div>
</body>
	<!-- 引入js -->
	<jsp:include page="common/js.jsp"></jsp:include>
	<!-- 引入js /-->
</html>