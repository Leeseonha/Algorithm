
/* **************************
 ���ϸ�: hw3_2.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.04.08
 ����:  ����(���ڿ�), �й�(����), ����(�Ǽ�)�� �л� ������ �Է¹޾�
 	  ���� ���� �˰����� �̿��Ͽ� �л��� ���� ������������ �����ϴ� ���α׷�.
 ************************** */

import java.util.Scanner;

class Student_1 {
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

public class hw3_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("hw3_2 : �̼���  \n");

		System.out.print("�л����Է�: ");
		int n = scanner.nextInt();
		Student_1 students[] = new Student_1[n];
		System.out.println("\n" + n + "���� �л� ������ �Է��ϼ���: ");

		// �л� ���� students�� ����
		for (int i = 0; i < n; i++) {
			students[i] = new Student_1();
			students[i].setstdName(scanner.next());
			students[i].setstdID(scanner.nextInt());
			students[i].setstdScore(scanner.nextDouble());
		}

		// �������� �˰��� �̿��Ͽ� ���� ������������ ����
		int max = 0;
		Student_1 Lname = new Student_1();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (students[j].getstdName().compareTo(students[max].getstdName()) <= 0) {
					max = j;
				}
			}
			Lname = students[max];
			students[max] = students[i];
			students[i] = Lname;
		}
		
		// ���� �������� ���� ��� ���
		System.out.println("\n���� �������� ���� ��� = ");
		for (int j = 0; j < n; j++)
			System.out.println(students[j].getstdName() + " " + students[j].getstdID() + " " + students[j].getstdScore());

		scanner.close();
	}

}