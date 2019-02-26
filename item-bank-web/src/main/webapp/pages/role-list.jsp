<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="common/css.jsp"/>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">
	<jsp:include page="common/header.jsp"/>
	<jsp:include page="common/aside.jsp"/>
	<!-- 内容区域 -->
	<div class="content-wrapper">
		<!-- 内容头部 -->
		<section class="content-header">
			<h1>
				角色管理 <small>全部角色</small>
			</h1>
			<ol class="breadcrumb">
				<li>
					<a href="${pageContext.request.contextPath}/index.jsp">
						<i class="fa fa-dashboard"></i>
						首页
					</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/role/list/1/5">角色管理</a>
				</li>
				<li class="active">全部角色</li>
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
						<!--工具栏-->
						<div class="pull-left">
							<div class="form-group form-inline">
								<div class="btn-group">
									<button type="button" class="btn btn-default" title="新建"
											onclick="add('role/show_add')">
										<i class="fa fa-file-o"></i> 新建
									</button>

									<button type="button" class="btn btn-default" title="刷新">
										<i class="fa fa-refresh"></i> 刷新
									</button>
								</div>
							</div>
						</div>
						<!--工具栏/-->

						<!--数据列表-->
						<table id="dataList"
							   class="table table-bordered table-striped table-hover dataTable">
							<thead>
							<tr>
								<th class="sorting_asc">ID</th>
								<th class="sorting_desc">角色名称</th>
								<th class="sorting">角色描述</th>
								<th class="text-center">操作</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${pageInfo.list}" var="role">
								<tr>
									<td><input name="ids" type="checkbox" value="${role.id}"/></td>
									<td>${role.roleName }</td>
									<td>${role.roleDesc }</td>
									<td class="text-center">
										<button type="button" class="btn bg-olive btn-xs" onclick="edit('role/show_role_permission/${role.id}')">分配权限</button>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<!--数据列表/-->

					</div>
					<!-- 数据表格 /-->

				</div>
				<!-- /.box-body -->

				<!-- .box-footer-->
				<jsp:include page="common/page.jsp"></jsp:include>
				<!-- /.box-footer-->

			</div>

		</section>
		<!-- 正文区域 /-->

	</div>
	<!-- @@close -->
	<!-- 内容区域 /-->
	<jsp:include page="common/footer.jsp"/>
</div>
<jsp:include page="common/script.jsp"/>
<script>
</script>
</body>
</html>