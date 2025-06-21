# 🎯 Java To-Do List Application

A feature-rich console-based task management application built with Java. This project demonstrates object-oriented programming principles, file I/O operations, and comprehensive task management functionality.

## ✨ Features

### Core Functionality
- ➕ **Add Tasks** - Create tasks with descriptions, priorities, categories, and due dates
- 👀 **View Tasks** - Display all tasks, pending tasks, completed tasks, or overdue tasks
- ✅ **Mark Complete** - Mark tasks as completed with visual indicators
- ✏️ **Edit Tasks** - Modify task descriptions
- 🗑️ **Delete Tasks** - Remove unwanted tasks with confirmation
- 💾 **Auto-Save** - Automatic persistence to file system

### Advanced Features
- 🎯 **Priority System** - High, Medium, Low priorities with color-coded icons
- 📂 **Categories** - Organize tasks by custom categories
- 📅 **Due Dates** - Set due dates and track overdue tasks
- 🔍 **Search & Filter** - Search by keywords, filter by category or status
- 📊 **Statistics** - View completion rates, priority breakdown, and category statistics
- ⚠️ **Overdue Tracking** - Automatic detection and highlighting of overdue tasks

### Technical Features
- 🏗️ **Object-Oriented Design** - Clean separation of concerns
- 📁 **File Persistence** - Data saved to `data/tasks.txt`
- 🛡️ **Error Handling** - Robust input validation and exception handling
- 🎨 **User-Friendly Interface** - Intuitive menu system with emojis and formatting

## 🏗️ Project Structure

```
To-Do_List_App/
├── src/
│   ├── main/
│   │   ├── Task.java          # Task model with properties and methods
│   │   ├── TodoManager.java   # Core business logic and task operations
│   │   ├── FileHandler.java   # File I/O operations for data persistence
│   │   └── Main.java          # Main application with user interface
│   └── test/                  # Test files (for future unit tests)
├── data/
│   └── tasks.txt             # Persistent storage file (auto-created)
└── README.md                 # Project documentation
```

## 🚀 Getting Started

### Prerequisites
- ☕ Java Development Kit (JDK) 8 or higher
- 💻 Command line terminal or IDE (IntelliJ IDEA, Eclipse, VS Code)

### Installation & Execution

1. **Download/Clone the project**
   ```bash
   # If using Git
   git clone <repository-url>
   cd To-Do_List_App
   
   # Or download and extract the ZIP file
   ```

2. **Compile the Java files**
   ```bash
   # Navigate to the src/main directory
   cd src/main
   
   # Compile all Java files
   javac *.java
   ```

3. **Run the application**
   ```bash
   # Run from src/main directory
   java Main
   ```

### Alternative: Using an IDE
1. Open your IDE (IntelliJ IDEA, Eclipse, etc.)
2. Import the project or open the `src/main` folder
3. Right-click on `Main.java` and select "Run"

## 🎮 How to Use

### Main Menu Options
1. **➕ Add New Task** - Create a new task with priority, category, and due date
2. **👀 View Tasks** - Display tasks in various formats
3. **⚙️ Manage Tasks** - Mark complete, edit, or delete tasks
4. **🔍 Search & Filter** - Find specific tasks or view by category
5. **📊 Statistics** - View productivity metrics and task breakdowns
6. **🚪 Exit** - Close the application (auto-saves all data)

### Sample Workflow
1. Start the application
2. Add a few tasks with different priorities and categories
3. Mark some tasks as complete
4. View statistics to see your progress
5. Search for specific tasks
6. Exit (your data is automatically saved)

## 💡 Example Usage

```
🎯 WELCOME TO TODO LIST APP
==================================================
📝 Organize your tasks efficiently!
✅ Mark tasks as complete
🗂️  Categorize and prioritize
📊 Track your productivity
==================================================

🏠 MAIN MENU
------------------------------
1. ➕ Add New Task
2. 👀 View Tasks
3. ⚙️  Manage Tasks
4. 🔍 Search & Filter
5. 📊 Statistics
6. 🚪 Exit
------------------------------
Enter your choice: 1

➕ ADD NEW TASK
--------------------
📝 Enter task description: Complete Java project
🎯 Select Priority:
1. 🔴 HIGH
2. 🟡 MEDIUM
3. 🟢 LOW
Enter priority (1-3): 1
📂 Enter category (optional): Programming
📅 Enter due date (YYYY-MM-DD): 2024-12-31
✅ Task added successfully!
```

## 🛠️ Technical Implementation

### Key Java Concepts Demonstrated
- **Object-Oriented Programming** - Classes, inheritance, encapsulation
- **Collections Framework** - ArrayList, Stream API
- **File I/O** - FileReader, FileWriter, BufferedReader
- **Date/Time API** - LocalDate for due date handling
- **Exception Handling** - Try-catch blocks, custom error messages
- **Enums** - Priority levels with type safety
- **String Manipulation** - Parsing, formatting, validation

### Design Patterns Used
- **Single Responsibility Principle** - Each class has a focused purpose
- **Data Transfer Object** - Task class for data encapsulation
- **Service Layer Pattern** - TodoManager for business logic
- **Separation of Concerns** - UI, business logic, and data access separated

## 📊 Sample Output

