
/* **************************
 ���ϸ�: hw3_1.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.04.05
 ����:  ����(���ڿ�), �й�(����), ����(�Ǽ�)�� �л� ������ �Է¹޾�
 	  n�� �л� ������ ��հ��� ������ �ְ����� �л��� ã�� ������ ����ϴ� ���α׷�.
 ************************** */

import java.util.Scanner;

class Student {
	private String stdName;
	private int stdID;
	private double stdScore;

	public String getstdName() {
		return stdName;
	}

	public void setstdName(String stdName) {
		this.stdName = stdName;
	}

	public int getstdID() {
		return stdID;
	}

	public void setstdID(int stdID) {
		this.stdID = stdID;
	}

	public double getstdScore() {
		return stdScore;
	}

	public void setstdScore(double stdScore) {
		this.stdScore = stdScore;
	}

}

public class hw3_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("hw3_1 : �̼���  \n");

		System.out.print("�л����Է�: ");
		int n = scanner.nextInt();
		Student students[] = new Student[n];
		System.out.println("\n" + n + "���� �л� ������ �Է��ϼ���: ");

		// �л� ���� students�� ����
		int max = 0;
		double maxScore = 0.0;

		for (int i = 0; i < n; i++) {
			students[i] = new Student();
			students[i].setstdName(scanner.next());
			students[i].setstdID(scanner.nextInt());
			students[i].setstdScore(scanner.nextDouble());
			// ������ �ְ����� �л� ã��
			if (maxScore < students[i].getstdScore()) {
				maxScore = students[i].getstdScore();
				max = i;
			}

		}

		// �л� ���� ��� ���ϱ�
		double sum = 0;
		for (int j = 0; j < n; j++) {
			sum += students[j].getstdScore();
		}
		System.out.println("\n���� ��� = " + (double) sum / n);
		System.out.println("\n���� �л� ���� = " + students[max].getstdName());

		scanner.close();
	}

}
