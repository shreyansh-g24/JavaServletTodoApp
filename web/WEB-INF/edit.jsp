<%-- 
    Document   : edit
    Created on : 31 Jul 2023, 00:12:03
    Author     : sg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.TodoItem" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo App</title>
    </head>
    <body>
        <%
            String todoId = String.valueOf(request.getAttribute("todoId"));
            String todoTask = (String) request.getAttribute("todoTask");
            out.println("<p>" + todoId + ". " + todoTask + "</p>");
        %>
        
        <form method="POST" action="${pageContext.request.contextPath}/deleteTodo">
            <input type="hidden" name="todoId" value="${todoId}" />
            <input type="submit" value="Delete" />
        </form>

        <form method="POST" action="${pageContext.request.contextPath}/todo">
            <input name="todoTask" value="${todoTask}" />
            <input type="hidden" name="todoId" value="${todoId}" />
            <input type="submit" value="Update" />
        </form>
    </body>
</html>
