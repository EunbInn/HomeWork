package Lecture05;
//20210412 ������ ������ ���
public class Lecture5_1 {

	public static void main(String[] args) {//���ο��� ����
		//3�� �� ���� ������ �ϱ� ���� ���� i�� ���� ���� +3���� �ϰ�
		//�ݺ��� ������ ������ ������ ���� 1~9������ ��
		for (int k08_i = 1; k08_i < 10; k08_i += 3) { 
			System.out.printf("*************** *************** ***************\n");//���м� ���
			//�� �ٿ� 3���� ���� �Է��Ͽ� ��� i�� i+1�� i+2�ܾ� ���
			System.out.printf("  ������ %d ��     ������ %d ��     ������ %d ��   \n",k08_i, (k08_i + 1), (k08_i + 2));
			System.out.printf("*************** *************** ***************\n");//���м� ���
			//���� for�� ���� �ִ� ������ ������ i�� ������ ������ ���� ���� 1�� ��
			for (int k08_j = 1; k08_j < 10; k08_j++) { 
				//�ٱ��� for���� ���������� ���� �������� �Է��Ͽ� 3�� ��� j���� �״��, i���� i, i+1, i+2�� �Ͽ� ��� �� ���
				//������ ������ �ϱ� ���� ���ڸ� string�������� ��ȯ�Ͽ� ���
				System.out.printf("  %d x %d = %3.3s     %d x %d = %3.3s     %d x %d = %3.3s \n",
						k08_i, k08_j, (k08_i * k08_j), //i���� * j��
						(k08_i + 1), k08_j, ((k08_i + 1) * k08_j), //i + 1���� * j�� 
						(k08_i + 2), k08_j, ((k08_i + 2) * k08_j) );//i + 2���� * j��
				
			}
			System.out.println();//���� for�� �� �� ������ �ٹٲ�
		}
	}

}