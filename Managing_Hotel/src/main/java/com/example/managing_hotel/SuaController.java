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

public class SuaController {

    @FXML
    private TextField tfName;
    @FXML
    private TextField tfDienTich;
    @FXML
    private TextField tfLoai;
    @FXML
    private TextField tfNgayThue;
    @FXML
    private TextField tfThoiGianThue;

    @FXML
    private AnchorPane scene;
    @FXML
    Stage stage;

    @FXML
    public void xacNhan (ActionEvent e) throws SQLException
    {
        int a = Integer.valueOf(tfName.getText());
        double b = Integer.valueOf(tfDienTich.getText());
        String c = tfLoai.getText();
        String d = tfNgayThue.getText();
        int f = Integer.valueOf(tfThoiGianThue.getText());

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managing_hotel", "haisql", "ngaongo119001190");
        PreparedStatement ps0 = connection.prepareStatement("update hotel set Name = '"+a+"', Dien_Tich = '"+b+"', Loai = '"+c+"', NGAY_THUE = '"+d+"', THOI_GIAN_THUE = '"+f+"';");
        ps0.executeUpdate();

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.close();
        Menu restart = new Menu();
        restart.start(new Stage());
    }
    public void ganThongTin()
    {
        Controller controller = new Controller();
        String[] tt = controller.getInf();
        System.out.println(tt[0]);
        tfName.setText(tt[0]);
        tfDienTich.setText(tt[1]);
        tfLoai.setText(tt[2]);
        tfNgayThue.setText(tt[3]);
        tfThoiGianThue.setText(tt[4]);
    }
}
