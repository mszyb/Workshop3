<%--
  Created by IntelliJ IDEA.
  User: szybka
  Date: 03.05.2022
  Time: 16:55
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
            <form action="/user/add" method="post">
                <table class="table">
                    <tr>
                        <th>Username: <br>
                            <input type="text" name="username" placeholder="Username:">
                        </th>
                    </tr>
                    <tr>
                        <th> Email:<br>
                            <input type="text" name="email" placeholder="Email:">
                        </th>
                    </tr>
                    <tr>
                        <th> Password: <br>
                            <input type="text" name="password" placeholder="Password:">
                            <input type="submit" value="submit">
                        </th>
                </table>
            </form>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<%@ include file="/footer.jsp" %>
