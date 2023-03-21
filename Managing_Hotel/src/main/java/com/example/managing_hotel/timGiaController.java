package com.example.managing_hotel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class timGiaController {
    private String[][] tt;
    @FXML
    TextField gtTim;
    @FXML
    Label gtTra;

    public void xacNhan() throws SQLException {
        Connection_SQL a = new Connection_SQL();
        tt = a.getPhong();
        int tim = Integer.valueOf(gtTim.getText());
        String tra = "";
        for(int i = 0; i < a.getSoPhong(); i++)
        {
            double gia = 0;
            if(tt[i][2] == "VIP")
            {
                int sotang = Integer.valueOf(tt[i][0]) / 100;
                gia = 150000 + sotang*500000;
            }
            else
            {
                gia = 100000;
            }
            if(gia <= tim)
            {
                tra += tt[i][0] + " ";
            }
        }
        gtTra.setText(tra);
    }
}
