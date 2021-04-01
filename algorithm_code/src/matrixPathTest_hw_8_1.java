
/* **************************
 ���ϸ�: matrixPathTest_hw_8_1.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.05.25
 ����:  DP�˰����� �̿��Ͽ� ��� ��� ������ Ǫ�� ���α׷�.
 	   (1,1)���� (n,n)�� �̸��� ��ο��� ���� �� �ִ� �ִ� ������ ���Ѵ�.
 	    �̶� �ִ� ������ ���� �� �ִ� ��ε� �Բ� ���Ѵ�. ******** ���� ����
 ************************** */

import java.util.Scanner;

public class matrixPathTest_hw_8_1 {
	static int n; // ���� ũ�� �Է� n
	static int[][] A; // ��İ��� ������ �迭
	static int[][] M; // �޸����̼� ���̺�
	static int[][] D; // ���� ���̺�

	static int max(int a, int b) { // ���� ���Ͽ� ū ���� max�� ����
		return (a > b) ? a : b;
	}

	static int Memoization(int i, int j) { // ���� ���� �迭�� �����ϰ� ����ϴ� �޸������̼�
		if (M[i][j] != 0)
			return M[i][j];
		if (i == 1 && j == 1) {
			M[i][j] = A[i][j];
		} else if (i == 1) {
			M[i][j] = Memoization(i, j - 1) + A[i][j];
		} else if (j == 1) {
			M[i][j] = Memoization(i - 1, j) + A[i][j];
		} else {
			M[i][j] = max(Memoization(i, j - 1), Memoization(i - 1, j)) + A[i][j];
		}
		return M[i][j];
	}

	static int matrixPath() { // �ִ� ���� ��� ���ϱ�
		D[1][1] = A[1][1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				D[i][j] = max(D[i][j - 1], D[i - 1][j]) + A[i][j];
			}
		}
		return D[n][n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("hw8_1 : �̼���  \n");

		System.out.print("���� ũ�� �Է� : ");

		n = scanner.nextInt();
		A = new int[n + 1][n + 1];
		M = new int[n + 1][n + 1];
		D = new int[n + 1][n + 1];

		System.out.println(n + "x" + n + " ũ���� ��� ���� �Է� : ");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				A[i][j] = scanner.nextInt();
			}
		}

		int maxScore = matrixPath();

		System.out.println("\n�ִ� ���� = " + maxScore);
//		System.out.println("�ִ� ���� ��� = "); // ���ð���

		scanner.close();
	}
}
