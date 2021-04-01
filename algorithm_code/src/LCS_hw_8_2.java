
/* **************************
 파일명: LCS_hw_8_2.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.05.25
 내용:  DP알고리즘을 이용하여 최장 공통 부분 순서 길이 프로그램.
 		입력: 입력을 대신할 값을 코드에 포함/ 출력: 최장공통부분순서 길이를 출력
 ************************** */

import java.util.Scanner;

public class LCS_hw_8_2 {
	public static int dynamicCount(String x, String y) { // 최장 공통 부분 순서 길이 동적 프로그래밍
		int M = x.length();
		int N = y.length();
		int lcs[][] = new int[M + 1][N + 1];
		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (x.charAt(i) == y.charAt(j)) {
					lcs[i + 1][j + 1] = lcs[i][j] + 1;
					max = Math.max(lcs[i + 1][j + 1], max); // 길이 저장
				} else {
					lcs[i + 1][j + 1] = Math.max(lcs[i][j + 1], lcs[i + 1][j]);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("hw8_2 : 이선하  \n");

		String x = "abcbdab"; // 입력을 대신할 값 코드에 포함
		String y = "bdcaba"; // 입력을 대신할 값 코드에 포함

		System.out.println("첫번째 문자열 : " + x);
		System.out.println("두번째 문자열 : " + y);

		System.out.print("\n최장 공통 부분 순서 길이 : ");
		System.out.print(dynamicCount(x, y));
		
		scanner.close();
	}

}
