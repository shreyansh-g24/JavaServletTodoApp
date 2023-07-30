<%-- 
    Document   : index
    Created on : 12 Jul 2023, 01:22:17
    Author     : sg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,models.TodoItem" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todo App</title>
    </head>
    <body>
        <form method="POST" action="${pageContext.request.contextPath}/TodosServlet">
            <input type="text" name="task" />
            <input type="submit" />
        </form>
            
        <ul>
            <%= request.getAttribute("todoHtml") %>
        </ul>
    </body>
</html>
