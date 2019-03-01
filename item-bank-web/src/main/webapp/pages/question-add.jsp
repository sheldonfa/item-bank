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
            <form action="${pageContext.request.contextPath}/question/add">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">模块操作</h3>
                    </div>

                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-2">
                                <select id="sel1" data-select-level="1"
                                        data-placeholder="选择分类" style="width: 100%;"
                                        aria-hidden="true">
                                    <option>请选择</option>
                                    <c:forEach items="${categories}" var="i">
                                        <option value="${i.id}">${i.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!-- /.col -->
                        </div>
                        <!-- /.row -->
                        <div class="row">
                            <div class="col-md-12">
                                <textarea name="content" id="markdown-textarea" htmlEscape="true"
                                          style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" id="categoryIdInput" name="categoryId">
                    <div class="box-footer">
                        <button class="btn">取消</button>
                        <button id="btn-create" class="btn btn-success">创建</button>
                    </div>
                </div>
            </form>
        </section>
    </div>
    <!-- /.页面内容 -->
    <jsp:include page="common/footer.jsp"/>
</div>
<jsp:include page="common/script.jsp"/>
<script>
    $(function () {
        setup.init();
        action.bind();
    });
    var setup = {
        init: function () {

        }
    };
    var action = {
        bind:function(){
            this.changeSelect();
            this.btnCreate();
        },
        changeSelect: function () {
            $(document).on("change", "#sel1,#sel2,#sel3,#sel4,#sel5", function () {
                var target = $(this);
                var level = $(this).data("select-level");
                var id = $(this).val();
                $("#categoryIdInput").val(id);
                network.selectChildCategory(id).done(function (result) {
                    if (result["code"] == 0) {
                        var children = result["data"];
                        // 有子节点
                        if (children.length > 0) {
                            var subSelect = $("#sel" + eval(level + 1));
                            var newdiv = ' <div class="col-md-2">' +
                                '<select id="sel' + eval(level + 1) + '" data-select-level="' + eval(level + 1)+'" data-placeholder="选择分类" style="width: 100%;" aria-hidden="true">' +
                                '<option>请选择</option>'
                            for (var i in children) {
                                newdiv += '                           <option value="' + children[i].id + '">' + children[i].name + '</option>'
                            }
                            newdiv += '</select>' +
                            '</div>';
                            // 已经存在这个下拉框
                            if (subSelect[0]) {
                                subSelect.parent().before(newdiv);
                                subSelect.parent().remove();
                            } else {
                                console.log(newdiv);
                                target.parent().after($(newdiv))
                            }
                        }
                    }
                })
            })
        },
        btnCreate: function(){
            // $(document).on("click","#btn-create",function(){
            //     network.addQuestion().done(function(result){
            //
            //     })
            // })
        }
    };
    var network = {
        selectChildCategory: function (id) {
            var df = $.Deferred();
            $.ajax({
                type: "GET",
                url: "/category/" + id + "/children",
                contentType: "application/json; charset=utf-8",
                success: function (result) {
                    df.resolve(result)
                }
            });
            return df;
        },
        addQuestion: function (id) {
            var df = $.Deferred();
            var data={

            };
            $.ajax({
                type: "POST",
                url: "/question",
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(data),
                success: function (result) {
                    df.resolve(result)
                }
            });
            return df;
        }
    }
</script>
</body>
</html>