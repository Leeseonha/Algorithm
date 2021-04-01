/* **************************
 파일명: HeapSort_hw_4_6.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.04.14
 내용:  힙 정렬 알고리즘을 이용하여 도형을 
 	  면적 오름차순으로 정렬하는 자바 프로그램.
 ************************** */

package heapsortArray;

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

class HeapSort {
	public static void swap(Figure f[], int i, int j) {
		Figure temp = f[i];
		f[i] = f[j];
		f[j] = temp;
	}

	public static void buildHeap(Figure f[]) {
		int end = f.length - 1;
		for (int i = end / 2; i >= 0; i--)
			heapify(f, i, end);
	}

	public static void heapify(Figure f[], int k, int end) {
		int left = 2 * k + 1, right = 2 * k + 2;
		int smaller;
		if (right <= end) // k노드가 자식을 두개 가질 때
			smaller = (f[left].getArea() > f[right].getArea()) ? left : right;
		else if (left <= end) // k노드가 자식을 한개 가질 때
			smaller = left;
		else // k노드의 자식이 없을 때 종료
			return;
		if (f[smaller].getArea() > f[k].getArea()) { // 위에서 찾은 samller(자식 중 작은 값)과 k노드 비교
			swap(f, smaller, k);
			heapify(f, smaller, end);
		}
	}

	public static void heapSort(Figure f[]) {
		buildHeap(f);
		for (int end = f.length - 1; end >= 1; end--) {
			swap(f, 0, end);
			heapify(f, 0, end - 1);
		}
	}
}

public class HeapSort_hw_4_6 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw4_6 : 이선하  \n");

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
		HeapSort.heapSort(figureArray);

		System.out.print("\n힙 정렬 결과 " + figureArray.length + "개의 도형 정보와 면적 = \n");
		for (int i = 0; i < figureArray.length; i++) {
			System.out.println(figureArray[i]);
		}

		sc.close();
	}

}
