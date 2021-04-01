
/* **************************
 ���ϸ�: MergeSort_hw_4_5.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.04.14
 ����:  ���� ���� �˰����� �̿��Ͽ� ������ 
 	  ���� ������������ �����ϴ� �ڹ� ���α׷�.
 ************************** */

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

class FigureSortService {
	public static void mergeSort(Figure f[]) { // ���� �迭�� �Ű������� �޴� �޼ҵ�
		mergeSort(f, 0, f.length - 1);
	}

	public static void mergeSort(Figure f[], int start, int end) { // ���� �迭 ����
		int mid = (start + end) / 2;
		if (start < end) {
			mergeSort(f, start, mid);
			mergeSort(f, mid + 1, end);
			merge(f, start, end);
		}
	}

	public static void merge(Figure f[], int start, int end) { // ���� �迭 ����
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

		while (p <= q) { // ���ʺκ� �迭�� ���� ���
			temp[k++] = f[p++];
		}
		while (j <= r) { // �����ʺκ� �迭�� ���� ���
			temp[k++] = f[j++];
		}

		// ���ĵ� temp[] f�� �ϼ��Ǿ� f[]�� temp�� ����
		for (int i = start; i <= end; i++) {
			f[i] = temp[i - start];
		}
	}

}

public class MergeSort_hw_4_5 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("hw4_5 : �̼���  \n");

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
		FigureSortService.mergeSort(figureArray);

		System.out.print("\n���� ���� ��� " + figureArray.length + "���� ���� ������ ���� = \n");
		for (int i = 0; i < figureArray.length; i++) {
			System.out.println(figureArray[i]);
		}

		sc.close();
	}

}
