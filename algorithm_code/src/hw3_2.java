
/* **************************
 파일명: hw3_2.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.04.08
 내용:  성명(문자열), 학번(정수), 성적(실수)의 학생 정보를 입력받아
 	  선택 정렬 알고리즘을 이용하여 학생을 성명 오름차순으로 정렬하는 프로그램.
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

		System.out.println("hw3_2 : 이선하  \n");

		System.out.print("학생수입력: ");
		int n = scanner.nextInt();
		Student_1 students[] = new Student_1[n];
		System.out.println("\n" + n + "명의 학생 정보를 입력하세요: ");

		// 학생 정보 students에 저장
		for (int i = 0; i < n; i++) {
			students[i] = new Student_1();
			students[i].setstdName(scanner.next());
			students[i].setstdID(scanner.nextInt());
			students[i].setstdScore(scanner.nextDouble());
		}

		// 선택정렬 알고리즘 이용하여 성명 오름차순으로 정렬
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
		
		// 성명 오름차순 정렬 결과 출력
		System.out.println("\n성명 오름차순 정렬 결과 = ");
		for (int j = 0; j < n; j++)
			System.out.println(students[j].getstdName() + " " + students[j].getstdID() + " " + students[j].getstdScore());

		scanner.close();
	}

}