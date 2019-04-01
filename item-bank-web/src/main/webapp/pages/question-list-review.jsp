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
                    <select class="form-control">
                        <option>option 1</option>
                        <option>option 2</option>
                        <option>option 3</option>
                        <option>option 4</option>
                        <option>option 5</option>
                    </select>
                </div>
            </div>

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
                                                    <button class="btn-not-remember btn btn-block" data-id="${i.id}">
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
            this.markdownFormat()
        },
        markdownFormat: function () {
            markdowntohtml()

            function markdowntohtml() {
                var converter = new showdown.Converter()
                $(".question-md").each(function () {
                    $(this).html(converter.makeHtml($.trim($(this).html())))
                });
            }
        }
    };
    var action = {
        bind: function () {
            this.btnRemember();
            this.btnNotRemember();
        },
        btnRemember: function () {
            $(document).on("click", ".btn-remember", function () {
                var id = $(this).data("id");
                network.remember(id, true).done(function(result){
                    if (result["code"] == 0) {
                        window.location.reload()
                    }
                })
            })
        },
        btnNotRemember: function () {
            $(document).on("click", ".btn-not-remember", function () {
                var id = $(this).data("id");
                network.remember(id, false).done(function(result){
                    if (result["code"] == 0) {
                        window.location.reload()
                    }
                })
            })
        }

    }
    var network = {
        remember: function (id, flag) {
            var df = $.Deferred();
            var data = {
                rememberFlag: flag
            };
            $.ajax({
                type: "PUT",
                url: "/question/" + id + "/remember",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
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