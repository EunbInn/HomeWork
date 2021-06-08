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


public class P7_1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

			//jdbc 실행을 위해 module path에 임포트한 jar file의 클래스를 이름으로 찾아 로드
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//커넥션 객체 생성(연결할 db 주소와 id, pw 입력)
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34:3306/kopoctc",
					ConstValue.id, ConstValue.pw);
			Statement stmt = con.createStatement(); //statement 객체 생성
						
			File file = new File("C:\\Users\\inna\\DB_lecture\\전국무료와이파이표준데이터.txt"); //file객체 생성 및 path입력
			 //버퍼드리더 객체생성 읽어올 때 한글이 깨져서 ms949형태로 읽어들임
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "MS949"));
			
			String readtxt; // 스트링 선언
			
			//읽은 값이 없다면 아래 문자열을 출력한 후 프로그램 멈춤
			if ((readtxt = br.readLine()) == null) {
				System.out.printf("빈 파일입니다\n"); 
				return;
			}
			
			String[] field_name = readtxt.split("\t"); //첫번째 줄 읽어서 필드네임 스트링 배열에 저장
			
			
			int LineCnt = 0; //라인 카운트 인티저 선언 및 초기화
			while ((readtxt = br.readLine()) != null) { //null값이 아닌 동안 반복문 계속
 				String[] field = readtxt.split("\t"); //txt file이라 \t으로 스플릿한 값을 스트링 배열에 저장
				String QueryTxt; //쿼리문 저장할 스트링 선언
				field[7] = dateForm(field[7]); // dateFormat 정제 메서드
				if (field[12].equals("")) field[12] = "0"; //12
				if (field[13].equals("")) field[13] = "0"; //인서트 쿼리문 포맷 지정하여 스트링 값으로 저장
					QueryTxt = String.format("insert into freewifi2("
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
				stmt.execute(QueryTxt); //statement로 쿼리문 실행
				System.out.printf("%d번째 항목 Insert OK [%s]\n", LineCnt, QueryTxt); //실행 후 입력내용 출력
				LineCnt++; //라인 카운트 변수 + 1
			}
			
			br.close();
			stmt.close();
			con.close();

	}
	
	public static String dateForm(String inst_date) {
		String ret = ""; //반환할 스트링 선언
		if (inst_date.equals("")) { //인자로 받은 값이 ""와 같다면
			ret = "0001-01-01"; //date 범위의 최소값으로 변수에 저장
		} else {
			//기본적으로 스플릿 1번째 값을 year로 설정
			String year = "20" + inst_date.split("-")[1];
			
			//만약 year값에 문자가 포함되어있다면 year값을 스플릿 0번째 값으로 변경하여 저장
			if (year.contains("J") || year.contains("F") || year.contains("M") || year.contains("A")
					|| year.contains("S") || year.contains("N") || year.contains("D") || year.contains("O")) {
				year = "20" + inst_date.split("-")[0];
			}
			
			String month = "";//스트링 선언 및 초기화
			if (inst_date.contains("Jan")) month = "01-01"; //인자로 받은 문자열에 Jan이 포함되어있다면 month 값에 01-01저장
			if (inst_date.contains("Feb")) month = "02-01"; //인자로 받은 문자열에 Feb이 포함되어있다면 month 값에 02-01저장
			if (inst_date.contains("Mar")) month = "03-01"; //인자로 받은 문자열에 Mar이 포함되어있다면 month 값에 03-01저장
			if (inst_date.contains("Apr")) month = "04-01"; //인자로 받은 문자열에 Apr이 포함되어있다면 month 값에 04-01저장
			if (inst_date.contains("May")) month = "05-01"; //인자로 받은 문자열에 May이 포함되어있다면 month 값에 05-01저장
			if (inst_date.contains("Jun")) month = "06-01"; //인자로 받은 문자열에 Jun이 포함되어있다면 month 값에 06-01저장
			if (inst_date.contains("Jul")) month = "07-01"; //인자로 받은 문자열에 Jul이 포함되어있다면 month 값에 07-01저장
			if (inst_date.contains("Aug")) month = "08-01"; //인자로 받은 문자열에 Aug이 포함되어있다면 month 값에 08-01저장
			if (inst_date.contains("Sep")) month = "09-01"; //인자로 받은 문자열에 Sep이 포함되어있다면 month 값에 09-01저장
			if (inst_date.contains("Oct")) month = "10-01"; //인자로 받은 문자열에 Oct이 포함되어있다면 month 값에 10-01저장
			if (inst_date.contains("Nov")) month = "11-01"; //인자로 받은 문자열에 Nov이 포함되어있다면 month 값에 11-01저장
			if (inst_date.contains("Dec")) month = "12-01"; //인자로 받은 문자열에 Dec이 포함되어있다면 month 값에 12-01저장
			ret = year + "-" + month; //year과 month 저장 값 합치기
		}
		
		return ret; //결과값 리턴
		
	}
	
}
