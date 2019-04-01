<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        #sel1, #sel2, #sel3, #sel4, #sel5 {
            width: 100%;
            color: black
        }

        option {
            color: black
        }
    </style>
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
                数据管理
                <small>数据列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">数据管理</a></li>
                <li class="active">数据列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
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

                                    <button data-toggle="modal" data-target="#myModal" id="convert" type="button"
                                            class="btn btn-default" title="转移">
                                        <i class="fa fa-file-o"></i> 转移
                                    </button>
                                    <%--<button type="button" class="btn btn-default" title="删除"><i class="fa fa-trash-o"></i> 删除</button>--%>
                                    <%--<button type="button" class="btn btn-default" title="开启"><i class="fa fa-check"></i> 开启</button>--%>
                                    <%--<button type="button" class="btn btn-default" title="屏蔽"><i class="fa fa-ban"></i> 屏蔽</button>--%>
                                    <%--<button type="button" class="btn btn-default" title="刷新"><i class="fa fa-refresh"></i> 刷新</button>--%>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm" placeholder="搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right:0px;">
                                    <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting_asc">ID</th>
                                <th class="sorting_desc">题目名称</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${questions}" var="e">
                                <tr>
                                    <td><input name="ids" type="checkbox" value="${e.id}"></td>
                                    <td>${e.id}</td>
                                    <td>${e.content}
                                    </td>
                                    <td class="text-center">
                                        <button type="button" class="btn bg-olive btn-xs">订单</button>
                                        <button type="button" class="btn bg-olive btn-xs">详情</button>
                                        <button type="button" class="btn bg-olive btn-xs">编辑</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <input type="hidden" id="categoryIdInput" name="categoryId">
                        <!--数据列表/-->
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm" placeholder="搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        <!--工具栏/-->

                    </div>
                    <!-- 数据表格 /-->


                    <!--模态窗口-->
                    <div class="tab-pane" id="tab-model">

                        <div id="myModal" class="modal modal-primary" role="dialog">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title">选择分类</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="box-body">
                                            <div class="form-horizontal">
                                                <div class="form-group">
                                                    <div class="col-sm-5">
                                                        <select id="sel1" data-select-level="1"
                                                                data-placeholder="选择分类"
                                                                aria-hidden="true">
                                                            <option>请选择</option>
                                                            <c:forEach items="${categories}" var="e">
                                                                <option value="${e.id}">${e.name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline" data-dismiss="modal">关闭</button>
                                        <button id="confirm" type="button" class="btn btn-outline">确定</button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>

                            <!-- /.modal-dialog -->
                        </div>
                        <!-- /.modal -->
                    </div>
                    <!--模态窗口/-->


                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共2 页，共14 条数据。 每页
                            <select class="form-control">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select> 条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">首页</a>
                            </li>
                            <li><a href="#">上一页</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">下一页</a></li>
                            <li>
                                <a href="#" aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /.box-footer-->


            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->
    <jsp:include page="common/footer.jsp"/>
</div>
<jsp:include page="common/script.jsp"/>
<script>
    $(function () {
        action.bind();
    });

    var action = {
        bind: function () {
            this.btnSelectAll();
            this.changeSelect();
            this.confirmConvert();
        },
        btnSelectAll: function () {
            // 全选
            $(document).on("click", "#selall", function () {
                var result = $("#selall").prop("checked");
                if (result) {
                    $("[name=ids]").prop("checked", true);
                } else {
                    $("[name=ids]").prop("checked", false);
                }
            });
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
                                '<select id="sel' + eval(level + 1) + '" data-select-level="' + eval(level + 1) + '" data-placeholder="选择分类" style="width: 100%;" aria-hidden="true">' +
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
        confirmConvert: function () {
            $(document).on("click", "#confirm", function () {
                var ids = [];
                var boxes = $("[name=ids]:checked");
                boxes.each(function (i, e) {
                    var id = $(e).val();
                    ids.push(id);
                });
                var categoryId = $("#categoryIdInput").val();
                var data = {
                    ids: ids,
                    categoryId: categoryId
                }
                network.updatesQuestion(data).done(function (result) {
                    if (result["code"] == 0) {
                        window.location.reload();
                    }else {
                        alert(result.message)
                    }
                })
            })
        }

    };
</script>
<script src="../js/network.js"></script>
</body>
</html>