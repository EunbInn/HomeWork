package Lecture2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;


public class P7 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

			//jdbc 실행을 위해 module path에 임포트한 jar file의 클래스를 이름으로 찾아 로드
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//커넥션 객체 생성(연결할 db 주소와 id, pw 입력)
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34:3306/kopoctc",
					ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); //statement 객체 생성
			
			File file = new File("C:\\Users\\inna\\DB_lecture\\전국무료와이파이표준데이터.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "MS949"));
			
			String readtxt;
			
			if ((readtxt = br.readLine()) == null) {
				System.out.printf("빈 파일입니다\n");
				return;
			}
			
			String[] field_name = readtxt.split("\t");
			
			int LineCnt = 0;
			while ((readtxt = br.readLine()) != null) {
				String[] field = readtxt.split("\t");
				String QueryTxt;
				try {
					
					for (int i = 0; i < field.length; i++) {
						if (i != 8 && i != 9) {
							if (field[i].length() > 50) {
								field[i] = field[i].substring(0, 50);
							}	
						}
					}
					
					QueryTxt = String.format("insert into freewifi("
							+ "inst_place, inst_place_detail, inst_city, inst_country, inst_place_flag,"
							+ "service_provider, wifi_ssid,	inst_date,	place_addr_road,"
							+ "place_addr_land, manage_office, manage_office_phone, latitude,"
							+ "longitude, write_date)"
							+ "values ("
							+ "'%s','%s','%s','%s','%s'"
							+ ",'%s','%s','%s','%s',"
							+ "'%s','%s','%s',%s,"
							+ "%s,'%s');",
							field[0], field[1], field[2], field[3], field[4],
							field[5], field[6], field[7], field[8],
							field[9], field[10], field[11], field[12],
							field[13], field[14]);
					stmt.execute(QueryTxt);
					System.out.printf("%d번째 항목 Insert OK [%s]\n", LineCnt, QueryTxt);
					
				} catch (SQLSyntaxErrorException e) {
					field[12] = "0";
					field[13] = "0";
					
					QueryTxt = String.format("insert into freewifi("
							+ "inst_place, inst_place_detail, inst_city, inst_country, inst_place_flag,"
							+ "service_provider, wifi_ssid,	inst_date,	place_addr_road,"
							+ "place_addr_land, manage_office, manage_office_phone, latitude,"
							+ "longitude, write_date)"
							+ "values ("
							+ "'%s','%s','%s','%s',"
							+ "'%s','%s','%s','%s',"
							+ "'%s','%s','%s','%s',%s,"
							+ "%s,'%s');",
							field[0], field[1], field[2], field[3], field[4],
							field[5], field[6], field[7], field[8],
							field[9], field[10], field[11], field[12],
							field[13], field[14]);
					stmt.execute(QueryTxt);
					System.out.printf("%d번째 항목 Insert OK [%s]\n", LineCnt, QueryTxt);
				}
				
				
				LineCnt++;
			}
			
			br.close();
			//statement 객체로 실행한 쿼리문의 결과를 ResultSet에 저장
			
			stmt.close();
			con.close();

	}

}
