<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- 页面meta -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">

		<title>数据后台管理 - 日志</title>
		<meta name="description" content="日志">
		<meta name="keywords" content="日志">

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
						日志管理 <small>全部日志</small>
					</h1>
					<ol class="breadcrumb">
						<li>
							<a href="${pageContext.request.contextPath}/index.jsp">
								<i class="fa fa-dashboard"></i> 首页
							</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/sysLog/list/1/5">日志管理</a>
						</li>
						<li class="active">全部日志</li>
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
										<button type="button" class="btn btn-default" title="刷新"
											onclick="window.location.reload();">
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
										<th class="sorting">访问时间</th>
										<th class="sorting">访问用户</th>
										<th class="sorting">访问IP</th>
										<th class="sorting">访问方法</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${pageInfo.list}" var="syslog">
										<tr>
											<td><input name="ids" type="checkbox" value="${syslog.id}"/></td>
											<td>
                                                <fmt:formatDate value="${syslog.visitTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                             </td>
											<td>${syslog.username }</td>
											<td>${syslog.ip }</td>
											<td>${syslog.method}</td>
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