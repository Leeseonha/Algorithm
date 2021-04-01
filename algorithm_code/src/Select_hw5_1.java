
/* **************************
 파일명: Select_hw5_1.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.04.22
 내용:  사용자가 입력한 정수값 중에서 선택 알고리즘을 이용하여
 	   중앙값인 정수값을 찾는 프로그램.
 ************************** */

import java.util.Scanner;

public class Select_hw5_1 {
	
	static int select(int[] numbers, int start, int last, int find) {
		if (start == last) {
			return numbers[start];
		}
		int q = partition(numbers, start, last);
		
		int k = q-start+1;	//k는 기준원소가 전체에서 k번째 작은 원소를 의미
		
		if (find < k) {	//왼쪽 그룹으로 범위를 좁힌다
			return select(numbers, start, q-1, find);
		}else if (find == k) {	//기준원소가 바로 찾는 원소이다
			return numbers[q];
		}else {	//오른쪽 그룹으로 범위를 좁힌다
			return select(numbers, q+1, last, find-k);
		}
		
	}
	
	//분할(partition) 함수
	static int partition(int[] numbers, int start, int last) {
		int pivot = numbers[(start + last)/2];
		
		while(start < last) {
			while((numbers[start] < pivot) && (start < last))
				start++;
			while((numbers[last] > pivot) && (start < last))
				last--;
			if(start < last) {
				int temp = numbers[start];
				numbers[start] = numbers[last];
				numbers[last] = temp;
			}
		}
		return start;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw5_1 : 이선하  \n");

		System.out.print("정수갯수 입력 : ");
		int n = sc.nextInt();
		
		int numbers[] = new int[n];
		
		System.out.print(n + "개의 정수 입력 : ");
		//입력한 개수만큼 배열에 저장
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		//select 호출하여 mid에 중앙값 넣기
		int mid = select(numbers, 0, numbers.length -1, (numbers.length + 1)/2);
		
		System.out.println("중앙값 = " + mid);

		sc.close();
	}

}
