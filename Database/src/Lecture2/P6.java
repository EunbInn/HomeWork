package Lecture2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P6 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34/kopoctc",
				ConstValue.id, ConstValue.pw);
		
		Statement stmt = con.createStatement();
		stmt.execute("create table freewifi("
				+ "inst_place	varchar(50),"
				+ "inst_place_detail	varchar(50),"
				+ "inst_city	varchar(50),"
				+ "inst_country		varchar(50),"
				+ "inst_place_flag 	varchar(50),"
				+ "service_provider		varchar(50),"
				+ "wifi_ssid	varchar(50),"
				+ "inst_date	varchar(50),"
				+ "place_addr_road	varchar(200),"
				+ "place_addr_land	varchar(200),"
				+ "manage_office	varchar(50),"
				+ "manage_office_phone varchar(50),"
				+ "latitude		double,"
				+ "longitude	double,"
				+ "write_date	date);");
		
		con.close();
		stmt.close();

	}

}
