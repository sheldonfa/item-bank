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
                题库
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Examples</a></li>
                <li class="active">User profile</li>
            </ol>
        </section>

        <section class="content">
            <!-- 题库目录下拉列表 -->
            <div class="box box-primary">
                <div class="box-body box-profile">
                    <%--select option--%>
                </div>
            </div>

            <div id="question-list-div">
                <c:forEach items="${questions}" var="i" varStatus="s">
                    <div class="box" id="${i.id}">
                        <div class="box-header">
                            <h1>第${s.index+1}题</h1>
                        </div>
                        <div class="box-body">
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="active tab-pane" id="activity">
                                        <!-- Post -->
                                        <div class="post">
                                            <p class="question-md">${i.content}</p>
                                            <form class="form-horizontal">
                                                <div class="form-group margin-bottom-none">
                                                    <div class="col-sm-3">
                                                        <button type="button"
                                                                class="btn btn-primary btn-block btn-sm btn-edit-js">编辑
                                                        </button>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <button type="button" id="${i.id}"
                                                                class="btn btn-danger btn-block btn-sm btn-delete-js">删除
                                                        </button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.tab-content -->
                            </div>
                            <!-- /.nav-tabs-custom -->
                        </div>
                    </div>
                </c:forEach>
            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
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
            // 初始化markdown
            markdowntohtml();
            // 初始化根目录
            var countType = 1;
            network.selectChildCategory(0, countType).done(function (result) {
                if (result["code"] == 0) {
                    dom.insertChildCategory(result["data"], 0);
                }
            })
        }
    }
    var action = {
        bind: function () {
            this.btnEdit();
            this.btnDelete();
            this.changeSelect();
        },
        btnEdit: function () {
            $(".btn-edit-js").click(function () {
                var id = $($(this).parents(".box")[0]).attr("id");
                window.location.href = "${pageContext.request.contextPath}/question/list_edit/" + id;
            })
        },
        /*删除按钮*/
        btnDelete: function () {
            $(".btn-delete-js").click(function () {
                if (confirm("确定要删除吗？")) {
                    $.post("/question/del/" + $(this).attr("id"), function (result) {
                        if (result["code"] == 0) {
                            window.location.href = "/question/list";
                        }
                    });
                }
            })
        },
        changeSelect: function () {
            $(document).on("change", "#sel1,#sel2,#sel3,#sel4,#sel5", function () {
                var level = $(this).data("select-level");
                var id = $(this).val();
                var parentId = $(this).data("parent-id");
                // 根据categoryid查询question列表
                var targetId = id;
                if (targetId == 0) {
                    targetId = parentId;
                }
                network.listQuestion(targetId).done(function (result) {
                    if (result["code"] == 0) {
                        var data = result["data"];
                        $("#question-list-div").empty();
                        for (var i in data) {
                            var e = data[i];
                            var q =
                                '<div class="box" id="' + e.id + '">\n' +
                                '                        <div class="box-header">\n' +
                                '                            <h1>第' + (i + 1) + '题</h1>\n' +
                                '                        </div>\n' +
                                '                        <div class="box-body">\n' +
                                '                            <div class="nav-tabs-custom">\n' +
                                '                                <div class="tab-content">\n' +
                                '                                    <div class="active tab-pane" id="activity">\n' +
                                '                                        <!-- Post -->\n' +
                                '                                        <div class="post">\n' +
                                '                                            <p class="question-md">' + e.content + '</p>\n' +
                                '                                            <form class="form-horizontal">\n' +
                                '                                                <div class="form-group margin-bottom-none">\n' +
                                '                                                    <div class="col-sm-3">\n' +
                                '                                                        <button type="button"\n' +
                                '                                                                class="btn btn-primary btn-block btn-sm btn-edit-js">编辑\n' +
                                '                                                        </button>\n' +
                                '                                                    </div>\n' +
                                '                                                    <div class="col-sm-3">\n' +
                                '                                                        <button type="button" id="' + e.id + '"\n' +
                                '                                                                class="btn btn-danger btn-block btn-sm btn-delete-js">删除\n' +
                                '                                                        </button>\n' +
                                '                                                    </div>\n' +
                                '                                                </div>\n' +
                                '                                            </form>\n' +
                                '                                        </div>\n' +
                                '                                    </div>\n' +
                                '                                </div>\n' +
                                '                                <!-- /.tab-content -->\n' +
                                '                            </div>\n' +
                                '                            <!-- /.nav-tabs-custom -->\n' +
                                '                        </div>\n' +
                                '                    </div>'
                            $("#question-list-div").append(q);
                        }
                    }
                    markdowntohtml()
                });
                if (id != 0) {
                    network.selectChildCategory(id, 1).done(function (result) {
                        if (result["code"] == 0) {
                            dom.insertChildCategory(result["data"], level)
                        }
                    });
                }
            })
        }
    };
    var dom = {
        // 插入子目录节点
        insertChildCategory: function (data, level) {
            var children = data;
            // 有子节点
            if (children.length > 0) {
                var subSelect = $("#sel" + eval(level + 1));
                var newdiv = ' <div class="col-md-2">' +
                    '<select id="sel' + eval(level + 1) + '" data-select-level="' + eval(level + 1) + '" class="form-control" data-parent-id="' + children[0].parentId + '" data-placeholder="选择分类">' +
                    '<option value="0">全部</option>'
                for (var i in children) {
                    newdiv += '                           <option value="' + children[i].id + '">' + children[i].name + "(" + children[i].questionCount + ")" + '</option>'
                }
                newdiv += '</select>' +
                    '</div>';
                // 已经存在这个下拉框
                if (subSelect[0]) {
                    subSelect.parent().before(newdiv);
                    subSelect.parent().remove();
                } else {
                    console.log(newdiv);
                    $("body > div > div > section.content > div.box.box-primary > div").append($(newdiv))
                }
            } else {
                var subSelect = $("#sel" + eval(level + 1));
                if (subSelect[0]) {
                    subSelect.parent().remove();
                }
            }
        }
    }
</script>
<script src="/js/network.js"></script>
<script src="/js/common.js"></script>
</body>
</html>