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
    <!--页面内容-->
    <div class="content-wrapper">
        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                模块名称
                <small>模块功能</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">模块名称</a></li>
                <li class="active">模块功能</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">
            <div id="tree1" class="treeview col-md-6"></div>
        </section>
    </div>
    <!-- /.页面内容 -->
    <jsp:include page="common/footer.jsp"/>
</div>
<jsp:include page="common/script.jsp"/>
<script>
    $(function () {
        network.init();
        action.init();
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