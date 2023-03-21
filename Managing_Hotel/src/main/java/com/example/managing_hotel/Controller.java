package com.example.managing_hotel;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller{

    private static String[] tt;

    public void setInf(String[] tt)
    {
        this.tt = tt;
    }
    public String[] getInf()
    {
        return tt;
    }
    @FXML
    Label tenPhong;
    @FXML
    Label dienTich;
    @FXML
    Label loaiPhong;
    @FXML
    Label tinhTrang;

    @FXML
    public void display()
    {
        tenPhong.setText(tt[0]);
        dienTich.setText(tt[1]);
        loaiPhong.setText(tt[2]);
        tinhTrang.setText(tt[5]);
    }
    public void Them(ActionEvent e) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Them.fxml"));
        AnchorPane root = loader.load();
        Stage themStage = new Stage();
        //themStage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        themStage.setScene(scene);
        themStage.show();

    }

    public void Sua(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sua.fxml"));
        AnchorPane root = loader.load();
        Stage themStage = new Stage();
        //themStage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        themStage.setScene(scene);
        themStage.show();
    }

    public void Xoa(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Xoa.fxml"));
        AnchorPane root = loader.load();
        Stage themStage = new Stage();
        //themStage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        themStage.setScene(scene);
        themStage.show();
    }

    public void timLoai(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TimLoai.fxml"));
        AnchorPane root = loader.load();
        Stage themStage = new Stage();
        //themStage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        themStage.setScene(scene);
        themStage.show();
    }
    public void timGia(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TimGia.fxml"));
        AnchorPane root = loader.load();
        Stage themStage = new Stage();
        //themStage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        themStage.setScene(scene);
        themStage.show();
    }

    public void datPhong(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("datPhong.fxml"));
        AnchorPane root = loader.load();
        Stage themStage = new Stage();
        //themStage = (Stage)((Node)e.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        themStage.setScene(scene);
        themStage.show();
    }
    public void Doanh_Thu(ActionEvent e)
    {
        datPhong a = new datPhong();
        System.out.println(a.getDoanhthu());
    }

}
