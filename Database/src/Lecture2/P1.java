package Lecture2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

			Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc 실행 driver 클래스를 이름으로 찾아 로드
			//커넥션 객체 생성(연결할 db 주소와 id, pw 입력)
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34:3306/kopoctc",
					ConstValue.id, ConstValue.pw);
			//statement 객체 생성
			Statement stmt = con.createStatement();
			//statement 객체로 실행한 쿼리문의 결과를 ResultSet에 저장
			ResultSet rs = stmt.executeQuery("show databases;");
			
			while(rs.next()) {
				System.out.println("값 : " + rs.getString(1));
			}
			
			rs.close();
			stmt.close();
			con.close();
	}

}
