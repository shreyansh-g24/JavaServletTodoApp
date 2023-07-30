/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.TodoItem;

public class TodoItemServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        TodoItem todo = TodoItem.find(Integer.valueOf(request.getParameter("todoId")));
        request.setAttribute("todoId", todo.getId());
        request.setAttribute("todoTask", todo.getTask());
        request.getRequestDispatcher("/WEB-INF/edit.jsp").include(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String todoId = request.getParameter("todoId");
        String todoTask = request.getParameter("todoTask");
        TodoItem.update(Integer.valueOf(todoId), todoTask);
        response.sendRedirect("/JavaServletTodoApp");
    }
}
