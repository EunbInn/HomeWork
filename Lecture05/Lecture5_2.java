package Lecture05;
//20210412 김은비 구구단 출력(2)
public class Lecture5_2 {

	public static void main(String[] args) {//메인에서 시작
				//이번엔 1씩 증가함에 따라 한 번씩 개행을 하기 위해 변수 i의 증가 폭을 +1으로 하고
				//반복 범위는 줄 수만큼 1~ 3으로 설정
				for (int k08_i = 1; k08_i < 4; k08_i++) { 
					System.out.printf("*************** *************** ***************\n");//구분선 출력
					//한 줄에 3개씩 직접 입력하여 출력 i단 i+3단 i+6단씩 출력
					System.out.printf("  구구단 %d 단     구구단 %d 단     구구단 %d 단   \n",k08_i, (k08_i + 3), (k08_i + 6));
					System.out.printf("*************** *************** ***************\n");//구분선 출력
					//이중 for문 내에 있는 변수는 범위는 1~9까지 +1씩 증가하도록 설정
					for (int k08_j = 1; k08_j < 10; k08_j++) { 
						//바깥쪽 for문과 마찬가지로 직접 수동으로 입력하여 3줄 출력 j값은 그대로, i값만 i, i+3, i+6로 하여 출력 및 계산
						//오른쪽 정렬을 하기 위해 숫자를 string형식으로 변환하여 출력
						System.out.printf("  %d x %d = %3.3s     %d x %d = %3.3s     %d x %d = %3.3s \n",
								k08_i, k08_j, "" + (k08_i * k08_j), //i단의 * j값
								(k08_i + 3), k08_j, "" + ((k08_i + 3) * k08_j), //i + 3단의 * j값 
								(k08_i + 6), k08_j, "" + ((k08_i + 6) * k08_j) );//i + 6단의 * j값
				
			}
			
			
		}
			
		
	}

}

