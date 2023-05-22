package com.example.cui_administration_app2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloApplication extends Application {
    static University university = new University();
    static Campus campus = new Campus();
    static Employee employee = new Employee();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ObservableList<Employee> list = FXCollections.observableArrayList();
    private Stage globalStage;
    private Scene scene;
    @Override
    public void start(Stage stage) throws IOException {

        this.globalStage = stage;
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setHgap(10);
        grid.setVgap(10);

        Label title = new Label(" COMSATS UNIVERSITY LAHORE");
        title.setFont(Font.font("Times New Roman",18));
        grid.getChildren().add(title);
        GridPane.setRowIndex(title,1);
        GridPane.setColumnIndex(title,1);

        TextField universityNameField = new TextField();
        universityNameField.setMaxWidth(300);

        TextField campusNameField = new TextField();
        campusNameField.setMaxWidth(300);
        Button saveBtn = new Button("Save");
        Button btn1 = new Button("Get Menu");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(getMenu(stage).getScene());
            }
        });
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                university.setUniversityName(universityNameField.getText());
                campus.setCampusName(campusNameField.getText());
                display();
            }
        });
        Text universityName = new Text();
        universityName.setText( "Enter University Name : ");
        Text campusName = new Text("Enter Campus Name : ");
        campusName.setText( "Enter Campus Name : ");
        grid.getChildren().add(universityNameField);
        grid.getChildren().add(universityName);
        grid.getChildren().add(campusNameField);
        grid.getChildren().add(campusName);
        grid.getChildren().add(btn1);
        grid.getChildren().add(saveBtn);

        GridPane.setRowIndex(universityNameField,2);
        GridPane.setColumnIndex(universityNameField,1);
        GridPane.setRowIndex(universityName,2);
        GridPane.setColumnIndex(universityName,0);
        GridPane.setRowIndex(campusNameField,3);
        GridPane.setColumnIndex(campusNameField,1);
        GridPane.setRowIndex(campusName,3);
        GridPane.setColumnIndex(campusName,0);
        GridPane.setRowIndex(btn1,5);
        GridPane.setRowIndex(saveBtn,4);
        Image image = new Image("D:/OOP/CoursePractice/JavaFX/cui_administration_app2/src/cui.jpg");
        stage.getIcons().add(image);

        scene = new Scene(grid, 700, 700);
        stage.setTitle("COMSATS ADMINISTRATION APP");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    private Stage getMenu(Stage stage){

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setHgap(10);
        grid.setVgap(10);

        Button button1 = new Button("Add a new Employee");
        Button button2 = new Button("Add a new Computer in lab");
        Button button3 = new Button("Add a new Lab");
        Button button4 = new Button("Search for an Employee");
        Button button5 = new Button("Search for a Lab");
        Button button6 = new Button("Search for a Computer in Lab");
        Button button7 = new Button("Exit the program ");
        Button backButton = new Button("⬅ Go Back");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                addEmployee(stage).show();
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                searchEmployee(stage).show();
            }
        });
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                globalStage.setScene(scene);
            }
        });

        grid.getChildren().addAll(button1,button2,button3,button4,button5,button6,button7);
        GridPane.setRowIndex(button1 ,2);
        GridPane.setRowIndex(button2 ,3);
        GridPane.setRowIndex(button3,4);
        GridPane.setRowIndex(button4,5);
        GridPane.setRowIndex(button5,6);
        GridPane.setRowIndex(button6,7);
        GridPane.setRowIndex(button7,8);
        grid.add(backButton,0,9);


        Scene scene = new Scene(grid,500,500);
        stage.setScene(scene);
        return stage;
    }

    private void setScene(Scene scene){
        globalStage.setScene(scene);
    }
    public static void display()
    {
        Stage popupwindow=new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Confirmation Box ");

        Label label1= new Label("Saved!");
        label1.setFont(Font.font("Times New Roman",22));
        Button button1= new Button("Okay");
        button1.setFont(Font.font("Times New Roman",18));

        button1.setOnAction(e -> popupwindow.close());

        VBox layout= new VBox(10);

        layout.getChildren().addAll(label1, button1);
        layout.setAlignment(Pos.CENTER);

        Scene scene1= new Scene(layout, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }
    private Stage addEmployee(Stage stage){
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        root.setPadding(new Insets(20,20,20,20));

        Label title = new Label();
        title.setText("Enter Employee Data ");
        title.setFont(Font.font("Times New Roman",20));
        Text name = new Text();
        name.setText("Enter Employee Name : ");
        TextField nameField = new TextField();
        nameField.setMaxWidth(300);

        Text grade = new Text();
        grade.setText("Select Grade of Employee : ");
        ComboBox<String> grades = new ComboBox<String>();
        grades.getItems().add("17");
        grades.getItems().add("18");
        grades.getItems().add("19");
        grades.getItems().add("20");
        grades.getItems().add("21");

        Button btn = new Button();
        btn.setText(" Submit ");
        Button backButton = new Button();
        backButton.setText("⬅ Go Back");
        Label noGradeSelected = new Label();
        noGradeSelected.setFont(Font.font("Times New Roman",20));

        TableView tableView = new TableView();
        TableColumn<Employee ,String> employeeNameColumn = new TableColumn<>("Employee Name");
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        employeeNameColumn.setPrefWidth(150);

        TableColumn<Employee, String> employeeGradeColumn = new TableColumn<>("Employee Grade");
        employeeGradeColumn.setCellValueFactory(new PropertyValueFactory<Employee ,String>("grade"));
        employeeGradeColumn.setPrefWidth(150);

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(320,200);
        scroll.setContent(tableView);

        tableView.setItems(list);

        tableView.getColumns().addAll(employeeNameColumn,employeeGradeColumn);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                employee.setName(nameField.getText());
                employee.setGrade(grades.getValue());
                String name = nameField.getText();
                String grade = grades.getValue();
                Employee employee1 = new Employee(name,grade);
                list.add(employee1);
                employees.add(employee1);
                if(grades.getValue()==null){
                    noGradeSelected.setText("Please select a grade ");
                }
                else if (grades.getValue()!=null){
                    noGradeSelected.setText("");
                }
                //For Loop just for testing
                for (Employee employee2 : employees){
                    System.out.println(employee2);
                }
            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getMenu(stage).show();
            }
        });

        root.add(backButton,0,0);
        root.add(title,0,1);
        root.add(scroll,0,2,2,1);
        root.add(name,0,3);
        root.add(nameField,3,3);
        root.add(grade,0,4);
        root.add(grades,0,5);
        root.add(btn,0,6);
        root.add(noGradeSelected,0,7);
        Scene scene = new Scene(root,700,700);
        stage.setScene(scene);
        return stage;
    }
    private Stage searchEmployee(Stage stage){

        Label title = new Label();
        title.setText("Search for an Employee");
        title.setFont(Font.font("Times New Roman",20));
        Label lb1 = new Label();
        lb1.setText("Enter Employee Name : ");
        TextField enterName = new TextField();
        enterName.setMaxWidth(300);
        Label foundEmployee = new Label();
        foundEmployee.setFont(Font.font("Times New Roman ",14));

        Button button = new Button("Search");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (Employee employee1 : employees){
                    if (enterName.getText().equals(employee1.getName())){
                        foundEmployee.setTextFill(Color.BLACK);
                        foundEmployee.setText("Employee "+ employee1.getName() + ", Grade = "+employee1.getGrade());
                    break;
                    }
                    else if (enterName.getText()!=employee1.getName()){
                        foundEmployee.setText("Employee Not Found ! ");
                        foundEmployee.setTextFill(Color.RED);
                    }
                }
            }
        });

        GridPane root = new GridPane();
        root.setPadding(new Insets(20,20,20,20));
        root.setVgap(10);
        root.setHgap(10);
        Button backButton = new Button();
        backButton.setText("⬅ Go Back");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                getMenu(stage).show();
            }
        });
        root.add(title,1,2);
        root.add(lb1,0,3);
        root.add(enterName,1,3);
        root.add(button,0,4);
        root.add(foundEmployee,0,5);
        root.add(backButton,0,1);
        Scene scene = new Scene(root, 500,500);
        stage.setScene(scene);
        return stage;
    }
}