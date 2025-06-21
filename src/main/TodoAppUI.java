// TodoAppUI.java
package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Arrays;

import java.time.format.DateTimeFormatter;

public class TodoAppUI extends Application {
    private TodoManager todoManager;
    private TableView<Task> taskTable;
    private ObservableList<Task> taskList;
    private Label statsLabel;
    private ComboBox<String> filterComboBox;
    
    @Override
    public void start(Stage primaryStage) {
        todoManager = new TodoManager();
        taskList = FXCollections.observableArrayList();
        
        primaryStage.setTitle("To-Do Application");
        
        // Create main layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        
        // Top section - Title and stats
        VBox topSection = createTopSection();
        root.setTop(topSection);
        
        // Center section - Task table
        VBox centerSection = createCenterSection();
        root.setCenter(centerSection);
        
        // Bottom section - Action buttons
        HBox bottomSection = createBottomSection();
        root.setBottom(bottomSection);
        
        // Create scene and show
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Load initial data
        refreshTaskTable();
    }
    
    private VBox createTopSection() {
        VBox topSection = new VBox(10);
        topSection.setAlignment(Pos.CENTER);
        
        Label titleLabel = new Label("📝 Todo Application");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        
        statsLabel = new Label();
        statsLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #7f8c8d;");
        
        // Filter section
        HBox filterBox = new HBox(10);
        filterBox.setAlignment(Pos.CENTER);
        
        Label filterLabel = new Label("Filter:");
        filterComboBox = new ComboBox<>();
        filterComboBox.getItems().addAll("All Tasks", "Pending", "Completed", "High Priority", "Medium Priority", "Low Priority");
        filterComboBox.setValue("All Tasks");
        filterComboBox.setOnAction(e -> applyFilter());
        
        filterBox.getChildren().addAll(filterLabel, filterComboBox);
        
        topSection.getChildren().addAll(titleLabel, statsLabel, filterBox);
        return topSection;
    }
    
    private VBox createCenterSection() {
        VBox centerSection = new VBox(10);
        
        // Create table
        taskTable = new TableView<>();
        taskTable.setPlaceholder(new Label("No tasks found. Add your first task!"));
        
        // ID Column
        TableColumn<Task, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setPrefWidth(50);
        
        // Title Column
        TableColumn<Task, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.setPrefWidth(200);
        
        // Description Column
        TableColumn<Task, String> descColumn = new TableColumn<>("Description");
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        descColumn.setPrefWidth(250);
        
        // Priority Column
        TableColumn<Task, String> priorityColumn = new TableColumn<>("Priority");
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        priorityColumn.setPrefWidth(100);
        
        // Status Column
        TableColumn<Task, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cellData -> {
            String status = cellData.getValue().isCompleted() ? "✅ Completed" : "⏳ Pending";
            return new javafx.beans.property.SimpleStringProperty(status);
        });
        statusColumn.setPrefWidth(120);
        
