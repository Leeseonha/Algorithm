
/* **************************
 ���ϸ�: LCS_hw_8_2.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.05.25
 ����:  DP�˰����� �̿��Ͽ� ���� ���� �κ� ���� ���� ���α׷�.
 		�Է�: �Է��� ����� ���� �ڵ忡 ����/ ���: �������κм��� ���̸� ���
 ************************** */

import java.util.Scanner;

public class LCS_hw_8_2 {
	public static int dynamicCount(String x, String y) { // ���� ���� �κ� ���� ���� ���� ���α׷���
		int M = x.length();
		int N = y.length();
		int lcs[][] = new int[M + 1][N + 1];
		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (x.charAt(i) == y.charAt(j)) {
					lcs[i + 1][j + 1] = lcs[i][j] + 1;
					max = Math.max(lcs[i + 1][j + 1], max); // ���� ����
				} else {
					lcs[i + 1][j + 1] = Math.max(lcs[i][j + 1], lcs[i + 1][j]);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("hw8_2 : �̼���  \n");

		String x = "abcbdab"; // �Է��� ����� �� �ڵ忡 ����
		String y = "bdcaba"; // �Է��� ����� �� �ڵ忡 ����

		System.out.println("ù��° ���ڿ� : " + x);
		System.out.println("�ι�° ���ڿ� : " + y);

		System.out.print("\n���� ���� �κ� ���� ���� : ");
		System.out.print(dynamicCount(x, y));
		
		scanner.close();
	}

}
