
/* **************************
 파일명: hw0_2.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.04.02
 내용:  두 개의 배열(두개의 양의 정수 집합)을 각각 입력하여
 	  두 배열의 원소들이 동일한지 확인하는 프로그램. 단, 음수가 입력되면 입력을 중단한다.
 ************************** */

import java.util.Scanner;

public class hw0_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("hw0_2 : 이선하");
		System.out.println("양의 정수 집합을 비교하는 프로그램입니다. \n");

		int Array1[] = new int[100];
		int Array2[] = new int[100];

		// 첫번째 집합 입력
		System.out.print("첫번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 정수를 입력하세요 : ");
		for (int i = 0; i < Array1.length; i++) {
			Array1[i] = scanner.nextInt();
			if (Array1[i] < 0) {
				i--;
				break;
			}
		}
		// 두번째 집합 입력
		System.out.print("두번째 집합을 입력하세요. 집합 입력을 마치려면 양이 아닌 정수를 입력하세요 : ");
		for (int j = 0; j < Array2.length; j++) {
			Array2[j] = scanner.nextInt();
			if (Array2[j] < 0) {
				j--;
				break;
			}
		}

		// 두 배열을 비교하기 위해 버블정렬 사용
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
		// 배열의 원소를 비교하여 두 집합의 동일 여부 검사
		for (int ch = 0; ch < Array1.length; ch++) {
			if (Array1[ch] != Array2[ch])
				chk++;
		}
		if (chk == 0)
			System.out.print("두 집합은 같습니다.");
		else
			System.out.print("두 집합은 다릅니다.");

		scanner.close();
	}

}