package Lecture2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P8 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//jdbc 실행을 위해 module path에 임포트한 jar file의 클래스를 이름으로 찾아 로드
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//커넥션 객체 생성(연결할 db 주소와 id, pw 입력)
		Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.34:3306/kopoctc",
				ConstValue.id, ConstValue.pw);
		Statement stmt = con.createStatement(); //statement 객체 생성
		
		double lat = 37.651046682507; //우리 집 위도 더블 변수에 저장
		double lng = 127.32063430997; //우리 집 경도 더블 변수에 저장
		
		String QueryTxt;//쿼리문을 저장할 스트링 선언
		//피타고라스의 정리를 이용해 두 점 사이의 거리를 구하고 그 중에 minimum 값을 select 하여 출력
//		QueryTxt = String.format("select * from freewifi2 where " 
//				+ "SQRT(power(latitude-%f,2) + power(longitude-%f,2)) = "
//				+ "(select min(SQRT(power(latitude-%f,2) + power(longitude-%f,2))) from freewifi2);",
//				lat, lng, lat, lng);
		
//		QueryTxt = "select * from freewifi2";
//		QueryTxt = "select * from freewifi2 where inst_country='수원시'"; //설치 지역이 수원시인 경우
		QueryTxt = "select * from freewifi2 where service_provider='SKT'"; // 서비스제공이 SKT 인경우
		ResultSet rs = stmt.executeQuery(QueryTxt); //쿼리문 실행 결과 resultset에 저장
		
		int cnt = 0; //cnt 0으로 초기화
		while (rs.next()) {
			System.out.printf("[%d]*********************************\n", cnt++);
			System.out.printf("설치장소명		: %s\n", rs.getString(1)); //1번째 컬럼값 스트링으로 가져오기 - mysql은 1부터시작 주의
			System.out.printf("설치장소상세		: %s\n", rs.getString(2)); //2번째 컬럼값 스트링으로 가져오기
			System.out.printf("설치시도명		: %s\n", rs.getString(3)); //3번째 컬럼값 스트링으로 가져오기
			System.out.printf("설치시군구명		: %s\n", rs.getString(4));//4번째 컬럼값 스트링으로 가져오기
			System.out.printf("설치시설구분		: %s\n", rs.getString(5));//5번째 컬럼값 스트링으로 가져오기
			System.out.printf("서비스제공사명		: %s\n", rs.getString(6));//6번째 컬럼값 스트링으로 가져오기
			System.out.printf("와이파이SSID		: %s\n", rs.getString(7));//7번째 컬럼값 스트링으로 가져오기
			System.out.printf("설치년월		: %s\n", rs.getString(8));//8번째 컬럼값 스트링으로 가져오기
			System.out.printf("소재지도로명주소	: %s\n", rs.getString(9));//9번째 컬럼값 스트링으로 가져오기
			System.out.printf("소재지지번주소		: %s\n", rs.getString(10));//10번째 컬럼값 스트링으로 가져오기
			System.out.printf("관리가관명		: %s\n", rs.getString(11));//11번째 컬럼값 스트링으로 가져오기
			System.out.printf("관리기관전화번호	: %s\n", rs.getString(12));//12번째 컬럼값 스트링으로 가져오기
			System.out.printf("위도			: %s\n", rs.getFloat(13));//13번째 컬럼값 플롯으로 가져오기
			System.out.printf("경도			: %s\n", rs.getFloat(14));//14번째 컬럼값 플롯으로 가져오기
			System.out.printf("데이터기준일자		: %s\n", rs.getDate(15));//15번째 컬럼값 데이트 형식으로 가져오기
			System.out.printf("************************************\n");
			
		}
		
		rs.close(); //result set close
		stmt.close(); //statement close
		con.close(); //connection close
					
	}

}
