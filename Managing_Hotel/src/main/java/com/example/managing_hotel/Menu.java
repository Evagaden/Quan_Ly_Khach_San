package com.example.managing_hotel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Menu extends Application {

    public Menu()
    {

    }

    @Override
    public void start(Stage stage){
        try
        {
            //AnchorPane root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            //Controller controller = loader.getController();
            Controller controller = new Controller();
            AnchorPane root = loader.load();

            Image icon = new Image("C:\\For Code\\Java\\Code\\Managing_Hotel\\image\\home.png");

            Connection_SQL sql1 = new Connection_SQL();
            int soPhong = sql1.getSoPhong();
            String[][] Phong = sql1.getPhong();
            Button[] btPhong = new Button[soPhong];
            for(int i = 0; i < soPhong; i++)
            {
                btPhong[i] = new Button(Phong[i][0]);
                btPhong[i].setLayoutX(60 * (Integer.valueOf(Phong[i][0]) % 100) + 120);
                btPhong[i].setLayoutY(80 * (Integer.valueOf(Phong[i][0]) / 100 - 1) + 50);
                btPhong[i].setPrefSize(50,50);

                String[] tt = Phong[i];
                btPhong[i].setOnAction(e -> controller.setInf(tt));
                root.getChildren().add(btPhong[i]);
            }

            stage.setTitle("MANAGING HOTEL PROGRAM");
            stage.getIcons().add(icon);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
