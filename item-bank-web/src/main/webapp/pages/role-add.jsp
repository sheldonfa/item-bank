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
				角色管理 <small>角色表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="${pageContext.request.contextPath}/role/list/1/5">角色管理</a></li>
				<li class="active">角色表单</li>
			</ol>
		</section>
		<!-- 内容头部 /-->

		<form action="${pageContext.request.contextPath}/role"
			  method="post">
			<!-- 正文区域 -->
			<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">角色信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">角色名称</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleName"
								   placeholder="角色名称" value=""/>
						</div>
						<div class="col-md-2 title">角色描述</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="roleDesc"
								   placeholder="角色描述" value=""/>
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
<script>
</script>
</body>
</html>