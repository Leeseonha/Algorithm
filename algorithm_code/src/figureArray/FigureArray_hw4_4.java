
/* **************************
 ���ϸ�: hw4_4.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.04.11
 ����:  ���� ��ü �迭�� �ٷ�� �ڹ� ���α׷�.
 ************************** */

package figureArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

//���� �������̽�
interface Figure {
	double getArea();
}

//�� Ŭ����(���� �������̽��� ����)
class Circle implements Figure {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getArea() {
		return radius * radius * 3.14;
	}

	@Override
	public String toString() {
		return "�� ������=" + radius + " " + "����=" + getArea();
	}
}

//�ﰢ�� Ŭ����(���� �������̽��� ����)
class Triangle implements Figure {
	private double baseLine;
	private double height;

	public Triangle(double baseLine, double height) {
		this.baseLine = baseLine;
		this.height = height;
	}

	public void setBaseLine(double baseLine) {
		this.baseLine = baseLine;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getBaseLine() {
		return baseLine;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public double getArea() {
		return height * baseLine / 2;
	}

	@Override
	public String toString() {
		return "�ﰢ�� �غ�=" + baseLine + " " + "����=" + height + " " + "����=" + String.format("%,3f", getArea());
	}
}

public class FigureArray_hw4_4 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write("hw4_4 : �̼���  \n");

		// ���� ���� �Է�
		bw.write("\n" + "�� ���� �Է�: ");
		bw.flush();
		int cnt_circle = Integer.parseInt(br.readLine());

		// ������� ���� �Է�
		bw.write("�ﰢ�� ���� �Է�: ");
		bw.flush();
		int cnt_tri = Integer.parseInt(br.readLine());

		// ���� �ﰢ���� ������ ��ģ ���� �迭 ����
		Figure[] Figures = new Figure[cnt_circle + cnt_tri];

		// ���� ������ŭ �� ������ ���� �迭�� ����
		bw.write("\n" + cnt_circle + "���� �� ����(������)�� �Է��ϼ��� :");
		bw.newLine();
		bw.flush();
		for (int i = 0; i < cnt_circle; i++)
			Figures[i] = new Circle(Double.parseDouble(br.readLine()));

		// ������� ������ŭ �ﰢ�������� ���� �迭�� ����
		bw.newLine();
		bw.write(cnt_tri + "���� �ﰢ�� ����(�غ��� ����)�� �Է��ϼ��� :");
		bw.newLine();
		bw.flush();
		for (int i = cnt_circle; i < cnt_circle + cnt_tri; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Figures[i] = new Triangle(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}

		// �� Ŭ������ �������̵��Ǿ��ִ� toString�� ����Ͽ� ���� �迭�� ����� ������ ������ ������ ���
		bw.write("\n" + Figures.length + "���� ���� ������ ���� = \n");
		for (Figure f : Figures)
			bw.write(String.valueOf(f) + "\n");

		br.close();
		bw.close();
	}
}
