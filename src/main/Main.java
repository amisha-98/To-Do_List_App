// Main.java
package main;

import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        // Check if JavaFX is available
        try {
            Application.launch(TodoAppUI.class, args);
        } catch (Exception e) {
            System.err.println("JavaFX is not available. Please ensure JavaFX is installed and configured.");
            System.err.println("Error: " + e.getMessage());
            
            // Fallback to console version
            System.out.println("\nStarting console version...");
            startConsoleVersion();
        }
    }
    
    private static void startConsoleVersion() {
        System.out.println("=== Todo Application - Console Version ===");
        TodoManager manager = new TodoManager();
        
        // Add some sample tasks if none exist
        if (manager.getTaskCount() == 0) {
            manager.addTask("Complete project documentation", 
                          "Write comprehensive documentation for the todo application", 
                          "High");
            manager.addTask("Prepare for interview", 
                          "Review common interview questions and practice coding problems", 
                          "High");
            manager.addTask("Update resume", 
                          "Add recent projects and achievements to resume", 
                          "Medium");
            manager.addTask("Learn new framework", 
                          "Explore Spring Boot framework for backend development", 
                          "Low");
        }
        
        // Display tasks
        System.out.println("\nCurrent Tasks:");
        System.out.println("==============");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }
        
        System.out.println("\nStatistics:");
        System.out.println("Total tasks: " + manager.getTaskCount());
        System.out.println("Completed: " + manager.getCompletedTaskCount());
        System.out.println("Pending: " + manager.getPendingTaskCount());
        
        System.out.println("\nNote: For full GUI experience, please install JavaFX and run again.");
    }
}