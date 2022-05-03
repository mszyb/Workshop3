<%--
  Created by IntelliJ IDEA.
  User: szybka
  Date: 03.05.2022
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
        <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                class="fas fa-download fa-sm text-white-50"></i> Add new user</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Users list: </h6>
        </div>
        <div class="card-body">
            <table class="table">
                <tr>
                    <th>ID:</th>
                    <th>Username:</th>
                    <th>Email:</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.getId()}</td>
                        <td>${user.getUserName()}</td>
                        <td>${user.getEmail()} </td>
                        <td>
                            <a href="/user/edit?id=${user.getId()}">Edit</a>
                            <a href="/user/delete?id=${user.getId()}">Delete</a>
                            <a href="/user/show?id=${user.getId()}">Details</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="/footer.jsp" %>