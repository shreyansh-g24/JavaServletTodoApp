# Todo App

This is a basic Todo App. Users can perform CRUD operations on Todo items.

Demo - https://youtu.be/dKl5z26VCjk

### Development
This app is developed using -
  - Servlet API
  - JSP API
  - Postgresql database
  - Apache Tomcat v10

To develop, follow the following steps -
  1. Clone the repo.
  2. Install Tomcat v10.
  3. Setup your IDE of choice. (I used Netbeans).
  4. Install postgresql.
  5. Setup database using the commands given below.
  6. Build and run the project.

#### Database setup

1. Create database -
```sql
CREATE DATABASE java_todo_app WITH OWNER = myuser;
```

2. Create todos table -
```sql
CREATE TABLE todos (
    id SERIAL PRIMARY KEY NOT NULL,
    task TEXT NOT NULL
);
```

3. Insert some records -
```sql
INSERT INTO todos (task) VALUES ('Task1'), ('Task2');
```
