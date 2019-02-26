<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- 页面meta -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">

		<title>数据后台管理 - 403</title>
		<meta name="description" content="403<">
		<meta name="keywords" content="403<">

		<!-- Tell the browser to be responsive to screen width -->
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

		<!-- 引入css -->
		<jsp:include page="pages/common/css.jsp"></jsp:include>
		<!-- 引入css /-->

	</head>

	<body class="hold-transition skin-blue sidebar-mini" style="overflow:scroll;overflow-x:hidden">

		<div class="wrapper">

			<!-- 页面头部 -->
			<jsp:include page="pages/common/header.jsp"></jsp:include>
			<!-- 页面头部 /-->

			<!-- 导航侧栏 -->
			<jsp:include page="pages/common/aside.jsp"></jsp:include>
			<!-- 导航侧栏 /-->

			<!-- 内容区域 -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        403 错误页面
                    </h1>

                    <ol class="breadcrumb">
                        <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                        <li class="active">403 错误</li>
                    </ol>

                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="error-page">
                        <h2 class="headline text-yellow"> 403</h2>

                        <div class="error-content">
                            <h3><i class="fa fa-warning text-yellow"></i> Oops! 权限不足.</h3>

                            <p>
                                没有找到你请求的页面, 你可以 <a href="all-admin-index.html">返回到后台首页</a> 或者通过搜索查询
                            </p>

                            <form class="search-form">
                                <div class="input-group">
                                    <input type="text" name="search" class="form-control" placeholder="搜索">

                                    <div class="input-group-btn">
                                        <button type="submit" name="submit" class="btn btn-warning btn-flat"><i class="fa fa-search"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- /.input-group -->
                            </form>
                        </div>
                        <!-- /.error-content -->
                    </div>
                    <!-- /.error-page -->
                </section>
                <!-- /.content -->
            </div>
			<!-- 内容区域 /-->

			<!-- 底部导航 -->
			<jsp:include page="pages/common/footer.jsp"></jsp:include>
			<!-- 底部导航 /-->
		</div>
	</body>
	<!-- 引入js -->
	<jsp:include page="pages/common/js.jsp"></jsp:include>
	<!-- 引入js /-->
</html>