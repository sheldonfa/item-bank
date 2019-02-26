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
				权限管理 <small>全部权限</small>
			</h1>
			<ol class="breadcrumb">
				<li>
					<a href="${pageContext.request.contextPath}/index.jsp">
						<i class="fa fa-dashboard"></i> 首页
					</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath}/permission/list/1/5">权限管理</a>
				</li>
				<li class="active">全部权限</li>
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
											onclick="add('permission/show_add')">
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
								<th class="sorting_desc">权限名称</th>
								<th class="sorting_asc sorting_asc_disabled">URL</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${pageInfo.list}" var="permission">
								<tr>
									<td><input name="ids" type="checkbox" value="${permission.id }"/></td>
									<td>${permission.permissionName }</td>
									<td>${permission.url }</td>
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
    $(function () {
        // network.init();
        // action.init();
    });

    var network = {
        init: function () {
            this.categoryList();
        },
        categoryList: function () {
            $.post("/category/tree", {"_method": "GET"}, function (result) {
                if (result["code"] == 0) {
                    /* var options = {
                      bootstrap2: false,
                      showTags: true,
                      levels: 5,
                      data: buildDomTree()
                      // 是否可以选择
                      selectable
                    };*/
                    $('#tree1').treeview({
                        /*源码参考案例：https://blog.csdn.net/irene1991/article/details/79624477*/
                        levels: 10,
                        data: JSON.stringify(result["data"])
                    });
                }
            });
        }
    };

    var action = {
        init: function () {
            this.showCateBtn();
            this.btnDel();
        },
        showCateBtn: function () {
            $(document).on("mouseenter", ".list-group-item", function () {
                $(this).append('<button class="btn btn-danger btn-del-js pull-right">删除</button>')
            }).on("mouseleave", ".list-group-item", function () {
                $(this).find("button").remove()
            });
        },
        btnDel:function(){
            $(document).on("click",".btn-del-js",function(){
                if(confirm("确定删除吗？")){
                    var id = $(this).parents("li").attr("data-nodeid");
                    $.post("/category/del/"+id,function (result) {
                        if(result["code"]==0){
                            window.location.href = "/category/show_list"
                        }else if(result["code"]==500201){
                            alert(result["message"]);
                        }
                    })
                }
            })
        }
    }
</script>
</body>
</html>