        // Created Date Column
        TableColumn<Task, String> dateColumn = new TableColumn<>("Created");
        dateColumn.setCellValueFactory(cellData -> {
            String date = cellData.getValue().getCreatedAt()
                    .format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));
            return new javafx.beans.property.SimpleStringProperty(date);
        });
        dateColumn.setPrefWidth(150);
        
        taskTable.getColumns().addAll(Arrays.asList(
        idColumn, titleColumn, descColumn, priorityColumn, statusColumn, dateColumn));
        taskTable.setItems(taskList);
        
        centerSection.getChildren().add(taskTable);
        return centerSection;
    }
    
    private HBox createBottomSection() {
        HBox bottomSection = new HBox(10);
        bottomSection.setAlignment(Pos.CENTER);
        bottomSection.setPadding(new Insets(10, 0, 0, 0));
        
        Button addButton = new Button("➕ Add Task");
        addButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold;");
        addButton.setOnAction(e -> showAddTaskDialog());
        
        Button editButton = new Button("✏️ Edit Task");
        editButton.setStyle("-fx-background-color: #f39c12; -fx-text-fill: white; -fx-font-weight: bold;");
        editButton.setOnAction(e -> showEditTaskDialog());
        
        Button completeButton = new Button("✅ Toggle Complete");
        completeButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        completeButton.setOnAction(e -> toggleTaskCompletion());
        
        Button deleteButton = new Button("🗑️ Delete Task");
        deleteButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");
        deleteButton.setOnAction(e -> deleteSelectedTask());
        
        bottomSection.getChildren().addAll(addButton, editButton, completeButton, deleteButton);
        return bottomSection;
    }
    
    private void showAddTaskDialog() {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Add New Task");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        TextField titleField = new TextField();
        TextArea descArea = new TextArea();
        descArea.setPrefRowCount(3);
        ComboBox<String> priorityBox = new ComboBox<>();
        priorityBox.getItems().addAll("High", "Medium", "Low");
        priorityBox.setValue("Medium");
        
        grid.add(new Label("Title:"), 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(new Label("Description:"), 0, 1);
        grid.add(descArea, 1, 1);
        grid.add(new Label("Priority:"), 0, 2);
        grid.add(priorityBox, 1, 2);
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        buttonBox.getChildren().addAll(saveButton, cancelButton);
        grid.add(buttonBox, 0, 3, 2, 1);
        
        saveButton.setOnAction(e -> {
            if (!titleField.getText().trim().isEmpty()) {
                todoManager.addTask(titleField.getText().trim(), 
                                  descArea.getText().trim(), 
                                  priorityBox.getValue());
                refreshTaskTable();
                dialog.close();
            } else {
                showAlert("Error", "Title cannot be empty!");
            }
        });
        
        cancelButton.setOnAction(e -> dialog.close());
        
        Scene scene = new Scene(grid, 400, 300);
        dialog.setScene(scene);
        dialog.showAndWait();
    }
    
    private void showEditTaskDialog() {
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask == null) {
            showAlert("No Selection", "Please select a task to edit.");
            return;
        }
        
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Edit Task");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        TextField titleField = new TextField(selectedTask.getTitle());
        TextArea descArea = new TextArea(selectedTask.getDescription());
        descArea.setPrefRowCount(3);
        ComboBox<String> priorityBox = new ComboBox<>();
        priorityBox.getItems().addAll("High", "Medium", "Low");
        priorityBox.setValue(selectedTask.getPriority());
        
        grid.add(new Label("Title:"), 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(new Label("Description:"), 0, 1);
        grid.add(descArea, 1, 1);
        grid.add(new Label("Priority:"), 0, 2);
        grid.add(priorityBox, 1, 2);
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        Button saveButton = new Button("Update");
        Button cancelButton = new Button("Cancel");
        buttonBox.getChildren().addAll(saveButton, cancelButton);
        grid.add(buttonBox, 0, 3, 2, 1);
        
        saveButton.setOnAction(e -> {
            if (!titleField.getText().trim().isEmpty()) {
                todoManager.updateTask(selectedTask.getId(), 
                                     titleField.getText().trim(), 
                                     descArea.getText().trim(), 
                                     priorityBox.getValue());
                refreshTaskTable();
                dialog.close();
            } else {
                showAlert("Error", "Title cannot be empty!");
            }
        });
        
        cancelButton.setOnAction(e -> dialog.close());
        
        Scene scene = new Scene(grid, 400, 300);
        dialog.setScene(scene);
        dialog.showAndWait();
    }
    
    private void toggleTaskCompletion() {
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask == null) {
            showAlert("No Selection", "Please select a task to toggle completion.");
            return;
        }
        
        if (selectedTask.isCompleted()) {
            todoManager.markTaskIncomplete(selectedTask.getId());
        } else {
            todoManager.markTaskCompleted(selectedTask.getId());
        }
        refreshTaskTable();
    }
    
    private void deleteSelectedTask() {
        Task selectedTask = taskTable.getSelectionModel().getSelectedItem();
        if (selectedTask == null) {
            showAlert("No Selection", "Please select a task to delete.");
            return;
        }
        
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Deletion");
        confirmAlert.setHeaderText("Delete Task");
        confirmAlert.setContentText("Are you sure you want to delete this task?");
        
        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                todoManager.removeTask(selectedTask.getId());
                refreshTaskTable();
            }
        });
    }
    
    private void applyFilter() {
        String selectedFilter = filterComboBox.getValue();
        taskList.clear();
        
        switch (selectedFilter) {
            case "All Tasks":
                taskList.addAll(todoManager.getAllTasks());
                break;
            case "Pending":
                taskList.addAll(todoManager.getPendingTasks());
                break;
            case "Completed":
                taskList.addAll(todoManager.getCompletedTasks());
                break;
            case "High Priority":
                taskList.addAll(todoManager.getTasksByPriority("High"));
                break;
            case "Medium Priority":
                taskList.addAll(todoManager.getTasksByPriority("Medium"));
                break;
            case "Low Priority":
                taskList.addAll(todoManager.getTasksByPriority("Low"));
                break;
        }
    }
    
    private void refreshTaskTable() {
        applyFilter();
        updateStats();
    }
    
    private void updateStats() {
        int total = todoManager.getTaskCount();
        int completed = todoManager.getCompletedTaskCount();
        int pending = todoManager.getPendingTaskCount();
        
        statsLabel.setText(String.format("📊 Total: %d | ✅ Completed: %d | ⏳ Pending: %d", 
                                        total, completed, pending));
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}