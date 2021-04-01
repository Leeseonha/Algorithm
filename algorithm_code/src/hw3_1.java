
/* **************************
 파일명: hw3_1.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.04.05
 내용:  성명(문자열), 학번(정수), 성적(실수)의 학생 정보를 입력받아
 	  n명 학생 성적의 평균값과 성적이 최고점인 학생을 찾아 성명을 출력하는 프로그램.
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

		System.out.println("hw3_1 : 이선하  \n");

		System.out.print("학생수입력: ");
		int n = scanner.nextInt();
		Student students[] = new Student[n];
		System.out.println("\n" + n + "명의 학생 정보를 입력하세요: ");

		// 학생 정보 students에 저장
		int max = 0;
		double maxScore = 0.0;

		for (int i = 0; i < n; i++) {
			students[i] = new Student();
			students[i].setstdName(scanner.next());
			students[i].setstdID(scanner.nextInt());
			students[i].setstdScore(scanner.nextDouble());
			// 성적이 최고점인 학생 찾기
			if (maxScore < students[i].getstdScore()) {
				maxScore = students[i].getstdScore();
				max = i;
			}

		}

		// 학생 성적 평균 구하기
		double sum = 0;
		for (int j = 0; j < n; j++) {
			sum += students[j].getstdScore();
		}
		System.out.println("\n성적 평균 = " + (double) sum / n);
		System.out.println("\n수석 학생 성명 = " + students[max].getstdName());

		scanner.close();
	}

}
