
/* **************************
 파일명: hw3_3.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.04.08
 내용:  성명(문자열), 학번(정수), 성적(실수)의 학생 정보를 입력받아
 	  버블 정렬 알고리즘을 이용하여 학생을 성적 내림차순으로 정렬하는 프로그램.
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

		System.out.println("hw3_3 : 이선하  \n");

		System.out.print("학생수입력: ");
		int n = scanner.nextInt();
		Student_2 students[] = new Student_2[n];
		System.out.println("\n" + n + "명의 학생 정보를 입력하세요: ");

		// 학생 정보 students에 저장
		for (int i = 0; i < n; i++) {
			students[i] = new Student_2();
			students[i].setstdName(scanner.next());
			students[i].setstdID(scanner.nextInt());
			students[i].setstdScore(scanner.nextDouble());
		}

		// 버블정렬 알고리즘 이용하여 성적 내림차순으로 정렬
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

		// 성적 내림차순 정렬 결과 출력
		System.out.println("\n성적 내림차순 정렬 결과 = ");
		for (int j = 0; j < n; j++)
			System.out.println(students[j].getstdName() + " " + students[j].getstdID() + " " + students[j].getstdScore());

		scanner.close();
	}

}