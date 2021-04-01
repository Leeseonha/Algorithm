
/* **************************
 파일명: LCS_hw_8_2.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.05.25
 내용:  DP알고리즘을 이용하여 최장 공통 부분 순서 프로그램.
 ************************** */

import java.util.Scanner;

public class LCS_ {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("hw8_2 : 이선하  \n");

//		String x = "ACAYKP"; // 입력을 대신할 값 코드에 포함
//		String y = "CAPCAK"; // 입력을 대신할 값 코드에 포함
		String x = "adfadfa";String y = "asdfasdf";
		int M = x.length();
		int N = y.length();
		System.out.println("첫번째 문자열 : " + x);
		System.out.println("두번째 문자열 : " + y);

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
		System.out.print("\n최장 공통 부분 순서 : ");
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
