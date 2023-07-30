/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sg
 */
public class TodoItem {
    private Integer id;
    private String task;

    public TodoItem() {};

    public TodoItem(String task){
        this.task = task;
    }
    
    public TodoItem(Integer id, String task) {
        this.id = id;
        this.task = task;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
   
    public void setTask(String task) {
        this.task = task;
    }
    
    public String getTask() {
        return this.task;
    }
    
    public static ArrayList<TodoItem> all() {
        try {
            String URL = "jdbc:postgresql://localhost/java_todo_app";
            String USER = "sg";
            String PASSWORD = "";

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM todos ORDER BY id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<TodoItem> todosList = new ArrayList<>();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String task = rs.getString("task");
                todosList.add(new TodoItem(id, task));
            }

            rs.close();
            stmt.close();
            conn.close();

            return todosList;
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to load the desired class - " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return new ArrayList<>(0);
    }
    
    public static void create(String task) {
        try {
            String URL = "jdbc:postgresql://localhost/java_todo_app";
            String USER = "sg";
            String PASSWORD = "";

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "INSERT INTO todos (task) VALUES ('" + task + "')";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to load the desired class - " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static TodoItem find(Integer id) {
        try {
            String URL = "jdbc:postgresql://localhost/java_todo_app";
            String USER = "sg";
            String PASSWORD = "";

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM todos WHERE id = " + id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            TodoItem todo = new TodoItem();

            while(rs.next()) {
                todo.setId(rs.getInt("id"));
                todo.setTask(rs.getString("task"));
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
            return todo;
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to load the desired class - " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    public static void delete(Integer id) {
        try {
            String URL = "jdbc:postgresql://localhost/java_todo_app";
            String USER = "sg";
            String PASSWORD = "";

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "DELETE FROM todos WHERE id = " + String.valueOf(id);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to load the desired class - " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void update(Integer id, String task) {
        try {
            String URL = "jdbc:postgresql://localhost/java_todo_app";
            String USER = "sg";
            String PASSWORD = "";

            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "UPDATE todos SET task = '" + task + "' WHERE id = " + String.valueOf(id);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to load the desired class - " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
