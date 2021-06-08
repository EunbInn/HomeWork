package Lecture2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P6_1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34/kopoctc",
				ConstValue.id, ConstValue.pw);
		
		Statement stmt = con.createStatement();
		stmt.execute("create table freewifi2(" //테이블 생성
				+ "inst_place	varchar(500)," //설치장소명
				+ "inst_place_detail	varchar(500)," //설치장소 상세
				+ "inst_city	varchar(50)," //설치시도명
				+ "inst_country		varchar(50)," //설치시군구명
				+ "inst_place_flag 	varchar(100)," //설치시설 구분
				+ "service_provider		varchar(100)," //서비스제공사명
				+ "wifi_ssid	varchar(500)," //와이파이 ssid
				+ "inst_date	date," //설치년월
				+ "place_addr_road	varchar(200)," //소재지 도로명주소
				+ "place_addr_land	varchar(200)," //소재지지번주소
				+ "manage_office	varchar(50)," //관리기관명
				+ "manage_office_phone varchar(50)," //관리기관전화번호
				+ "latitude		double," //위도
				+ "longitude	double," //경도
				+ "write_date	date);"); //데이터기준일
		
		con.close();
		stmt.close();

	}

}
