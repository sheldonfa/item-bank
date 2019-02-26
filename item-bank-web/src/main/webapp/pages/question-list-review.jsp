<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ot" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ot:main title="腾讯首页">
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
</ot:main>