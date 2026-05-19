package com.mycompany.assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Assignment {

    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final Map<String, String> userDatabase = new HashMap<>();
    private final List<String> comments = new ArrayList<>();
    private final List<climatedate> climateData = new ArrayList<>();
    private final List<ClimateNews> climateNews = new ArrayList<>();
    private final List<Ceducation> educationContents = new ArrayList<>();

    private String currentUser;

    public static void main(String[] args) {
        new Assignment().run();
    }

    private void run() {
        seedData();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Climate Change Platform ===");
            System.out.println("1. Public user");
            System.out.println("2. Government user");
            System.out.println("3. Exit");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    showPublicPortal();
                    break;
                case 2:
                    showGovernmentPortal();
                    break;
                case 3:
                    running = false;
                    System.out.println("Thank you for using the platform.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void seedData() {
        climateData.add(new climatedate(1, "28", "Sunny", "2024-07-01"));
        climateData.add(new climatedate(2, "26", "Thunder Shower", "2024-07-02"));
        climateData.add(new climatedate(3, "30", "Cloudy", "2024-07-03"));
        climateData.add(new climatedate(4, "29", "Light Rain", "2024-07-04"));
        climateData.add(new climatedate(5, "27", "Shower", "2024-07-05"));
        climateData.add(new climatedate(6, "31", "Sunny", "2024-07-06"));
        climateData.add(new climatedate(7, "25", "Cloudy", "2024-07-07"));
        climateData.add(new climatedate(8, "28", "Cloudy", "2024-07-08"));
        climateData.add(new climatedate(9, "29", "Sunny", "2024-07-09"));
        climateData.add(new climatedate(10, "29", "Light Rain", "2024-07-10"));

        climateNews.add(new ClimateNews(
                1,
                "Climate change fuelling extreme weather",
                "Global climate change is leading to more extreme weather events such as floods, droughts and heatwaves."
        ));
        climateNews.add(new ClimateNews(
                2,
                "Arctic glaciers melting faster than expected",
                "Arctic glaciers are melting faster than expected, increasing the risk of global sea level rise."
        ));
        climateNews.add(new ClimateNews(
                3,
                "UN climate summit makes important progress",
                "Countries reached a new agreement to reduce carbon emissions and speed up renewable energy adoption."
        ));
        climateNews.add(new ClimateNews(
                4,
                "Forest fires break out again in Australia",
                "Heat and drought have increased forest fire risks and forced thousands of people to evacuate."
        ));
        climateNews.add(new ClimateNews(
                5,
                "Iceland announces plan to become carbon neutral",
                "The Icelandic government aims to make the country carbon neutral by 2050."
        ));

        educationContents.add(new Ceducation(
                1,
                "What is climate change education?",
                "Education that helps people understand climate change and develop effective responses."
        ));
        educationContents.add(new Ceducation(
                2,
                "Climate change education for children",
                "Schools can use activities, projects and discussions to help children learn climate action."
        ));
        educationContents.add(new Ceducation(
                3,
                "Why is climate change education important?",
                "It helps people understand global warming, reduce emissions and adapt to environmental changes."
        ));
    }

    private void showPublicPortal() {
        boolean inPublicPortal = true;

        while (inPublicPortal) {
            if (currentUser == null) {
                System.out.println("\n--- Public User Portal ---");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Back to main menu");

                int choice = readInt("Enter your choice: ");
                switch (choice) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        inPublicPortal = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                showPublicUserMenu();
            }
        }
    }

    private void register() {
        System.out.println("\nRegister");
        String username = readText("Enter username: ");
        String password = readText("Enter password: ");

        if (username.isBlank() || password.isBlank()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        if (userDatabase.containsKey(username)) {
            System.out.println("Username already exists. Please use another username.");
            return;
        }

        userDatabase.put(username, password);
        System.out.println("Registration successful. You can now log in.");
    }

    private void login() {
        System.out.println("\nLogin");
        String username = readText("Enter username: ");
        String password = readText("Enter password: ");

        if (password.equals(userDatabase.get(username))) {
            currentUser = username;
            System.out.println("Login successful. Welcome, " + currentUser + ".");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void showPublicUserMenu() {
        boolean loggedIn = true;

        while (loggedIn && currentUser != null) {
            System.out.println("\n--- Public User Menu ---");
            System.out.println("1. View climate data");
            System.out.println("2. View climate news");
            System.out.println("3. View educational content");
            System.out.println("4. View preventive measures");
            System.out.println("5. View disaster preparation");
            System.out.println("6. Add comment");
            System.out.println("7. View comments");
            System.out.println("8. Logout");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    printClimateData();
                    break;
                case 2:
                    printClimateNews();
                    break;
                case 3:
                    printEducationContents();
                    break;
                case 4:
                    viewPreventiveMeasures();
                    break;
                case 5:
                    viewDisasterPreparation();
                    break;
                case 6:
                    addComment();
                    break;
                case 7:
                    viewComments();
                    break;
                case 8:
                    currentUser = null;
                    loggedIn = false;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showGovernmentPortal() {
        if (!adminLogin()) {
            return;
        }

        boolean inGovernmentPortal = true;
        while (inGovernmentPortal) {
            System.out.println("\n--- Government Menu ---");
            System.out.println("1. Check today's weather");
            System.out.println("2. View climate data");
            System.out.println("3. Add climate data");
            System.out.println("4. Delete climate data");
            System.out.println("5. Edit climate data");
            System.out.println("6. View climate news");
            System.out.println("7. Add climate news");
            System.out.println("8. Delete climate news");
            System.out.println("9. Edit climate news");
            System.out.println("10. View climate education content");
            System.out.println("11. Add climate education content");
            System.out.println("12. Delete climate education content");
            System.out.println("13. Edit climate education content");
            System.out.println("14. Logout");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    checkTodayWeather();
                    break;
                case 2:
                    printClimateData();
                    break;
                case 3:
                    addClimateData();
                    break;
                case 4:
                    deleteClimateData();
                    break;
                case 5:
                    editClimateData();
                    break;
                case 6:
                    printClimateNews();
                    break;
                case 7:
                    addClimateNews();
                    break;
                case 8:
                    deleteClimateNews();
                    break;
                case 9:
                    editClimateNews();
                    break;
                case 10:
                    printEducationContents();
                    break;
                case 11:
                    addEducationContent();
                    break;
                case 12:
                    deleteEducationContent();
                    break;
                case 13:
                    editEducationContent();
                    break;
                case 14:
                    inGovernmentPortal = false;
                    System.out.println("Government user logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private boolean adminLogin() {
        System.out.println("\nAdmin Login");

        for (int attempts = 1; attempts <= 3; attempts++) {
            String username = readText("Enter admin username: ");
            String password = readText("Enter admin password: ");

            if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
                System.out.println("Login successful.");
                return true;
            }

            System.out.println("Incorrect username or password. Attempts left: " + (3 - attempts));
        }

        System.out.println("Too many failed attempts. Returning to main menu.");
        return false;
    }

    private void checkTodayWeather() {
        String[] weatherTypes = {"Sunny", "Rainy", "Cloudy", "Thunder Shower", "Light Rain"};
        String weather = weatherTypes[random.nextInt(weatherTypes.length)];
        int temperature = random.nextInt(21) + 20;
        LocalDate today = LocalDate.now();

        climatedate todayData = new climatedate(nextClimateDataId(), String.valueOf(temperature), weather, today.toString());
        climateData.add(todayData);

        System.out.println("\nToday's Weather Forecast");
        System.out.println("Temperature: " + temperature + " C");
        System.out.println("Weather Condition: " + weather);
        System.out.println("Date: " + today);
        System.out.println("The forecast has been saved into climate data.");
    }

    private void addClimateData() {
        System.out.println("\nAdd Climate Data");
        int id = readInt("Enter data ID: ");
        String temperature = readText("Enter temperature: ");
        String condition = readText("Enter weather condition: ");
        String date = readText("Enter date (yyyy-mm-dd): ");

        if (findClimateDataById(id) != null) {
            System.out.println("This climate data ID already exists.");
            return;
        }

        climateData.add(new climatedate(id, temperature, condition, date));
        System.out.println("Climate data added successfully.");
    }

    private void deleteClimateData() {
        int id = readInt("\nEnter climate data ID to delete: ");
        climatedate data = findClimateDataById(id);

        if (data == null) {
            System.out.println("Climate data not found.");
            return;
        }

        climateData.remove(data);
        System.out.println("Climate data deleted successfully.");
    }

    private void editClimateData() {
        int id = readInt("\nEnter climate data ID to edit: ");
        climatedate data = findClimateDataById(id);

        if (data == null) {
            System.out.println("Climate data not found.");
            return;
        }

        data.setTemp(readText("Enter new temperature: "));
        data.setWeatherConditions(readText("Enter new weather condition: "));
        data.setDatedata(readText("Enter new date: "));
        System.out.println("Climate data updated successfully.");
    }

    private void printClimateData() {
        if (climateData.isEmpty()) {
            System.out.println("\nNo climate data available.");
            return;
        }

        System.out.println("\nClimate Data");
        for (climatedate data : climateData) {
            System.out.println(data);
        }
    }

    private void addClimateNews() {
        System.out.println("\nAdd Climate News");
        int id = readInt("Enter news ID: ");
        String title = readText("Enter news title: ");
        String content = readText("Enter news content: ");

        if (findNewsById(id) != null) {
            System.out.println("This news ID already exists.");
            return;
        }

        climateNews.add(new ClimateNews(id, title, content));
        System.out.println("Climate news added successfully.");
    }

    private void deleteClimateNews() {
        int id = readInt("\nEnter news ID to delete: ");
        ClimateNews news = findNewsById(id);

        if (news == null) {
            System.out.println("Climate news not found.");
            return;
        }

        climateNews.remove(news);
        System.out.println("Climate news deleted successfully.");
    }

    private void editClimateNews() {
        int id = readInt("\nEnter news ID to edit: ");
        ClimateNews news = findNewsById(id);

        if (news == null) {
            System.out.println("Climate news not found.");
            return;
        }

        news.setNewsTitle(readText("Enter new title: "));
        news.setNewscontent(readText("Enter new content: "));
        System.out.println("Climate news updated successfully.");
    }

    private void printClimateNews() {
        if (climateNews.isEmpty()) {
            System.out.println("\nNo climate news available.");
            return;
        }

        System.out.println("\nClimate News");
        for (ClimateNews news : climateNews) {
            System.out.println(news);
        }
    }

    private void addEducationContent() {
        System.out.println("\nAdd Climate Education Content");
        int id = readInt("Enter education ID: ");
        String title = readText("Enter education title: ");
        String content = readText("Enter education content: ");

        if (findEducationById(id) != null) {
            System.out.println("This education ID already exists.");
            return;
        }

        educationContents.add(new Ceducation(id, title, content));
        System.out.println("Education content added successfully.");
    }

    private void deleteEducationContent() {
        int id = readInt("\nEnter education ID to delete: ");
        Ceducation education = findEducationById(id);

        if (education == null) {
            System.out.println("Education content not found.");
            return;
        }

        educationContents.remove(education);
        System.out.println("Education content deleted successfully.");
    }

    private void editEducationContent() {
        int id = readInt("\nEnter education ID to edit: ");
        Ceducation education = findEducationById(id);

        if (education == null) {
            System.out.println("Education content not found.");
            return;
        }

        education.setEducationTitle(readText("Enter new title: "));
        education.setEducationContent(readText("Enter new content: "));
        System.out.println("Education content updated successfully.");
    }

    private void printEducationContents() {
        if (educationContents.isEmpty()) {
            System.out.println("\nNo education content available.");
            return;
        }

        System.out.println("\nClimate Education Content");
        for (Ceducation education : educationContents) {
            System.out.println(education);
        }
    }

    private void viewPreventiveMeasures() {
        System.out.println("\nPreventive Measures");
        System.out.println("1. Reduce greenhouse gas emissions.");
        System.out.println("2. Save electricity and water in daily life.");
        System.out.println("3. Use public transport, cycling or walking when possible.");
        System.out.println("4. Support reforestation and protect natural ecosystems.");
        System.out.println("5. Choose renewable energy and low-carbon products.");
    }

    private void viewDisasterPreparation() {
        System.out.println("\nDisaster Preparation");
        System.out.println("1. Prepare an emergency kit with water, food, flashlight and medicine.");
        System.out.println("2. Keep important documents in a waterproof bag.");
        System.out.println("3. Know local evacuation routes and emergency contacts.");
        System.out.println("4. Follow weather alerts from trusted official sources.");
        System.out.println("5. Make a family communication plan before disasters happen.");
    }

    private void addComment() {
        String comment = readText("\nEnter your comment: ");

        if (comment.isBlank()) {
            System.out.println("Comment cannot be empty.");
            return;
        }

        comments.add(currentUser + ": " + comment);
        System.out.println("Comment added successfully.");
    }

    private void viewComments() {
        if (comments.isEmpty()) {
            System.out.println("\nNo comments available.");
            return;
        }

        System.out.println("\nComments");
        for (String comment : comments) {
            System.out.println("- " + comment);
        }
    }

    private climatedate findClimateDataById(int id) {
        for (climatedate data : climateData) {
            if (data.getDateId() == id) {
                return data;
            }
        }
        return null;
    }

    private ClimateNews findNewsById(int id) {
        for (ClimateNews news : climateNews) {
            if (news.getNewsId() == id) {
                return news;
            }
        }
        return null;
    }

    private Ceducation findEducationById(int id) {
        for (Ceducation education : educationContents) {
            if (education.getEducationID() == id) {
                return education;
            }
        }
        return null;
    }

    private int nextClimateDataId() {
        int maxId = 0;
        for (climatedate data : climateData) {
            maxId = Math.max(maxId, data.getDateId());
        }
        return maxId + 1;
    }

    private int readInt(String prompt) {
        while (true) {
            String input = readText(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
