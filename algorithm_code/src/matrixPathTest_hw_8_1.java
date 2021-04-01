
/* **************************
 파일명: matrixPathTest_hw_8_1.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.05.25
 내용:  DP알고리즘을 이용하여 행렬 경로 문제를 푸는 프로그램.
 	   (1,1)부터 (n,n)에 이르는 경로에서 얻을 수 있는 최대 점수를 구한다.
 	    이때 최대 점수를 얻을 수 있는 경로도 함께 구한다. ******** 선택 과제
 ************************** */

import java.util.Scanner;

public class matrixPathTest_hw_8_1 {
	static int n; // 행의 크기 입력 n
	static int[][] A; // 행렬값을 저장한 배열
	static int[][] M; // 메모리제이션 테이블
	static int[][] D; // 동적 테이블

	static int max(int a, int b) { // 값을 비교하여 큰 값을 max에 삽입
		return (a > b) ? a : b;
	}

	static int Memoization(int i, int j) { // 계산된 값을 배열에 보관하고 사용하는 메모이제이션
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

	static int matrixPath() { // 최대 점수 출력 구하기
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

		System.out.println("hw8_1 : 이선하  \n");

		System.out.print("행의 크기 입력 : ");

		n = scanner.nextInt();
		A = new int[n + 1][n + 1];
		M = new int[n + 1][n + 1];
		D = new int[n + 1][n + 1];

		System.out.println(n + "x" + n + " 크기의 행렬 원소 입력 : ");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				A[i][j] = scanner.nextInt();
			}
		}

		int maxScore = matrixPath();

		System.out.println("\n최대 점수 = " + maxScore);
//		System.out.println("최대 점수 경로 = "); // 선택과제

		scanner.close();
	}
}
