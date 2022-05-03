<%--
  Created by IntelliJ IDEA.
  User: szybka
  Date: 03.05.2022
  Time: 17:41
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
            <h6 class="m-0 font-weight-bold text-primary">Add new user </h6>
        </div>

        <div class="card-body">
            <table class="table">
                <tr>
                    <th> Id: <br></th>
                    <td>
                        ${user.getId()}
                    </td>
                </tr>
                <tr>
                    <th>Username: <br></th>
                    <td>
                        ${user.getUserName()}
                    </td>
                </tr>
                <tr>
                    <th> Email:<br></th>
                    <td>
                        ${user.getEmail()}
                    </td>
                </tr>

            </table>
            <a href="/user/list">Back</a>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="/footer.jsp" %>
