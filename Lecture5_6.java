package Lecture05;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//20210415 ������ �̸�Ʈ ������ ���
public class Lecture5_6 {//Ŭ��������
	
	public static void main(String[] args) {//���ο��� ����
		Calendar k08_cal = Calendar.getInstance();//�ý��� ��¥�� �ޱ����� calendar getinstance �� �̿�
		SimpleDateFormat k08_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //������ ��¥ ������ �����Ͽ� ���� ����
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###");//������ ���ڸ����� �޸��� ������ֱ� ���� ���� ���� ����
		String[] k08_itemName = {"����Ʈ�� ���� �ø������","���� ��ġ����","���ֳ��� �Ҹ�â����","��ũ���ڸ��鷻 500g","�︳ ������ ��� �Ļ�",
							"�Ĺ����� �ٵ���� �󺥴� 200ml","��Ǯ���ű� ���� ���͸�","����Ĩ �����򷯽���","��ī�ݶ� �����ݶ� 330ml",
							"�Ͼᳪ�� ����������(�׸� ����Ʈ) 30��","�������ݸ� ���ϵ�(����)","�������� �ø��� ���ø�ο�","���� ������ 24��","���������� 12��",
							"Ȩ���� ���� ������(������)","�۷����� ���� ������","�������� ������(���ο�)","�۷θ��� ������",
							"Ŭ���Ͽ콺 ���ڷ� ��� 100cm","���� ���� ���û�� 200ml","8�� ������ (2m)","���ϴ� ��Ʈ�κ��� 500ml","�׶� ���� 500ml",
							"s","�����Ѽ��� �������� m","���� ���� ������","��� �Ҵߺ����� 5����","����� ���Ѹ� 5����",
							"���ѱ� 3��ī�� ���Ѹ�","���ѱ� 3��¥��","LG���������� �繮��","�̽� ��ä�� ��Ʈ 100g"}; //��Ʈ�� �迭�� 30�� �̻��� �����۸� �Է�
		int[] k08_itemPrice = {3000,2000,7300,5600,3000,
							7250,12000,3400,1200,21000,
							1500,5000,5620,4560,1200,7200,
							8200,3250,7000,21000,9180,
							1500,1600,4500,5700,1420,5500,
							7200,1200,1200,9990000,550}; //��Ƽ�� �迭�� ��Ʈ�� �迭�� ������ ũ��� �������� �� �Է�
		int[] k08_itemNum = {1,1,3,1,3,1,2,3,2,1,//��Ƽ�� �迭�� ��Ʈ�� �迭�� ������ ũ��� ������ ���� �Է�
						2,2,1,2,1,2,4,3,1,2,
						1,3,2,4,1,2,1,2,4,2,3,1};
		boolean[] k08_TaxFree = {true,true,false,true,false,true,false,true,true,true,// �Ҹ� �迭�� ��Ʈ�� �迭�� ������ ũ��� true false �Է� -> �ش� ���� �鼼, ���� �׸� ������ ����
				true,true,false,true,true,true,true,true,true,true,
				true,true,false,true,true,true,true,true,true,true,true,false};
		int k08_origin = 0; //origin price ��Ƽ�� Ÿ�� ���� �� �ʱ�ȭ 
		int k08_tax = 0;//tax ��Ƽ�� Ÿ�� ���� �� �ʱ�ȭ
		
		
		
		System.out.printf("             �̸�Ʈ ������ (031)888-1234\n"); //���� �� ���� ��ȣ ���
		System.out.printf("    emart    206-86-50913 ����\n");//�̸�Ʈ ����ڹ�ȣ �� ��ǥ�ڸ� ���
		System.out.printf("             ���� ������ ������� 552\n");//���� �ּ� ���
		System.out.printf("\n������ �������� ��ȯ/ȯ�� �Ұ�\n");//ȯ�� �Ұ����� ���
		System.out.printf("�����ǰ�� ����, 30�� �̳�(�ż� 7��)\n");//ȯ�� �Ⱓ �ȳ� ���
		System.out.printf("���Ϻ� �귣����� ����(���� ����������)\n");//���ܸ��� ���� ���
		System.out.printf("��ȯ/ȯ�� ���������� ����(����ī�� ����)\n");//��ȯȯ�� ��� ���
		System.out.printf("\n[����]%15.20s%19.20s\n", k08_sdf.format(k08_cal.getTime()), "POS:0011-9861");//�����ϰ� ���� ��Ϲ�ȣ ���
		System.out.printf("-----------------------------------------\n");//���м� ���
		System.out.printf("  ��ǰ��              �ܰ�  ����     �ݾ�\n");//�� ���� ī�װ� ���
		System.out.printf("-----------------------------------------\n");//���м� ���
		int k08_sumNoTax = 0;//������׸� �� ���� ���� ��Ƽ���� ����
		int k08_sumTax = 0;//�����׸� �� ���� ���� ��Ƽ���� ���� 
		int k08_cnt = 0;
		for (int k08_i = 0; k08_i < k08_itemName.length; k08_i++) { //0~��ǰ�� ������ ��Ʈ�� �迭 ũ�⸸ŭ �ݺ��� ����
			String k08_taxCheck = "";//��Ʈ�� ���� ���� �� �ʱ�ȭ
			k08_cnt++;
			if (k08_TaxFree[k08_i] == false) {//�Ҹ� �迭 tax free�� i��° ���尪�� false�϶�
				k08_taxCheck = "* " + k08_itemName[k08_i];//������ �̸� �տ� * �߰�
				k08_sumNoTax += k08_itemPrice[k08_i];//no tax �հ� �� ����
				
			} else {//�Ҹ� �迭 tzx free�� i��° ���� ���� true�� ��,
				k08_taxCheck = "  " + k08_itemName[k08_i];//������ �̸� �տ� ���� �߰�(*���� ���� ���̸� ���߱� ����)
				k08_sumTax += k08_itemPrice[k08_i];//tax�׸� �հ谪 ����
			}
			//��ǰ��, �ܰ�, ����, �ݾ� ���(�ݾװ� ���õ� ���ڴ� �̸� �����ص� �޸� �߰� �������� �����Ͽ� ���
			int k08_length = 0;
			int k08_blank = 0;
			if (k08_df.format(k08_itemPrice[k08_i]).length() > 8) {
				k08_length = 10;
				k08_blank = 17;
				System.out.printf("%s%11.10s%2.3s%11.10s\n",strForm(k08_taxCheck, k08_length, k08_blank), 
						k08_df.format(k08_itemPrice[k08_i]), k08_itemNum[k08_i] + "", k08_df.format(k08_itemPrice[k08_i] * k08_itemNum[k08_i]));
			}
			else {
				k08_length = 11;
				k08_blank = 19;
				System.out.printf("%s%9.10s%2.3s%11.10s\n",strForm(k08_taxCheck, k08_length, k08_blank), 
						k08_df.format(k08_itemPrice[k08_i]), k08_itemNum[k08_i] + "", k08_df.format(k08_itemPrice[k08_i] * k08_itemNum[k08_i]));
			}
			
			
			if ((k08_i + 1) % 5 == 0) {//i + 1�� 5�� ���� ������ ���� 0�� ��, ���м��� �ٹٲ� ���
				System.out.printf("-----------------------------------------\n");
			}
			
		}
		
		
		k08_origin = (int)(k08_sumTax / (11.0/10.0));//�����׸� �������� 1.1�� ���� ���� ���� ������ ����
		k08_tax = k08_sumTax - k08_origin;//���� = �Ѿ� - ����
		int k08_totalSum = k08_sumNoTax + k08_sumTax;//total sum ������ ������׸� ���ݰ� �����׸� ���� �������� �� ����
		
		System.out.printf("\n%23.25s%13.12s\n","�� ǰ�� ����", k08_cnt + "");//�� ��ǰ ������ ��Ʈ�� �迭�� ���̷� ���
		System.out.printf("%24.25s%13.12s\n","(*)�� ��  �� ǰ", k08_df.format(k08_sumNoTax));//�鼼�׸� ������ ���
		System.out.printf("%24.25s%13.12s\n","�� ��  �� ǰ", k08_df.format(k08_origin));//�����׸� ���� ���
		System.out.printf("%25.25s%13.12s\n","��   ��   ��", k08_df.format(k08_tax));//�����׸��� ���� ���
		System.out.printf("%26.25s%13.12s\n","��        ��", k08_df.format(k08_totalSum));//�հ迡 �� �ݾ� ���
		System.out.printf("  �� �� �� �� �� ��%22.20s\n", k08_df.format(k08_totalSum));// ���� ��� �ݾ׿� �հ�� �����ϰ� �� �ݾ� ���
		System.out.printf("-----------------------------------------\n");//���м� ���
		System.out.printf("0012 KEB �ϳ�       541707**0484/35860658\n");//���� ī�� ���� ���
		System.out.printf("ī�����(IC)%15.20s/%10.10s\n","�Ͻú�",k08_df.format(k08_totalSum));//���� ��� ���
		System.out.printf("-----------------------------------------\n");//���м� ���
		System.out.printf("          [�ż��� ����Ʈ ����]\n");//����Ʈ �������� ���
		System.out.printf("��*�� ������ ����Ʈ ��Ȳ�Դϴ�.\n");//����Ʈ ���� �ȳ� ���
		System.out.printf("��ȸ�߻�����Ʈ%19.20s%8.8s\n","9350**9995","164");//�ݹ� �߻� ����Ʈ ���
		System.out.printf("����(����)����Ʈ%25.25s\n","5,637(   5,473)");//�� ��� ������ ����Ʈ ���
		System.out.printf("*�ż�������Ʈ ��ȿ�Ⱓ�� 2���Դϴ�.\n");//����Ʈ ��ȿ�Ⱓ �ȳ�
		System.out.printf("-----------------------------------------\n");//���м� ���
		System.out.printf("   ���űݾױ��� ���������ð� �ڵ��ο�\n");//���� �����ȳ� ���
		System.out.printf("������ȣ :%30.30s\n","34��****");//������ȣ ���
		System.out.printf("�����ð� :%31.30s\n","2021-03-03 20:20:04");//�����ð� ���
		System.out.printf("-----------------------------------------\n");//���м� ���
		System.out.printf("ĳ��:084599 ��00%25.25s\n","1150");//��� ĳ�� ���� ���
		System.out.printf("             l|l|l|l|l|l|l|\n");//���ڵ� ����
		System.out.printf("      20210303/00119861/00164980/30"); //���ڵ� ���� ���

	}
	
	public static String strForm(String k08_temp, int k08_length, int k08_blank) { //��Ʈ��Ÿ�԰� ��Ƽ��Ÿ���� ���ڷ� �޾� ��Ʈ���� �����ϴ� �ż��� ����
		
		if (k08_temp.length() > k08_length) {//���ڷ� ���� ��Ʈ�� ���̰� ���ڷ� ���� ���ں��� ũ�ٸ�
			k08_temp = k08_temp.substring(0,k08_length);//�� ���ڱ��� ���꽺Ʈ������ ���ڿ� �ڸ���
			
			}
		//���ڷ� ���� ���� * 2 ������ �ڸ� ���ڿ��� ����Ʈ ���̸� �� ��ŭ�� blank��� ������ ����
		k08_blank = k08_blank - k08_temp.getBytes().length;

		for (int k08_i = 0; k08_i < k08_blank; k08_i++) {//0~blank���� �ݺ��� ����
			k08_temp = k08_temp + " ";//�ݺ��� �����ϴ� ���� ���ڿ��� ���� �߰�
		}
		
		return k08_temp;//������ �Ϸ�� ���ڿ� ����
	}
}