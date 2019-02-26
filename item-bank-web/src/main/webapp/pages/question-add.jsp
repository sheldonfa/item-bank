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
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>分类</label>
                                    <select class="form-control select2 select2-hidden-accessible" multiple=""
                                            data-placeholder="选择分类" style="width: 100%;" tabindex="-1"
                                            aria-hidden="true" name="categoryId">
                                        <c:forEach items="${categories}" var="i">
                                            <option value="${i.id}">${i.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
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

                    <div class="box-footer">
                        <button type="submit" class="btn">取消</button>
                        <button type="submit" class="btn btn-success">创建</button>
                    </div>
                </div>
            </form>
        </section>
    </div>
    <!-- /.页面内容 -->
    <jsp:include page="common/footer.jsp" />
</div>
<jsp:include page="common/script.jsp"/>
<script>

</script>
</body>
</html>