
/* **************************
 ���ϸ�: hw0_2.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.04.02
 ����:  �� ���� �迭(�ΰ��� ���� ���� ����)�� ���� �Է��Ͽ�
 	  �� �迭�� ���ҵ��� �������� Ȯ���ϴ� ���α׷�. ��, ������ �ԷµǸ� �Է��� �ߴ��Ѵ�.
 ************************** */

import java.util.Scanner;

public class hw0_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("hw0_2 : �̼���");
		System.out.println("���� ���� ������ ���ϴ� ���α׷��Դϴ�. \n");

		int Array1[] = new int[100];
		int Array2[] = new int[100];

		// ù��° ���� �Է�
		System.out.print("ù��° ������ �Է��ϼ���. ���� �Է��� ��ġ���� ���� �ƴ� ������ �Է��ϼ��� : ");
		for (int i = 0; i < Array1.length; i++) {
			Array1[i] = scanner.nextInt();
			if (Array1[i] < 0) {
				i--;
				break;
			}
		}
		// �ι�° ���� �Է�
		System.out.print("�ι�° ������ �Է��ϼ���. ���� �Է��� ��ġ���� ���� �ƴ� ������ �Է��ϼ��� : ");
		for (int j = 0; j < Array2.length; j++) {
			Array2[j] = scanner.nextInt();
			if (Array2[j] < 0) {
				j--;
				break;
			}
		}

		// �� �迭�� ���ϱ� ���� �������� ���
		for (int a = 0; a < Array1.length; a++) {
			for (int b = 0; b < Array1.length - a - 1; b++) {
				if (Array1[b] > Array1[b + 1]) {
					int temp = Array1[b + 1];
					Array1[b + 1] = Array1[b];
					Array1[b] = temp;
				}
			}
		}
		for (int a = 0; a < Array2.length; a++) {
			for (int b = 0; b < Array2.length - a - 1; b++) {
				if (Array2[b] > Array2[b + 1]) {
					int temp = Array2[b + 1];
					Array2[b + 1] = Array2[b];
					Array2[b] = temp;
				}
			}
		}

		int chk = 0;
		// �迭�� ���Ҹ� ���Ͽ� �� ������ ���� ���� �˻�
		for (int ch = 0; ch < Array1.length; ch++) {
			if (Array1[ch] != Array2[ch])
				chk++;
		}
		if (chk == 0)
			System.out.print("�� ������ �����ϴ�.");
		else
			System.out.print("�� ������ �ٸ��ϴ�.");

		scanner.close();
	}

}