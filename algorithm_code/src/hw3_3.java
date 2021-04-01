
/* **************************
 ���ϸ�: hw3_3.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.04.08
 ����:  ����(���ڿ�), �й�(����), ����(�Ǽ�)�� �л� ������ �Է¹޾�
 	  ���� ���� �˰����� �̿��Ͽ� �л��� ���� ������������ �����ϴ� ���α׷�.
 ************************** */

import java.util.Scanner;

class Student_2 {
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

public class hw3_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("hw3_3 : �̼���  \n");

		System.out.print("�л����Է�: ");
		int n = scanner.nextInt();
		Student_2 students[] = new Student_2[n];
		System.out.println("\n" + n + "���� �л� ������ �Է��ϼ���: ");

		// �л� ���� students�� ����
		for (int i = 0; i < n; i++) {
			students[i] = new Student_2();
			students[i].setstdName(scanner.next());
			students[i].setstdID(scanner.nextInt());
			students[i].setstdScore(scanner.nextDouble());
		}

		// �������� �˰��� �̿��Ͽ� ���� ������������ ����
		Student_2 grade = new Student_2();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (students[j].getstdScore() < students[j + 1].getstdScore()) {
					grade = students[j];
					students[j] = students[j + 1];
					students[j + 1] = grade;
				}
			}
		}

		// ���� �������� ���� ��� ���
		System.out.println("\n���� �������� ���� ��� = ");
		for (int j = 0; j < n; j++)
			System.out.println(students[j].getstdName() + " " + students[j].getstdID() + " " + students[j].getstdScore());

		scanner.close();
	}

}