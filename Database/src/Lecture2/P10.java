package Lecture2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P10 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//커넥션 객체 생성(연결할 db 주소와 id, pw 입력)
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34:3306/kopoctc",
				ConstValue.id, ConstValue.pw);
		Statement stmt = con.createStatement(); //statement 객체 생성
		
//		stmt.execute("create table grade("
//				+ "name varchar(20),"
//				+ "studentid int not null primary key,"
//				+ "kor int,"
//				+ "eng int,"
//				+ "mat int);");
//		
		for (int i = 1; i <= 1000; i++) {
			String name = String.format("김은비%04d", i);
			String id = String.format("2021%04d", i);	
			int korR = (int)(Math.random() * 100);
			int engR = (int)(Math.random() * 100);
			int matR = (int)(Math.random() * 100);
			String QueryTxt = String.format("insert into grade(name, studentid, kor, eng, mat)"
					+ " values('%s', %s, %d, %d, %d);", name, id, korR, engR, matR);
			
			stmt.execute(QueryTxt);
			System.out.println(i + "==>" + QueryTxt);
				
		}
		
	
		stmt.close();
		con.close();
		

	}

}
