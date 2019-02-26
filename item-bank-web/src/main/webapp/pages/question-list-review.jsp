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
                                                <div class="col-sm-3">
                                                    <button type="submit"
                                                            class="btn btn-success btn-block btn-sm">Send
                                                    </button>
                                                </div>
                                                <div class="col-sm-3">
                                                    <button type="submit"
                                                            class="btn btn-danger btn-block btn-sm">Send
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
        markdowntohtml()

        $(".btn-edit-js").click(function () {
            var id = $($(this).parents(".box")[0]).attr("id");
            window.location.href = "${pageContext.request.contextPath}/question/list_edit/" + id;
        })

        /*删除按钮*/
        $(function () {
            $(".btn-delete-js").click(function () {
                if(confirm("确定要删除吗？")){
                    $.post("/question/del/"+$(this).attr("id"),function (result) {
                        if(result["code"]==0){
                            window.location.href = "/question/list";
                        }
                    });
                }
            })
        })
    });

    function markdowntohtml() {
        var converter = new showdown.Converter()
        $(".question-md").each(function () {
            $(this).html(converter.makeHtml($.trim($(this).html())))
        });
    }

</script>
</body>
</html>