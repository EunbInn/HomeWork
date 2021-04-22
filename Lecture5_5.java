package Lecture05;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//20210412 김은비 영수증 출력2
public class Lecture5_5 { // 클래스 선언

	public static void main(String[] args) { // 메인에서 시작
		DecimalFormat k08_df = new DecimalFormat("###,###,###"); // 숫자 콤마 출력 양식 설정
		Calendar k08_cal = Calendar.getInstance(); // 요청 즉시 시스템 날짜를 가져오기 위해 Calendar.getInstance 사용
		SimpleDateFormat k08_sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // 심플 데이트 포맷을 이용해 영수증 내에 있었던 것과 동일한 날짜
																				// 양식을 생성
		String k08_itemname1 = "사무용 노트 10묶음 1세트"; // 첫번째 아이템 이름 스트링으로 지정 및 변수에 데이터 저장
		String k08_itemcode1 = "1031617";// 첫번째 아이템코드를 스트링타입으로 지정하고 변수에 데이터 저장
		int k08_price1 = 4000;// 첫번째 아이템의 가격 integer type 선언 및 데이터 저장
		int k08_amount1 = 2;// 첫번째 아이템 integer type으로 선언 및 수량 데이터 저장

		String k08_itemname2 = "땅콩군 파우치(황색) 15cm"; // 두번째 아이템 이름 스트링으로 지정 및 변수에 데이터 저장
		String k08_itemcode2 = "1104042";// 두번째 아이템코드 스트링타입으로 지정하고 변수에 데이터 저장
		int k08_price2 = 1000;// 두번째 아이템의 가격을 integer type으로 선언 및 데이터 저장
		int k08_amount2 = 3;// 두번째 아이템 integer type으로 선언 및 수량 데이터 저장

		String k08_itemname3 = "나뭇가지에 걸린 벗꽃 유화아크릴"; // 세번째 아이템 이름 스트링으로 지정 및 변수에 데이터 저장
		String k08_itemcode3 = "1811019";// 세번째 아이템코드를 스트링타입으로 지정, 변수에 데이터 저장
		int k08_price3 = 2000;// 세번째 아이템의 가격 integer type 선언 및 데이터 저장
		int k08_amount3 = 1;// 세번째 아이템 integer type 선언 및 변수에 수량 데이터 저장

		int k08_sumPrice = k08_price1 + k08_price2 + k08_price3; // integer type의 변수 선언 및 아이템 가격의 총합 저장
		int k08_originPrice = (int) (k08_sumPrice / 1.1); // total price = original price + tax -> tp = orp + (orp *
															// 0.1) -> orp = tp / 1.1
		int k08_taxPrice = k08_sumPrice - k08_originPrice; // tax값 = 총 합 - 총합의 원가

		// tax의 경우 원가의 10%로 계산하는데, 10%한 값에 소수점 이하 자리가 있을 경우(정수형으로 변환한 값과 비교)와 아닐 경우 계산을
		// 달리한다
		// tax는 소수점 아래 수를 취급하지 않고 +1로 올림하여 받는 까닭이다.

		System.out.printf("\n             \"국민가게다이소\"\n"); // 한줄 개행 후 제목부분 출력 큰따옴표는 역슬레시를 사용하여 표현
		System.out.printf("(주)아성다이소_분당서현점\n");// 지점명 출력
		System.out.printf("전화:031-702-6016\n");// 전화번호 출력
		System.out.printf("본사:서울 강남구 남부순환로 2748 (도곡동)\n");// 본사 주소 출력
		System.out.printf("대표:박정부,신호섭 213-81-52063\n");// 대표명과 사업자번호 출력
		System.out.printf("매장:경기도 성남시 분당구 분당로53번길 11 (서현동)\n");// 분당지점의 주소 출력
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("%23s\n%25s\n", "소비자중심경영(CCM) 인증기업", "ISO 9001 품질경영시스템 인증기업"); // 소비자 중심경영과 품질경영시스템 인증 내용 출력
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("      교환/환불 14일(04월26일)이내\n");// 교환, 환불의 가능 기간 출력
		System.out.printf("(전자)영수증, 결제카드 지참 후 구입매장에서 가능\n");// 교환 환불 방법 안내 내용 출력
		System.out.printf("    포장/가격 택 훼손시 교환/환불 불가\n"); // 교환 환불 불가 내용 출력
		System.out.printf("      체크카드 취소 시 최대 7일 소요\n"); // 카드 취소 관련 내용 출력
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("[POS 1058231]%24s\n", k08_sdf.format(k08_cal.getTime()));// 포스 번호와 미리 지정해둔 날짜 포맷으로 날짜 출력
		System.out.printf("=========================================\n");// 구분선 출력
		// blank메서드를 이용하여 아이템 이름을 원하는 글자수만큼 자르고 공백 부여, decimal format 이용하여 단가와 총
		// 가격(단가*수량)에 콤마 포함하여 출력
		System.out.printf("%s%8.8s%4s%9.9s\n", k08_blank(k08_itemname1, 10), k08_df.format(k08_price1), k08_amount1 + "",
				k08_df.format(k08_price1 * k08_amount1));
		System.out.printf("[%s]\n", k08_itemcode1);// 첫번째 아이템코드 출력
		// blank메서드를 이용하여 아이템 이름을 원하는 글자수만큼 자르고 공백 부여, decimal format 이용하여 단가와 총
		// 가격(단가*수량)에 콤마 포함하여 출력
		System.out.printf("%s%8.8s%4s%9.9s\n", k08_blank(k08_itemname2, 10), k08_df.format(k08_price2), k08_amount2 + "",
				k08_df.format(k08_price2 * k08_amount2));
		System.out.printf("[%s]\n", k08_itemcode2);// 두번째 아이템코드 출력
		// blank메서드를 이용하여 아이템 이름을 원하는 글자수만큼 자르고 공백 부여, decimal format 이용하여 단가와 총
		// 가격(단가*수량)에 콤마 포함하여 출력
		System.out.printf("%s%8.8s%4s%9.9s\n", k08_blank(k08_itemname3, 10), k08_df.format(k08_price3), k08_amount3 + "",
				k08_df.format(k08_price3 * k08_amount3));
		System.out.printf("[%s]\n", k08_itemcode3);// 세번째 아이템코드 출력
		System.out.printf("%s%21.20s\n", k08_blank2("과세합계", 10), k08_df.format(k08_originPrice));// 왼쪽 공백출력해주는 blank2메서드로
																								// 과세합계 글자 편집, 원가 합계 출력
		System.out.printf("%s%21.20s\n", k08_blank2("부가세", 10), k08_df.format(k08_taxPrice));// 왼쪽 공백출력해주는 blank2메서드로 부가세
																							// 글자 편집, 원가 합계의 세금 출력
		System.out.printf("-----------------------------------------\n");
		System.out.printf("판매합계%33s\n", k08_df.format(k08_sumPrice));// 지정된 숫자포맷으로 변환하여 총합계금액 출력
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("신용카드%33s\n", k08_df.format(k08_sumPrice));// 신용카드 결제금액은 판매합계와 동일한 금액으로 출력
		System.out.printf("-----------------------------------------\n");
		System.out.printf("우리카드                 538720**********\n");// 카드사 및 카드번호 출력
		System.out.printf("승인번호 77982843(0)%11s %s\n", "승인금액", k08_df.format(k08_sumPrice));// 결제 승인 번호와 승인 금액(판매합계) 출력
		System.out.printf("=========================================\n");// 구분선 출력
		System.out.printf("%24s 분당서현점\n", k08_sdf.format(k08_cal.getTime()));// 지점명과 결제일자 출력
		System.out.printf("상품 및 기타 문의 : 1522-4400\n");// 상품 및 기타문의 번호 출력
		System.out.printf("멤버십 및 샵다이소 관련 문의 : 1599-2211\n\n");// 멤버십 및 다이소 관련 문의 번호 출력
		System.out.printf("           2112820610158231\n");// 바코드 번호 출력
		System.out.printf("-----------------------------------------\n");
		System.out.println(" ◈ 다이소 멤버십 앱 또는 홈페이지에 접속하셔서 회원가입 후 다양한 혜택을 누려보세요! ◈");// 브랜드 홈페이지 및 어플 홍보글 출력

	}

