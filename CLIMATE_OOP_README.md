# Climate Change OOP Assignment

This is a Java console-based Object-Oriented Programming assignment project.

## Features

- Public user registration and login
- View climate data
- View climate news
- View climate education content
- View preventive measures and disaster preparation advice
- Add and view public user comments
- Government admin login
- Add, edit, delete and view climate data
- Add, edit, delete and view climate news
- Add, edit, delete and view climate education content

## Admin Login

- Username: `admin`
- Password: `admin123`

## Tech Stack

- Java 21
- Maven
- Object-Oriented Programming

## Main Classes

- `Assignment.java`: Main program, menus, login, user functions and government management functions.
- `climatedate.java`: Climate data entity.
- `ClimateNews.java`: Climate news entity.
- `Ceducation.java`: Climate education content entity.

## How To Run

Compile with Java:

```bash
javac -d target/classes src/main/java/com/mycompany/assignment/*.java
```

Run:

```bash
java -cp target/classes com.mycompany.assignment.Assignment
```

If Maven is installed, you can also run:

```bash
mvn compile
mvn exec:java
```
