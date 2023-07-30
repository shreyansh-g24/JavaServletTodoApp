package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Consumer;

import models.TodoItem;

public class TodosServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        ArrayList<TodoItem> todos = TodoItem.all();

        final String[] todoHtml = {""};

        Consumer<TodoItem> generateHtml;
        generateHtml = new Consumer<TodoItem>() {
            @Override
            public void accept(TodoItem todo) {
                todoHtml[0] = todoHtml[0] + "<li>" + todo.getId() + ". " + todo.getTask() + " <a href='/JavaServletTodoApp/todo?todoId=" + todo.getId() + "'>Edit</a></li>";
            };
        };

        todos.forEach(generateHtml);
        request.setAttribute("todoHtml", todoHtml[0]);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
        rd.include(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String task = request.getParameter("task");
        TodoItem.create(task);
        response.sendRedirect("/JavaServletTodoApp");
    }
}