```
============================================================
📋 YOUR TASKS
============================================================
[1] ○ PENDING 🔴 Complete Java project [Programming] (Due: 2024-12-31)
[2] ✓ COMPLETED 🟡 Buy groceries [Personal]
[3] ⚠ OVERDUE 🔴 Submit assignment [School] (Due: 2024-06-15)
[4] ○ PENDING 🟢 Read book [Personal] (Due: 2024-07-01)
============================================================
Total: 4 tasks | Completed: 1 | Pending: 3

📊 TASK STATISTICS
========================================
Total Tasks: 4
Completed: 1 (25.0%)
Pending: 3 (75.0%)
Overdue: 1

🎯 BY PRIORITY:
🔴 HIGH: 2
🟡 MEDIUM: 1
🟢 LOW: 1

📂 BY CATEGORY:
Programming: 1
Personal: 2
School: 1
```

## 🎤 Demo Guide for Recruiters

### Preparation Steps
1. **Setup**: Have the application compiled and ready to run
2. **Sample Data**: Prepare 4-5 diverse tasks to demonstrate features
3. **Talking Points**: Prepare explanations for technical decisions

### Demo Script (5-7 minutes)

#### 1. Introduction (30 seconds)
"This is a Java console application I built to demonstrate my programming skills. It's a comprehensive task management system with advanced features like priority handling, due dates, and data persistence."

#### 2. Core Features Demo (2-3 minutes)
- **Add Task**: Show adding a task with priority, category, and due date
- **View Tasks**: Display the formatted task list with icons and status
- **Mark Complete**: Demonstrate completing a task
- **Edit/Delete**: Show task modification capabilities

#### 3. Advanced Features (2-3 minutes)
- **Search**: Search for tasks by keyword
- **Filter**: Show tasks by category or status
- **Statistics**: Display the comprehensive statistics view
- **Overdue Detection**: Show how overdue tasks are highlighted

#### 4. Technical Highlights (1-2 minutes)
- **File Persistence**: Show how data is saved between sessions
- **Error Handling**: Demonstrate input validation
- **Code Structure**: Brief overview of the organized codebase

### Key Talking Points
- **Object-Oriented Design**: "I used separate classes for Task, TodoManager, and FileHandler to maintain clean separation of concerns"
- **Data Persistence**: "Tasks are automatically saved to a file, demonstrating file I/O operations"
- **User Experience**: "I focused on creating an intuitive interface with clear visual indicators"
- **Error Handling**: "The application gracefully handles invalid inputs and edge cases"
- **Scalability**: "The modular design makes it easy to add new features"

## 💰 Cost Analysis

### Development Costs: **$0**
- ✅ Java JDK - Free
- ✅ IDE (IntelliJ Community, Eclipse, VS Code) - Free
- ✅ Git version control - Free
- ✅ GitHub hosting - Free
- ✅ Development tools - Free

### Deployment: **No hosting required**
- ✅ Runs locally on any computer with Java
- ✅ No server costs
- ✅ No domain registration needed
- ✅ No database licensing fees

## 🚀 Execution Instructions

### Method 1: Command Line
```bash
# Step 1: Navigate to project directory
cd To-Do_List_App/src/main

# Step 2: Compile all Java files
javac *.java

# Step 3: Run the application
java Main
```

### Method 2: Using IntelliJ IDEA
```bash
# Step 1: Open IntelliJ IDEA
# Step 2: File → Open → Select "To-Do_List_App" folder
# Step 3: Navigate to src/main/Main.java
# Step 4: Right-click on Main.java → Run 'Main.main()'
```

### Method 3: Using Eclipse
```bash
# Step 1: Open Eclipse
# Step 2: File → Import → Existing Projects into Workspace
# Step 3: Select "To-Do_List_App" folder
# Step 4: Right-click Main.java → Run As → Java Application
```

### Method 4: Using VS Code
```bash
# Step 1: Open VS Code
# Step 2: File → Open Folder → Select "To-Do_List_App"
# Step 3: Install Java Extension Pack if not already installed
# Step 4: Open Main.java and click "Run" button
```

## 🔧 Troubleshooting

### Common Issues

**Issue**: "javac command not found"
**Solution**: Install JDK and ensure JAVA_HOME is set in system PATH

**Issue**: "Could not find or load main class Main"
**Solution**: Ensure you're running from the correct directory (src/main)

**Issue**: Data not persisting
**Solution**: Check if the application has write permissions in the project directory

**Issue**: File not found errors
**Solution**: The application automatically creates the data directory and files

## 🎯 Learning Outcomes

This project demonstrates proficiency in:
- ✅ **Java Fundamentals** - Variables, methods, control structures
- ✅ **Object-Oriented Programming** - Classes, objects, inheritance
- ✅ **Collections Framework** - ArrayList, Stream API
- ✅ **File I/O Operations** - Reading and writing data
- ✅ **Exception Handling** - Try-catch, input validation
- ✅ **Date/Time Handling** - LocalDate API
- ✅ **Software Design** - Clean architecture, separation of concerns
- ✅ **User Experience** - Intuitive interface design
- ✅ **Code Organization** - Modular, maintainable code structure

## 🚀 Future Enhancements

Potential improvements for version 2.0:
- 🖥️ **GUI Version** - JavaFX or Swing interface
- 🗄️ **Database Integration** - SQLite or MySQL support
- 🌐 **Web Version** - Spring Boot web application
- 📱 **Mobile App** - Android version
- 🔔 **Notifications** - Reminder system for due dates
- 📊 **Advanced Analytics** - Productivity tracking and charts
- 👥 **Multi-user Support** - User accounts and shared tasks
- ☁️ **Cloud Sync** - Online backup and synchronization

## 📝 License

This project is created for educational and portfolio purposes. Feel free to use and modify as needed.
