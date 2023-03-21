package com.example.managing_hotel;

import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;

public class Connection_SQL {
    private static int soPhong;
    private  static String[][] Phong;

    public Connection_SQL () throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managing_hotel", "haisql", "ngaongo119001190");
        PreparedStatement ps0 = connection.prepareStatement("select count(*) from hotel");
        ResultSet count = ps0.executeQuery();
        count.next();
        soPhong = count.getInt(1);

        Statement statement = connection.createStatement();
        ResultSet infor = statement.executeQuery("select * from hotel");

        int i = 0;
        Phong = new String[soPhong][6];
        while(infor.next())
        {
            Phong[i][0] = infor.getString("Name");
            Phong[i][1] = infor.getString("Dien_Tich");
            Phong[i][2] = infor.getString("Loai");
            Phong[i][3] = infor.getString("NGAY_THUE");
            Phong[i][4] = infor.getString("THOI_GIAN_THUE");
            Phong[i][5] = infor.getString("Trang_Thai");
            i++;
        }
        changeStatus();
    }

    public void changeStatus() throws SQLException
    {
        LocalDate ld = LocalDate.now();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        Date date1 = Date.valueOf(ld);
        c1.setTime(date1);

        String st1 = "available";
        String st2 = "not available";

        for(int i = 0; i < soPhong; i++)
        {
            if (Phong[i][3] == null)
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managing_hotel", "haisql", "ngaongo119001190");
                PreparedStatement ps0 = connection.prepareStatement("update hotel set Trang_Thai = '"+st1+"' where name = '"+Phong[i][0]+"'");
                ps0.executeUpdate();
            }
            else {
                int d = Integer.valueOf(Phong[i][4]);
                Date date2 = Date.valueOf(Phong[i][3]);
                c2.setTime(date2);
                c2.add(Calendar.DATE, d);
                if (c2.before(c1))
                {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managing_hotel", "haisql", "ngaongo119001190");
                    PreparedStatement ps0 = connection.prepareStatement("update hotel set Trang_Thai = '"+st1+"' where name = '"+Phong[i][0]+"'");
                    ps0.executeUpdate();
                }
                else
                {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/managing_hotel", "haisql", "ngaongo119001190");
                    PreparedStatement ps0 = connection.prepareStatement("update hotel set Trang_Thai = '"+st2+"' where name = '"+Phong[i][0]+"'");
                    ps0.executeUpdate();
                }
            }
        }
    }

    public int getSoPhong() {
        return soPhong;
    }

    public String[][] getPhong() {
        return Phong;
    }


    public static void main(String[] args) throws SQLException {
        Connection_SQL a = new Connection_SQL();
    }
}
