
/* **************************
 파일명: MergeSort_hw_4_5.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.04.14
 내용:  병합 정렬 알고리즘을 이용하여 도형을 
 	  면적 오름차순으로 정렬하는 자바 프로그램.
 ************************** */

import java.util.Scanner;

//도형 인터페이스
interface Figure {

	abstract double getArea();
}

//원 클래스(도형 인터페이스를 구현)
class Circle implements Figure {
	private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "원 반지름 =" + radius + " 면적 = " + getArea();
	}

	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
}

//삼각형 클래스(도형 인터페이스를 구현)
class Triangle implements Figure {

	private double width, height;

	public Triangle() {
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "삼각형 밑변 = " + width + " 높이 = " + height + " 면적 = " + getArea();
	}

	@Override
	public double getArea() {
		return width * height / 2.0;
	}

}

class FigureSortService {
	public static void mergeSort(Figure f[]) { // 도형 배열을 매개변수로 받는 메소드
		mergeSort(f, 0, f.length - 1);
	}

	public static void mergeSort(Figure f[], int start, int end) { // 도형 배열 정렬
		int mid = (start + end) / 2;
		if (start < end) {
			mergeSort(f, start, mid);
			mergeSort(f, mid + 1, end);
			merge(f, start, end);
		}
	}

	public static void merge(Figure f[], int start, int end) { // 도형 배열 병합
		int p = start;
		int q = (start + end) / 2;
		int j = (start + end) / 2 + 1;
		int r = end;
		int k = 0;
		Figure temp[] = new Figure[f.length];

		while (p <= q && j <= r) {
			if (f[p].getArea() <= f[j].getArea()) {
				temp[k++] = f[p++];
			} else {
				temp[k++] = f[j++];
			}
		}

		while (p <= q) { // 왼쪽부분 배열이 남은 경우
			temp[k++] = f[p++];
		}
		while (j <= r) { // 오른쪽부분 배열이 남은 경우
			temp[k++] = f[j++];
		}

		// 정렬된 temp[] f가 완성되어 f[]에 temp값 복사
		for (int i = start; i <= end; i++) {
			f[i] = temp[i - start];
		}
	}

}

public class MergeSort_hw_4_5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw4_5 : 이선하  \n");

		System.out.print("원 개수 입력 : ");
		int n1 = sc.nextInt();
		System.out.print("삼각형 개수 입력 : ");
		int n2 = sc.nextInt();

		Figure[] figureArray = new Figure[n1 + n2];

		System.out.print("\n" + n1 + "개의 원 정보(반지름)를 입력하세요: \n");
		for (int i = 0; i < n1; i++) {
			Circle c = new Circle(); // Circle() 객체 생성
			c.setRadius(sc.nextDouble());
			figureArray[i] = c;
		}

		System.out.print("\n" + n2 + "개의 삼각형 정보(밑변과 높이)를 입력하세요: \n");
		for (int i = 0; i < n2; i++) {
			Triangle t = new Triangle(); // Triangle() 객체 생성
			t.setWidth(sc.nextDouble());
			t.setHeight(sc.nextDouble());
			figureArray[n1 + i] = t;
		}
		FigureSortService.mergeSort(figureArray);

		System.out.print("\n병합 정렬 결과 " + figureArray.length + "개의 도형 정보와 면적 = \n");
		for (int i = 0; i < figureArray.length; i++) {
			System.out.println(figureArray[i]);
		}

		sc.close();
	}

}
