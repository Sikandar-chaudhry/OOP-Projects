package com.example.project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HelloApplication extends Application {
    Scene scene;

    ArrayList<String> credentials = new ArrayList<>();
    University university = new University();
    ArrayList<Employee> employeeUsernamePasswordArrayList=new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    Utils utils = new Utils();
    File file = new File("src/Credentials.txt");
    Campus campus = new Campus();
    ArrayList<Campus> campuses = new ArrayList<>();
    @Override
    public void start(Stage stage) throws IOException {

        loginFile();

        Label welcome  = new Label("Welcome to Administration Portal");
        welcome.setFont(Font.font("Times New Roman",24));

        Label usernameLabel = new Label("Enter Username : ");
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(300);

        Label passwordLabel = new Label("Enter Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(300);

        Button loginButton = new Button("Login");
        Button signUpButton = new Button("Sign Up!");

        Label noUSer = new Label("");

        Image image = new Image("D:/OOP/CoursePractice/JavaFX/Project/src/cui.jpg");
        stage.getIcons().add(image);

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);


        GridPane root = new GridPane();
        root.add(imageView,1,0);
        root.add(welcome,0,1,2,1);
        root.add(usernameLabel,0,2);
        root.add(usernameField,1,2);
        root.add(passwordLabel,0,3);
        root.add(passwordField,1,3);
        root.add(loginButton,1,4);
        root.add(signUpButton,1,5);
        root.add(noUSer,1,7);

        root.setAlignment(Pos.CENTER);
        root.setVgap(10);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                credentials = utils.ReadCredentials(file);

                for (String temp: credentials){
                    String[] credentialsList=temp.split("\t");
                    String username=credentialsList[0];
                    String password=credentialsList[1];
                    String name =credentialsList[2];
                    String grade =credentialsList[3];

                    employeeUsernamePasswordArrayList.add(new Employee(username,password,name,grade));
                    employees.add(new Employee(username,password,name,grade));

                }
                for (Employee employee : employeeUsernamePasswordArrayList){
                    if (usernameField.getText().equals(employee.getUsername())){
                        if (passwordField.getText().equals(employee.getPassword())){
                            noUSer.setText("");
                            login(stage).show();
                            getMenu(stage).show();
                        }
                        break;
                    }
                    else if (usernameField.getText()!=employee.getUsername()){
                        noUSer.setTextFill(Color.RED);
                        noUSer.setText("Wrong Username or Password! ");
                    }
                }
            }
        });
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                signUp(stage).show();
            }
        });

        scene = new Scene(root, 700, 700);
        stage.setTitle("CUI ADMINISTRATION PORTAL");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
    //Function to add three usernames and passwords to new machine .
    public void loginFile (){

        File file = new File("src/Credentials.txt");
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        if (file.length() == 0){
            bufferedWriter.write("admin1");
            bufferedWriter.write("\t");
            bufferedWriter.write("12345");
            bufferedWriter.write("\t");
            bufferedWriter.write("HOD");
            bufferedWriter.write("\t");
            bufferedWriter.write("19");
            bufferedWriter.newLine();
            bufferedWriter.write("admin2");
            bufferedWriter.write("\t");
            bufferedWriter.write("67890");
            bufferedWriter.write("\t");
            bufferedWriter.write("Director");
            bufferedWriter.write("\t");
            bufferedWriter.write("18");
            bufferedWriter.newLine();
            bufferedWriter.write("admin3");
            bufferedWriter.write("\t");
            bufferedWriter.write("13579");
            bufferedWriter.write("\t");
            bufferedWriter.write("Lab Staff");
            bufferedWriter.write("\t");
            bufferedWriter.write("17");
            bufferedWriter.newLine();
        }
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e){
        }

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
    public Stage login (Stage stage) {

        for (Employee employee : employees){
            System.out.println(employee);
        }
        GridPane gridPane = new GridPane();
        Scene scene1 = new Scene(gridPane,700,700);
        stage.setScene(scene1);
        return stage;
    }
    public Stage    signUp (Stage stage ){

        Button backButton = new Button("⬅ Go Back");

        Label signup = new Label("SIGN UP!");
        Label enterUserNameLabel = new Label("Enter Username : ");
        TextField enterUsername = new TextField();
        Label enterPasswordLabel = new Label("Enter Password : ");
        TextField enterPassword = new TextField();
        Label enterNameLabel = new Label("Enter Name : ");
        TextField enterName = new TextField();
        Label enterGradeLabel = new Label("Enter Grade : ");
        TextField enterGrade = new TextField();
        Button saveButton = new Button("Save");
        Label exceptionLabel = new Label();
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {

                    credentials = utils.ReadCredentials(file);

                    for (String temp: credentials){
                        String[] credentialsList=temp.split("\t");
                        String username=credentialsList[0];
                        String password=credentialsList[1];
                        String name =credentialsList[2];
                        String grade =credentialsList[3];

                        employeeUsernamePasswordArrayList.add(new Employee(username,password,name,grade));
                        //employees.add(new Employee(username,password,name,grade));
                    }
                    boolean usernameExists = employeeUsernamePasswordArrayList.stream()
                            .anyMatch(employee -> enterUsername.getText().equals(employee.getUsername()));
                    if (usernameExists) {
                        throw new IllegalArgumentException("Username already taken: " + enterUsername.getText());
                    }
                    FileWriter fileWriter = new FileWriter(file,true);
                    BufferedWriter bufferedWriter  = new BufferedWriter(fileWriter);
                    bufferedWriter.write(enterUsername.getText());
                    bufferedWriter.write("\t");
                    bufferedWriter.write(enterPassword.getText());
                    bufferedWriter.write("\t");
                    bufferedWriter.write(enterName.getText());
                    bufferedWriter.write("\t");
                    bufferedWriter.write(enterGrade.getText());
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                    fileWriter.close();
                    Employee employee = new Employee(enterUsername.getText(),enterPassword.getText(),enterName.getText(),enterGrade.getText());
                    //employeeUsernamePasswordArrayList.add(new Employee(enterUsername.getText(),enterPassword.getText(),enterName.getText(),enterGrade.getText()));
                    employees.add(employee);
                } catch (IllegalArgumentException e){
                    exceptionLabel.setTextFill(Color.RED);
                    exceptionLabel.setText("Username already taken : "+enterUsername.getText());
                } catch (IOException e){
                }
                display();
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.add(backButton,0,0);
        gridPane.add(signup,1,1);
        gridPane.add(enterUserNameLabel,0,2);
        gridPane.add(enterUsername,1,2);
        gridPane.add(enterPasswordLabel ,0,3);
        gridPane.add(enterPassword,1,3);
        gridPane.add(enterNameLabel,0,4);
        gridPane.add(enterName,1,4);
        gridPane.add(enterGradeLabel,0,5);
        gridPane.add(enterGrade,1,5);
        gridPane.add(saveButton,1,6);
        gridPane.add(exceptionLabel,1,7);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        backButton.setOnAction(actionEvent -> {
            stage.setScene(scene);
            stage.show();
        });
        Scene scene1  = new Scene(gridPane,700,700);
        stage.setScene(scene1);
        return stage;
    }
    private Stage getMenu(Stage stage){

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setHgap(10);
        grid.setVgap(10);

        Button button1 = new Button("Add University");
        Button button2 = new Button("Add Campus");
        Button button3 = new Button("Add Department");
        Button button4 = new Button("Add a new Lab");
        Button button5 = new Button("Add a new Computer in lab");
        Button button6 = new Button("Add a new Employee");
        Button button7 = new Button("Search for an Employee");
        Button button8 = new Button("Search for a Lab");
        Button button9 = new Button("Search for a Computer in Lab");
        Button button10 = new Button("Exit the program ");
        Button backButton = new Button("⬅ Go Back");

        grid.getChildren().addAll(button1,button2,button3,button4,button5,button6,button7,button8,button9,button10);
        GridPane.setRowIndex(button1 ,2);
        GridPane.setRowIndex(button2 ,3);
        GridPane.setRowIndex(button3,4);
        GridPane.setRowIndex(button4,5);
        GridPane.setRowIndex(button5,6);
        GridPane.setRowIndex(button6,7);
        GridPane.setRowIndex(button7,8);
        GridPane.setRowIndex(button8,9);
        GridPane.setRowIndex(button9,10);
        GridPane.setRowIndex(button10,11);
        grid.add(backButton,0,12);

        button1.setOnAction(actionEvent -> addUniversity(stage).show());

        button10.setOnAction(actionEvent -> Platform.exit());
        backButton.setOnAction(actionEvent -> {
            stage.setScene(scene);
            stage.show();
        });

        Scene scene = new Scene(grid,700,700);
        stage.setScene(scene);
        return stage;
    }

    public Stage addUniversity (Stage stage){

        Button backButton = new Button("⬅ Go Back");
        Label label = new Label("University Information");
        label.setFont(Font.font("Times New Roman",24));
        Label universityLabel = new Label("Enter University Name : ");
        TextField universityNameField = new TextField();
        universityNameField.setMaxWidth(300);
        Button submit = new Button("Submit");

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10,10,10,10));

        gridPane.add(backButton,0,0);
        gridPane.add(label,1,1);
        gridPane.add(universityLabel,0,2);
        gridPane.add(universityNameField,1,2);
        gridPane.add(submit,0,3);
        Scene scene1 = new Scene(gridPane,700,700);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                university.setUniversityName(universityNameField.getText());
                display();
            }
        });
        backButton.setOnAction(actionEvent -> getMenu(stage).show());

        stage.setScene(scene1);
        return stage;
    }
    public Stage addCampus (Stage stage){

        Button backButton = new Button("⬅ Go Back");

        Label label = new Label("Campus Details");
        Label campusNameLabel = new Label("Enter Campus Name : ");
        Label campusAddressLabel = new Label("Enter Campus Address : ");


        return stage;
    }
}