	public static String k08_blank(String k08_temp, int k08_length) { // 스트링 타입과 인티저 타입을 인자로 받고 스트링 타입을 리턴하는 메서드 선언

		if (k08_temp.length() > k08_length) { // 글자 자체의 길이가 인자로 받은 길이보다 클 때
			k08_temp = k08_temp.substring(0, k08_length); // 0-길이 만큼 서브스트링으로 자르기

		}

		int k08_blank = 20 - k08_temp.getBytes().length;// 인자로받은 길이*2 - 바이트길이로 출력할 공백 길이 지정
		for (int i = 0; i < k08_blank; i++) { // 0~공백길이만큼 반복문 실행
			k08_temp = k08_temp + " ";// 오른쪽으로 공백 잇기
		}

		return k08_temp; // 결과값 리턴
	}

	public static String k08_blank2(String k08_temp, int k08_length) {// 스트링 타입과 인티저 타입을 인자로 받고 스트링 타입을 리턴하는 메서드 선언

		if (k08_temp.length() > k08_length) { // 글자 자체의 길이가 인자로 받은 길이보다 클 때
			k08_temp = k08_temp.substring(0, k08_length); // 0-길이 만큼 서브스트링으로 자르기

		}

		int k08_blank = (k08_length * 2) - k08_temp.getBytes().length;// 인자로받은 길이*2 - 바이트길이로 출력할 공백 길이 지정

		for (int i = 0; i < k08_blank; i++) {// 0~공백길이만큼 반복문 실행
			k08_temp = " " + k08_temp;// 왼쪽으로 공백 잇기
		}

		return k08_temp;// 결과값 리턴
	}

}
