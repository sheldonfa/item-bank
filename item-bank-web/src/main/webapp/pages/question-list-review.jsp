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
                    <div class="box">
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
                                                    <div class="col-sm-1">
                                                        <button class="btn-remember btn btn-danger btn-block"
                                                                data-id="${i.id}">
                                                            记得
                                                        </button>
                                                    </div>
                                                    <div class="col-sm-1">
                                                        <button class="btn-not-remember btn btn-block"
                                                                data-id="${i.id}">
                                                            不记得
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
            var countType = 2;
            network.selectChildCategory(0, countType).done(function (result) {
                if (result["code"] == 0) {
                    dom.insertChildCategory(result["data"], 0);
                }
            })
        }
    }
    var action = {
        bind: function () {
            this.btnRemember();
            this.btnNotRemember();
            this.changeSelect();
        },
        btnRemember: function () {
            $(document).on("click", ".btn-remember", function () {
                var id = $(this).data("id");
                network.remember(id, true).done(function (result) {
                    if (result["code"] == 0) {
                        window.location.reload()
                    }
                })
            })
        },
        btnNotRemember: function () {
            $(document).on("click", ".btn-not-remember", function () {
                var id = $(this).data("id");
                network.remember(id, false).done(function (result) {
                    if (result["code"] == 0) {
                        window.location.reload()
                    }
                })
            })
        },
        // 修改类目标签
        changeSelect: function () {
            $(document).on("change", "#sel1,#sel2,#sel3,#sel4,#sel5", function () {
                var target = $(this);
                var level = $(this).data("select-level");
                var id = $(this).val();
                // 根据categoryid查询question列表
                var parentId = $(this).data("parent-id");
                var targetId = id;
                if (targetId == -1) {
                    targetId = parentId;
                }
                // 根据categoryid查询question列表
                network.listReviewQuestion(targetId).done(function (result) {
                    if (result["code"] == 0) {
                        var data = result["data"];
                        $("#question-list-div").empty();
                        for (var i in data) {
                            var e = data[i];
                            var q =
                                ' <div class="box">\n' +
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
                                '                                                    <div class="col-sm-1">\n' +
                                '                                                        <button class="btn-remember btn btn-danger btn-block"\n' +
                                '                                                                data-id="' + e.id + '">\n' +
                                '                                                            记得\n' +
                                '                                                        </button>\n' +
                                '                                                    </div>\n' +
                                '                                                    <div class="col-sm-1">\n' +
                                '                                                        <button class="btn-not-remember btn btn-block"\n' +
                                '                                                                data-id="' + e.id + '">\n' +
                                '                                                            不记得\n' +
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
                // 如果是全部目录，删除子节点
                if (id == -1) {
                    var subSelect = $("#sel" + eval(level + 1));
                    subSelect.parent().remove();
                }
                // 不是全部目录的情况下，查询并更新子节点
                else {
                    network.selectChildCategory(id, 2).done(function (result) {
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
                    '<option value="-1">全部</option>'
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