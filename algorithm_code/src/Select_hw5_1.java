
/* **************************
 ���ϸ�: Select_hw5_1.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.04.22
 ����:  ����ڰ� �Է��� ������ �߿��� ���� �˰����� �̿��Ͽ�
 	   �߾Ӱ��� �������� ã�� ���α׷�.
 ************************** */

import java.util.Scanner;

public class Select_hw5_1 {
	
	static int select(int[] numbers, int start, int last, int find) {
		if (start == last) {
			return numbers[start];
		}
		int q = partition(numbers, start, last);
		
		int k = q-start+1;	//k�� ���ؿ��Ұ� ��ü���� k��° ���� ���Ҹ� �ǹ�
		
		if (find < k) {	//���� �׷����� ������ ������
			return select(numbers, start, q-1, find);
		}else if (find == k) {	//���ؿ��Ұ� �ٷ� ã�� �����̴�
			return numbers[q];
		}else {	//������ �׷����� ������ ������
			return select(numbers, q+1, last, find-k);
		}
		
	}
	
	//����(partition) �Լ�
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

		System.out.println("hw5_1 : �̼���  \n");

		System.out.print("�������� �Է� : ");
		int n = sc.nextInt();
		
		int numbers[] = new int[n];
		
		System.out.print(n + "���� ���� �Է� : ");
		//�Է��� ������ŭ �迭�� ����
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		//select ȣ���Ͽ� mid�� �߾Ӱ� �ֱ�
		int mid = select(numbers, 0, numbers.length -1, (numbers.length + 1)/2);
		
		System.out.println("�߾Ӱ� = " + mid);

		sc.close();
	}

}
