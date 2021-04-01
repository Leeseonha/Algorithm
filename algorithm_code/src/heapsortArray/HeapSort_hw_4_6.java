/* **************************
 ���ϸ�: HeapSort_hw_4_6.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.04.14
 ����:  �� ���� �˰����� �̿��Ͽ� ������ 
 	  ���� ������������ �����ϴ� �ڹ� ���α׷�.
 ************************** */

package heapsortArray;

import java.util.Scanner;

//���� �������̽�
interface Figure {

	abstract double getArea();
}

//�� Ŭ����(���� �������̽��� ����)
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
		return "�� ������ =" + radius + " ���� = " + getArea();
	}

	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
}

//�ﰢ�� Ŭ����(���� �������̽��� ����)
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
		return "�ﰢ�� �غ� = " + width + " ���� = " + height + " ���� = " + getArea();
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
		if (right <= end) // k��尡 �ڽ��� �ΰ� ���� ��
			smaller = (f[left].getArea() > f[right].getArea()) ? left : right;
		else if (left <= end) // k��尡 �ڽ��� �Ѱ� ���� ��
			smaller = left;
		else // k����� �ڽ��� ���� �� ����
			return;
		if (f[smaller].getArea() > f[k].getArea()) { // ������ ã�� samller(�ڽ� �� ���� ��)�� k��� ��
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

		System.out.println("hw4_6 : �̼���  \n");

		System.out.print("�� ���� �Է� : ");
		int n1 = sc.nextInt();
		System.out.print("�ﰢ�� ���� �Է� : ");
		int n2 = sc.nextInt();

		Figure[] figureArray = new Figure[n1 + n2];

		System.out.print("\n" + n1 + "���� �� ����(������)�� �Է��ϼ���: \n");
		for (int i = 0; i < n1; i++) {
			Circle c = new Circle(); // Circle() ��ü ����
			c.setRadius(sc.nextDouble());
			figureArray[i] = c;
		}

		System.out.print("\n" + n2 + "���� �ﰢ�� ����(�غ��� ����)�� �Է��ϼ���: \n");
		for (int i = 0; i < n2; i++) {
			Triangle t = new Triangle(); // Triangle() ��ü ����
			t.setWidth(sc.nextDouble());
			t.setHeight(sc.nextDouble());
			figureArray[n1 + i] = t;
		}
		HeapSort.heapSort(figureArray);

		System.out.print("\n�� ���� ��� " + figureArray.length + "���� ���� ������ ���� = \n");
		for (int i = 0; i < figureArray.length; i++) {
			System.out.println(figureArray[i]);
		}

		sc.close();
	}

}
