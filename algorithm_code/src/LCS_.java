
/* **************************
 ���ϸ�: LCS_hw_8_2.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.05.25
 ����:  DP�˰����� �̿��Ͽ� ���� ���� �κ� ���� ���α׷�.
 ************************** */

import java.util.Scanner;

public class LCS_ {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("hw8_2 : �̼���  \n");

//		String x = "ACAYKP"; // �Է��� ����� �� �ڵ忡 ����
//		String y = "CAPCAK"; // �Է��� ����� �� �ڵ忡 ����
		String x = "adfadfa";String y = "asdfasdf";
		int M = x.length();
		int N = y.length();
		System.out.println("ù��° ���ڿ� : " + x);
		System.out.println("�ι�° ���ڿ� : " + y);

		int[][] lcs = new int[M + 1][N + 1];

		for (int i = M - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				if (x.charAt(i) == y.charAt(j))
					lcs[i][j] = lcs[i + 1][j + 1] + 1;
				else
					lcs[i][j] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
			}
		}

		int i = 0, j = 0;
		System.out.print("\n���� ���� �κ� ���� : ");
		while (i < M && j < N) {
			if (x.charAt(i) == y.charAt(j)) {
				System.out.print(x.charAt(i));
				i++;
				j++;
			} else if (lcs[i + 1][j] >= lcs[i][j + 1])
				i++;
			else
				j++;
		}

		scanner.close();

	}

}
