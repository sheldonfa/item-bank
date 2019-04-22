<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/question/review_list">
                <i class="fa fa-dashboard"></i> <span>首页</span></a>
            </li>

            <!-- 一级菜单 -->
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>题库</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <!--二级菜单-->
                    <li id="question-list-review">
                        <a href="${pageContext.request.contextPath}/question/review_list">
                            <i class="fa fa-circle-o"></i> 待复习
                        </a>
                    </li>
                    <li id="question-list">
                        <a href="${pageContext.request.contextPath}/question/list">
                            <i class="fa fa-circle-o"></i> 查看题库
                        </a>
                    </li>
                    <li id="question-list-add">
                        <a href="${pageContext.request.contextPath}/question/list_add">
                            <i class="fa fa-circle-o"></i> 添加题目
                        </a>
                    </li>
                    <li id="category-list-add">
                        <a href="${pageContext.request.contextPath}/category/show_list">
                            <i class="fa fa-circle-o"></i> 分类管理
                        </a>
                    </li>
                </ul>
            </li>
            <!-- 菜单 /-->
            <security:authorize access="hasAnyAuthority('ROLE_ADMIN')">
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-folder"></i> <span>系统管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li id="user-list">
                        <a href="${pageContext.request.contextPath}/user/show_list/1/5">
                            <i class="fa fa-circle-o"></i> 用户管理
                        </a>
                    </li>
                    <li id="role-setting">
                        <a href="${pageContext.request.contextPath}/role/show_list/1/5">
                            <i class="fa fa-circle-o"></i>
                            角色管理
                        </a>
                    </li>
                    <li id="permission-setting">
                        <a href="${pageContext.request.contextPath}/permission/show_list/1/5">
                            <i class="fa fa-circle-o"></i>
                            权限管理
                        </a>
                    </li>
                    <li id="syslog-setting">
                        <a href="${pageContext.request.contextPath}/syslog/list/1/5">
                            <i class="fa fa-circle-o"></i>
                            访问日志
                        </a>
                    </li>
                </ul>
            </li>
            </security:authorize>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>