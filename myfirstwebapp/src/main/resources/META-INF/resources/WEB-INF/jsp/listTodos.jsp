<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
        <%@ include file="common/header.jsp" %>
        <%@ include file="common/navigation.jsp" %>
        <div class="container">
            <div> Welcome ${name}</div>
            <hr>
            <h1>Your Todos</h1>
            <table class="table">
                <head>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done?</th>
                        <th></th>
                        <th></th>
                    </tr>
                </head>
                <body>
                      <c:forEach items="${todoList}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                            <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                        </tr>
                      </c:forEach>
                </body>
            </table>
            <a href="add-todo" class="btn btn-success">Add todd</a>
        </div>
        <%@ include file="common/footer.jsp" %>