package Lecture2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P9_1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//커넥션 객체 생성(연결할 db 주소와 id, pw 입력)
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34:3306/kopoctc",
				ConstValue.id, ConstValue.pw);
		Statement stmt = con.createStatement(); //statement 객체 생성
		
		double lat = 37.651046682507; //우리 집 위도 더블 변수에 저장
		double lng = 127.32063430997; //우리 집 경도 더블 변수에 저장
		
		String QueryTxt;
		QueryTxt = String.format("select * from park where " 
				+ "SQRT(power(latitude-%f,2) + power(longitude-%f,2)) = "
				+ "(select min(SQRT(power(latitude-%f,2) + power(longitude-%f,2))) from park);",
				lat, lng, lat, lng);
		
//		QueryTxt = "select * from park";
//		QueryTxt = "select * from park where manage_office like '%남양주%'"; 
		ResultSet rs = stmt.executeQuery(QueryTxt);
		
		int cnt = 0;
		while (rs.next()) {
			System.out.printf("[%d]*********************************\n", cnt++);
			System.out.printf("주차장관리번호		: %s\n", rs.getInt(1));
			System.out.printf("주차장명		: %s\n", rs.getString(2)); 
			System.out.printf("경도			: %s\n", rs.getFloat(3)); 
			System.out.printf("위도			: %s\n", rs.getFloat(4));
			System.out.printf("주차장구분		: %s\n", rs.getString(5));
			System.out.printf("주차장유형		: %s\n", rs.getString(6));
			System.out.printf("주차장지번주소		: %s\n", rs.getString(7));
			System.out.printf("주차장도로명주소	: %s\n", rs.getString(8));
			System.out.printf("요금			: %s\n", rs.getString(9));
			System.out.printf("관리기관명		: %s\n", rs.getString(10));
			System.out.printf("관리기관전화번호	: %s\n", rs.getString(11));
			System.out.printf("소재지지역		: %s\n", rs.getString(12));
			System.out.printf("지역코드		: %s\n", rs.getInt(13));
			System.out.printf("수정날짜		: %s\n", rs.getString(14));
			System.out.printf("************************************\n");
			
		}
		
		rs.close(); //result set close
		stmt.close(); //statement close
		con.close(); //connection close
					
	}

}
