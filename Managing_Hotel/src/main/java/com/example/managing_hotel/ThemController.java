package com.example.managing_hotel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class ThemController {

    @FXML
    private TextField tfName;
    @FXML
    private TextField tfDienTich;
    @FXML
    private TextField tfLoaiPhong;

    @FXML
    private AnchorPane scene;
    @FXML
    Stage stage;
    @FXML
    public void xacNhan (ActionEvent e) throws SQLException
    {
        if (tfName.getText() == "" || tfDienTich.getText() == "" || tfLoaiPhong.getText() == "")
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Vui Long Nhap Du Du Lieu");
            alert.showAndWait();
        }
        else
        {
            int a = Integer.valueOf(tfName.getText());
            double b = Integer.valueOf(tfDienTich.getText());
            String c = tfLoaiPhong.getText();

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managing_hotel", "haisql", "ngaongo119001190");
            PreparedStatement ps0 = connection.prepareStatement("insert into hotel (Name, Dien_Tich, Loai) values ( '"+a+"', '"+b+"', '"+c+"');");
            ps0.executeUpdate();

            // logout
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            stage.close();

            Menu restart = new Menu();
            restart.start(new Stage());
        }

    }
}
