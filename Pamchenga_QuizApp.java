package com.pamchenga.quizapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.image.Image;

import java.util.List;


public class Pamchenga_QuizApp extends Application {
    private Quiz quiz;                       //The previous quiz instance
    private List<Question> quizQuestions;   //The questions to be shuffled
    private int Index = 0;
    private int Score = 0;

    //THE ELEMENTS FOR THE INTERFACE
    private Label questionLabel;
    private Button[] OptionBtn = new Button[4];      //Array holding the buttons
    private Label feedback;
    private Label timerLabel;

    //setting the timer
    private  Timeline timeline;
    private int time_Left;


    private Stage mainStage;


    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;

        Image icon = new Image(getClass().getResourceAsStream("/Images/light-bulb.png"));
        primaryStage.getIcons().add(icon);

        Label Home = new Label("Pamchenga Quiz App");
        Button StartButton = new Button("START");
        StartButton.setId("Start");

        VBox startLayout = new VBox(StartButton);
        startLayout.setAlignment(Pos.CENTER);
        Scene startScene = new Scene(startLayout, 500, 600);

        startScene.getStylesheets().add(getClass().getResource("/STYLE.css").toExternalForm());

        StartButton.setOnAction(e -> setupQuizScene());

        primaryStage.setTitle("Pamchenga Quiz App");
        primaryStage.setScene(startScene);
        primaryStage.show();


    }

    private void setupQuizScene(){
        quiz = new Quiz();    //quiz object to input all the availabe questions
        quizQuestions = quiz.getQuestion(10); // the shuffled 10

        //LAYOUT OF THE PROGRAM

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setId("OPTIONS");

        //create the labels
        questionLabel = new Label();

        questionLabel.setId("QUESTIONS");

        questionLabel.setWrapText(true);
        feedback = new Label();
        feedback.setId("FEEDBACK");

        timerLabel = new Label();
        timerLabel.setId("Timer");

        HBox Timer = new HBox(timerLabel);
        Timer.setAlignment(Pos.BOTTOM_LEFT);

        VBox OptionsBox = new VBox(10);

        //STYLING IN TERMS OF SIZE AND SETTING THE EVENTS OF THE OPTION BUTTONS
        for (int i = 0; i < 4; i++){
            OptionBtn[i] = new Button();
            int index = i;
            OptionBtn[i].setOnAction(e->handleAnswer(index));
            OptionBtn[i].setMaxWidth(Double.MAX_VALUE);
            OptionsBox.getChildren().add(OptionBtn[i]);
        }

        root.getChildren().addAll(questionLabel,feedback,OptionsBox,Timer);

        Scene QuizScene = new Scene(root, 500, 600);

        QuizScene.getStylesheets().add(getClass().getResource("/STYLE.css").toExternalForm());
        mainStage.setScene(QuizScene);

        loadQuestion();

    }
    //METHOD TO LOAD THE QUIZ QUESTIONS

    private void loadQuestion() {
        if(Index <  quizQuestions.size()){
            Question q = quizQuestions.get(Index);
            questionLabel.setText((Index + 1) + "." + q.getQuestion());

            for(int i = 0; i < 4; i++){
                OptionBtn[i].setText(q.getOptions().get(i));
                OptionBtn[i].setDisable(false);
            }
            feedback.setText("");

            startTimer(10);
        }

        else{
            showResults();
        }
    }

    //HANDLING THE CORRECTNESS OF THE SELECTED ANSWERS

    private void handleAnswer(int selectedIndex){
        Question current = quizQuestions.get(Index);

        //Checking if the user's answer is similar to the correct answer at the same time setting color

        feedback.getStyleClass().removeAll("correct", "wrong");

        if (current.Check(selectedIndex)){
            Score++;
            feedback.setText("Correct");
            feedback.getStyleClass().add("correct");

        }

        else {
            feedback.setText("Wrong answer.The corect answer is " + current.getCorrectAnswer());
            feedback.getStyleClass().add("wrong");
        }

        for(Button btn : OptionBtn) btn.setDisable(true);   //making the buttons not work

       if (timeline != null){
           timeline.stop();
       }


        //SETTING THE TIME FOR THE TRANSITION FROM ONE QUESTION TO ANOTHER
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1.0));
        pauseTransition.setOnFinished(e-> { Index++; loadQuestion();});
        pauseTransition.play();
    }

    //showing The results
    private void showResults(){


        questionLabel.setText("Quiz Over, Score: " + Score + " / " + quizQuestions.size());
        feedback.setText("Try Again Sometime. Learning never stops");
        feedback.setId("Words");

        for(Button btn : OptionBtn) btn.setVisible(false);

        Button Restart = new Button("Restart");
        Restart.setId("Restart");

        //RESETING THE PROGRAM
        Restart.setOnAction(actionEvent -> {
            Index = 0;
            Score = 0;
            setupQuizScene();});

        Button ExitBtn = new Button("Exit");
        ExitBtn.setId("Exit");
        ExitBtn.setOnAction(actionEvent -> Platform.exit());

        HBox Options = new HBox(20, Restart,ExitBtn);
        Options.setAlignment(Pos.CENTER);

        Label trademark = new Label("© Pamchenga QuizApp™ 2025 by Paul Mongola");
        trademark.setId("TradeMark");

        VBox EndLayout = new VBox(20,questionLabel,feedback,Options,trademark);
        EndLayout.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setCenter(EndLayout);
        root.setBottom(trademark);

        BorderPane.setAlignment(trademark,Pos.BOTTOM_CENTER);

        Scene Exit_Restart_Scene = new Scene(root, 500,600);
        Exit_Restart_Scene.getStylesheets().add(getClass().getResource("/STYLE.css").toExternalForm());

        mainStage.setScene(Exit_Restart_Scene);


    }



    //THE TIMER SETTING

    private void startTimer(int Seconds){
        if(timeline != null){
            timeline.stop();
        }

        time_Left = Seconds;

        timerLabel.setText("Time left: " + time_Left + "s");

        timeline = new Timeline(
                new javafx.animation.KeyFrame(Duration.seconds(1.0), actionEvent -> {
                    time_Left --;
                    timerLabel.setText("Time left: " + time_Left + "s");

                    if(time_Left <= 0){
                        timeline.stop();
                        feedback.setText("Time's up, the correct answer is " + quizQuestions.get(Index).getCorrectAnswer());
                        feedback.getStyleClass().removeAll("correct", "wrong");
                        feedback.getStyleClass().add("wrong");

                        for (Button btn : OptionBtn) btn.setDisable(true);

                        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2.0));
                        pauseTransition.setOnFinished(actionEvent1 -> {Index++;
                        loadQuestion();});
                        pauseTransition.play();
                    }
                })
        );


        timeline.setCycleCount(Seconds);
        timeline.play();
    }

    public static void main(String[] args){
        launch(args);
    }

}


