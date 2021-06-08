package Lecture2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P9 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//jdbc 실행을 위해 module path에 임포트한 jar file의 클래스를 이름으로 찾아 로드
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				//커넥션 객체 생성(연결할 db 주소와 id, pw 입력)
				Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34:3306/kopoctc",
						ConstValue.id, ConstValue.pw);
				Statement stmt = con.createStatement(); //statement 객체 생성
				
//				stmt.execute("create table park("
//						+ "park_num	 int not null primary key," //주차장 관리번호가 중복되는 값이 없어 p-key로 지정
//						+ "park_name	varchar(200),"
//						+ "longitude 	double,"
//						+ "latitude		double,"
//						+ "div_park		varchar(50),"
//						+ "type 	varchar(50),"
//						+ "place_addr_road	varchar(300),"
//						+ "place_addr_land	varchar(300),"
//						+ "charge	varchar(50),"
//						+ "manage_office varchar(100),"
//						+ "manage_office_phone varchar(100),"
//						+ "country varchar(50),"
//						+ "country_code int,"
//						+ "write_date	date);");
//				
				File file = new File("C:\\Users\\inna\\DB_lecture\\한국교통안전공단_전국공영주차장정보_20191224.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "MS949"));
				
				String raw;
				
				if ((raw = br.readLine()) == null) {
					System.out.println("빈 파일 입니다");
					return;
				}
				
				String[] field_name = raw.split("\t");
				
				int cnt = 0;
				while ((raw = br.readLine()) != null) {
					String[] field = raw.split("\t");
					String queryT = "";
					String date = "";
					String code = "";
					
					for (int i = 0; i < field.length; i++) {
						if (field[i].contains("'")) {
							field[i] = field[i].replaceAll("'", "");
						}
					}
					
					if (field.length == 25) {
						date = field[24];
						code = field[23];
					} else if (field.length == 24){
						date = "0001-01-01";
						code = field[23];
					} else {
						date = "0001-01-01";
						code = "";
					}
					
					queryT = String.format("insert into park("
							+ "park_num, park_name, longitude, latitude, div_park, type, place_addr_road,"
							+ "place_addr_land, charge, manage_office, manage_office_phone, "
							+ "country, country_code, write_date)"
							+ " values("
							+ "%s,'%s',%s,%s,'%s','%s','%s',"
							+ "'%s','%s','%s','%s',"
							+ "'%s',%s,'%s');",
							field[0],field[1],field[2],field[3],field[4],field[5],field[6],
							field[7],field[16],field[17],code,
							field[18],field[22],date);
					
					stmt.execute(queryT);
					System.out.println(cnt + "번째 데이터 OK_" + queryT);
					cnt++;
				}
			
				stmt.close();
				con.close();
				
				
				
				

	}

}
