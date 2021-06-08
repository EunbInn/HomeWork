package Lecture2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

			//jdbc 실행을 위해 module path에 임포트한 jar file의 클래스를 이름으로 찾아 로드
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//커넥션 객체 생성(연결할 db 주소와 id, pw 입력)
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34:3306/kopoctc",
					ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); //statement 객체 생성
			//statement 객체로 실행한 쿼리문의 결과를 ResultSet에 저장
			stmt.execute("create table examtable2(name varchar(20),"
					+ "studentid int not null primary key, "
					+ "kor int,"
					+ "eng int,"
					+ "mat int);");
			stmt.close();
			con.close();
	
	}

}
