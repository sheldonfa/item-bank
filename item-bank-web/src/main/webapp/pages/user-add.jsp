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
				用户管理 <small>用户表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
						href="${pageContext.request.contextPath}/user/list/1/5">用户管理</a></li>
				<li class="active">用户表单</li>
			</ol>
		</section>
		<!-- 内容头部 /-->

		<form action="${pageContext.request.contextPath}/user"
			  method="post">
			<!-- 正文区域 -->
			<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">用户信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">用户名称</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="username"
								   placeholder="用户名称" value=""/>
						</div>
						<div class="col-md-2 title">密码</div>
						<div class="col-md-4 data">
							<input type="password" class="form-control" name="password"
								   placeholder="密码" value=""/>
						</div>
						<div class="col-md-2 title">邮箱</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="email"
								   placeholder="邮箱" value=""/>
						</div>
						<div class="col-md-2 title">联系电话</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="phoneNum"
								   placeholder="联系电话" value=""/>
						</div>
						<div class="col-md-2 title">用户状态</div>
						<div class="col-md-4 data">
							<select class="form-control select2" style="width: 100%"
									name="status">
								<option value="0" >禁用</option>
								<option value="1" selected="selected">正常</option>
							</select>
						</div>

					</div>
				</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
					<button type="button" class="btn bg-default"
							onclick="history.back(-1);">返回</button>
				</div>
				<!--工具栏/--> </section>
			<!-- 正文区域 /-->
		</form>
	</div>
	<!-- 内容区域 /-->
	<jsp:include page="common/footer.jsp"/>
</div>
<jsp:include page="common/script.jsp"/>
</body>
</html>
