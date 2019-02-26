<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- 页面meta -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">

		<title>数据后台管理 - 登录失败</title>
		<meta name="description" content="登录失败">
		<meta name="keywords" content="登录失败">

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
                    <h1>登录失败 页面</h1>

                    <ol class="breadcrumb">
                        <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                                class="fa fa-dashboard"></i> 首页</a></li>
                        <li class="active">登录失败</li>
                    </ol>

                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="error-page">


                        <div class="error-content">

                            <p>
                                登录失败 , 你可以 <a href="${pageContext.request.contextPath}/login.jsp">返回到登录页面</a>
                                重新登录
                            </p>


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