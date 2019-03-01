<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/css.jsp"/>
    <style>
        .tree {
            min-height: 20px;
            padding: 19px;
            margin-bottom: 20px;
            background-color: #fbfbfb;
            border: 1px solid #999;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
            -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
            -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
            box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05)
        }

        .tree li {
            list-style-type: none;
            margin: 0;
            padding: 10px 5px 0 5px;
            position: relative
        }

        .tree li::before, .tree li::after {
            content: '';
            left: -20px;
            position: absolute;
            right: auto
        }

        .tree li::before {
            border-left: 1px solid #999;
            bottom: 50px;
            height: 100%;
            top: 0;
            width: 1px
        }

        .tree li::after {
            border-top: 1px solid #999;
            height: 20px;
            top: 25px;
            width: 25px
        }

        .tree li span {
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border: 1px solid #999;
            border-radius: 5px;
            display: inline-block;
            padding: 3px 8px;
            text-decoration: none
        }

        .tree li.parent_li > span {
            cursor: pointer
        }

        .tree > ul > li::before, .tree > ul > li::after {
            border: 0
        }

        .tree li:last-child::before {
            height: 30px
        }

        .tree li.parent_li > span:hover, .tree li.parent_li > span:hover + ul li span {
            background: #eee;
            border: 1px solid #94a0b4;
            color: #000
        }
    </style>
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
            <div class="">
                <label for="rootinput">添加新目录</label>
                <input id="rootinput" type="text">
                <button id="btn-root-add" class="btn btn-success">确定</button>
            </div>
            <div class="tree well">

                <ul id="rootUL">

                </ul>
            </div>
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
            this.categoryList();
        },
        categoryList: function () {
            network.getTree().done(function (result) {
                var json = result["data"]
                var json2 =
                    [{
                        "name": "中科慈航",
                        "code": "ZKCH",
                        "icon": "icon-th",
                        "child": [
                            {
                                "name": "广州中科慈航",
                                "icon": "icon-minus-sign",
                                "code": "GZZKCH",
                                "parentCode": "ZKCH",
                                "child": [
                                    {
                                        "name": "广州中科慈航天河区分行",
                                        "code": "GZZKCHTQFH",
                                        "icon": "",
                                        "parentCode": "GZZKCH",
                                        "child": []
                                    }
                                ]
                            },
                            {
                                "name": "北京中科慈航",
                                "icon": "",
                                "code": "BJZKCH",
                                "parentCode": "ZKCH",
                                "child": [
                                    {
                                        "name": "北京中科慈航中城区分行",
                                        "code": "BJZKCHZCFH",
                                        "icon": "",
                                        "parentCode": "BJZKCH",
                                        "child": []
                                    }
                                ]
                            }
                        ]
                    }]
                console.log(JSON.stringify(json))
                console.log(JSON.stringify(json2))
                if (result["code"] == 0) {
                    tree(json);
                    // move();

                    function tree(data) {
                        for (var i = 0; i < data.length; i++) {
                            var data2 = data[i];
                            if (data[i].icon == "icon-th") {
                                $("#rootUL").append(
                                    "<li data-id='" + data[i].code + "'>" +
                                    "<span>" +
                                    "<i class='" + data[i].icon + "'></i> " + data[i].name + "" +
                                    "</span>" +
                                    "<i class='btn-add glyphicon glyphicon-plus'  data-id='" + data[i].code + "'></i>" +
                                    "<i class='btn-edit glyphicon glyphicon-pencil'  data-id='" + data[i].code + "'></i>" +
                                    "<i class='btn-del glyphicon glyphicon-trash'  data-id='" + data[i].code + "'></i>" +
                                    "</li>");
                            } else {
                                var children = $("li[data-id='" + data[i].parentCode + "']").children("ul");
                                if (children.length == 0) {
                                    $("li[data-id='" + data[i].parentCode + "']").append("<ul></ul>")
                                }
                                $("li[data-id='" + data[i].parentCode + "'] > ul").append(
                                    "<li data-id='" + data[i].code + "'>" +
                                    "<span>" +
                                    "<i class='" + data[i].icon + "'></i> " + data[i].name +
                                    "</span>" +
                                    "<i class='btn-add glyphicon glyphicon-plus' data-id='" + data[i].code + "'></i>" +
                                    "<i class='btn-edit glyphicon glyphicon-pencil' data-id='" + data[i].code + "'></i>" +
                                    "<i class='btn-del glyphicon glyphicon-trash'  data-id='" + data[i].code + "'></i>" +
                                    "</li>")
                            }
                            for (var j = 0; j < data[i].child.length; j++) {
                                var child = data[i].child[j];
                                var children = $("li[data-id='" + child.parentCode + "']").children("ul");
                                if (children.length == 0) {
                                    $("li[data-id='" + child.parentCode + "']").append("<ul></ul>")
                                }
                                $("li[data-id='" + child.parentCode + "'] > ul").append(
                                    "<li data-id='" + child.code + "'>" +
                                    "<span>" +
                                    "<i class='" + child.icon + "'></i> " + child.name +
                                    "</span>" +
                                    "<i class='btn-add glyphicon glyphicon-plus' data-id='" + child.code + "'></i>" +
                                    "<i class='btn-edit glyphicon glyphicon-pencil' data-id='" + child.code + "'></i>" +
                                    "<i class='btn-del glyphicon glyphicon-trash'  data-id='" + child.code + "'></i>" +
                                    "</li>")
                                var child2 = data[i].child[j].child;
                                tree(child2)
                            }
                            tree(data[i]);
                        }

                    }

                    function move() {
                        $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', '关闭');
                        $('.tree li.parent_li > span').on('click', function (e) {
                            var children = $(this).parent('li.parent_li').find(' > ul > li');
                            if (children.is(":visible")) {
                                children.hide('fast');
                                $(this).attr('title', '展开').find(' > i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
                            } else {
                                children.show('fast');
                                $(this).attr('title', '关闭').find(' > i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
                            }
                        });
                    }
                }
            });
        }
    };

    var action = {
        bind: function () {
            this.btnAdd();
            this.btnEdit();
            this.btnDel();
            this.btnRootAdd();
        },
        btnAdd: function () {
            // 添加输入框
            $(document).on("click", ".btn-add", function () {
                var parentId = $(this).data("id");
                $(this).parent().append('<ul><li><span><input type="text"><i class="btn-add-confirm glyphicon glyphicon-ok" data-parent-id="' + parentId + '"></i></span></li></ul>')
            });
            // 确认
            $(document).on("click", ".btn-add-confirm", function (e) {
                var parentId = $(this).data("parent-id");
                var name = $(this).prev("input").val();
                network.addCategory(parentId, name).done(function (result) {
                    if (result["code"] == 0) {
                        window.location.href = "/category/show_list"
                    }
                })
                e.stopPropagation();
            })
        },
        btnEdit: function () {
            // 添加输入框
            $(document).on("click", ".btn-edit", function () {
                // 目标节点
                var span = $(this).prevAll("span");
                var id = $(this).data("id");
                // 保存文本信息用户回显
                var content = span.text();
                // 清空，并恢复子节点
                span.empty().append(span.children("i"));
                // 回显文本
                span.append('<input type="text" value="' + content + '">')
                span.append('<i class="btn-edit-confirm glyphicon glyphicon-ok"  data-id="' + id + '"></i>')
            });

            $(document).on("click", ".btn-edit-confirm", function (e) {
                var id = $(this).data("id");
                var name = $(this).prev().val();
                network.editCategory(id, name).done(function (result) {
                    if (result["code"] == 0) {
                        window.location.href = "/category/show_list"
                    }
                });
                e.stopPropagation();
            })
        },
        btnDel: function () {
            $(document).on("click", ".btn-del", function () {
                var id = $(this).data("id");
                if(confirm("确定删除吗？")){
                    network.delCategory(id).done(function (result) {
                        if (result["code"] == 0) {
                            window.location.href = "/category/show_list"
                        }
                    });
                }
            })
        },
        btnRootAdd: function () {
            $(document).on("click", "#btn-root-add", function () {
                var name = $(this).prev().val();
                network.addCategory(0,name).done(function (result) {
                    if (result["code"] == 0) {
                        window.location.href = "/category/show_list"
                    }
                });
            })
        }
    }

    var network = {
        getTree: function () {
            var df = $.Deferred();
            $.post("/category/tree", {"_method": "GET"}, function (result) {
                df.resolve(result)
            });
            return df;
        },
        addCategory: function (parentId, name) {
            if (parentId == null || name == null) {
                alert("参数异常");
                return;
            }
            var df = $.Deferred();
            $.post("/category", {"parentId": parentId, "name": name, "_method": "POST"}, function (result) {
                df.resolve(result)
            });
            return df;
        },
        editCategory: function (id, name) {
            if (id == null || name == null) {
                alert("参数异常");
                return;
            }
            var df = $.Deferred();
            // var data = {"name": name, "_method": "PUT"};
            // $.ajax({
            //     type: "PUT",
            //     url: "/category/" + id,
            //     contentType: "application/json; charset=utf-8",
            //     data: JSON.stringify(data),
            //     dataType: "json",
            //     success: function (result) {
            //         df.resolve(result)
            //     },
            // });
            // ajax怎么支持restful，参考https://blog.csdn.net/liuyuanjiang109/article/details/78972644
            var data = {"name": name};
            $.ajax({
                type: "PUT",
                url: "/category/" + id,
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                dataType: "json",
                success: function (result) {
                    df.resolve(result)
                },
            });
            return df;
        },
        delCategory: function (id) {
            var df = $.Deferred();
            // ajax怎么支持restful，参考https://blog.csdn.net/liuyuanjiang109/article/details/78972644
            $.ajax({
                type: "DELETE",
                url: "/category/" + id,
                contentType: "application/json; charset=utf-8",
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