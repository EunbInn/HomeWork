package Lecture05;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

//20210412 김은비 영수증 출력
public class Lecture5_4 {

	public static void main(String[] args) {//메인에서 시작
		DecimalFormat k08_df = new DecimalFormat("###,###,###");//decimal format으로 숫자 포맷 지정(콤마출력)
		Calendar k08_cal = Calendar.getInstance();//시스템 날짜를 이용하기 위해 calendar.getInstance() 사용
		SimpleDateFormat k08_sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 날짜 포맷을 영수증에 나올 포맷과 일치시키기
		
		Scanner k08_sc = new Scanner(System.in);//가격을 입력받을 스캐너 오브젝트 생성

		int k08_iTax, k08_iOrigin; //세금과 가격 원가를 저장할 변수 타입 지정 및 선언
		int k08_iPrice = k08_sc.nextInt();//가격을 integer type으로 입력받음
		// price = origin(1 + 0.1)
		// tax = price - origin
		// origin = price / 1.1
		k08_iOrigin = (int) (k08_iPrice / (11.0/10.0));
		//tax의 경우 원가의 10%로 계산하는데, 10%한 값에 소수점 이하 자리가 있을 경우(정수형으로 변환한 값과 비교)와 아닐 경우 계산을 달리한다
		//tax는 소수점 아래 수를 취급하지 않고 +1로 올림하여 받음.
		if ((k08_iPrice / (11.0/10.0) * 0.1) > (int) (k08_iPrice / (11.0/10.0) * 0.1)) {
			k08_iTax = (int) (k08_iOrigin * 0.1) + 1;//소수점 이하 자리가 있을 경우 원가에 10% 곱하여 정수형 변환한 값에 + 1
		} else {
			k08_iTax = (int) (k08_iOrigin * 0.1);//소수점 이하 자리가 없을 경우 원가에 10%곱한 값을 정수형으로 변환
		}


		System.out.printf("신용승인\n");//영수증 최상단 내용 출력
		System.out.printf("%s%18.20s\n", "단말기 : 2N68665898", "전표번호 : 041218");//출력 단말기 번호와 전표번호 출력
		System.out.printf("가맹점 : 한양김치찌개\n");//가게명 출력
		System.out.printf("주  소 : 경기 성남시 분당구 황새울로 351번길 10 , 1층\n");//가게 주소 출력
		System.out.printf("대표자 : 유창신\n");//가게 대표명 출력
		System.out.printf("%s%20.20s\n", "사업자 : 752-53-00558", "TEL : 7055695");//사업자번호 및 매장 전화번호 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");//구분선 출력
		System.out.printf("%s%18.20s 원\n",k08_blank("금    액",10), k08_df.format(k08_iOrigin));//미리 지정해둔 포맷으로 원가 출력
		System.out.printf("%s%18.20s 원\n",k08_blank("부 가 세", 10), k08_df.format(k08_iTax));//미리 지정해둔 포맷으로 세금 출력
		System.out.printf("%s%18.20s 원\n",k08_blank("합    계", 10), k08_df.format(k08_iPrice));//미리 지정해둔 포맷으로 총액 출력(입력받은 금액)
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");//구분선 출력
		System.out.printf("우리카드\n");//이용 카드 출력
		System.out.printf("%s%5.6s\n", "카드번호 : 5387-20**-****-4613(S)", "일시불");//카드번호 및 결제 방식 출력
		System.out.printf("거래일시 : %s\n", k08_sdf.format(k08_cal.getTime()));//미리지정해둔 날짜 타입으로 변환하여 거래일시 시스템 날짜로 출력
		System.out.printf("승인번호 : 70404427\n");//결제 승인번호 출력
		System.out.printf("거래번호 : 357734873739\n");//결제 거래 번호 출력
		System.out.printf("%s%21s\n", "매입 : 비씨카드사", "가맹 : 720068568");//결제 처리 카드사명 및 가맹점 번호 출력
		System.out.printf("알림 : EDC매출표\n");//알림 출력
		System.out.printf("문의 : TEL)1544-4700\n");//문의 번호 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - -\n");//구분선 출력
		System.out.printf("%23s\n", "* 감사합니다 *");//맺음말 출력
		System.out.printf("%39s\n", "표준v2.08_20200212");

	}
	
	public static String k08_blank(String k08_temp, int k08_length) {//스트링 타입과 인티저 타입을 인자로 받고 스트링 타입을 리턴하는 메서드 선언
		if (k08_temp.length() > k08_length) { // 글자 자체의 길이가 인자로 받은 길이보다 클 때
			k08_temp = k08_temp.substring(0,k08_length); // 0-길이 만큼 서브스트링으로 자르기
			
			}
		
		int k08_blank = (k08_length * 2) - k08_temp.getBytes().length;//인자로받은 길이*2 - 바이트길이로 출력할 공백 길이 지정
			

		for (int i = 0; i < k08_blank; i++) { //0~공백길이만큼 반복문 실행
			k08_temp = k08_temp + " ";//오른쪽으로 공백 잇기
		}
		
		return k08_temp; //결과값 리턴
	}

}