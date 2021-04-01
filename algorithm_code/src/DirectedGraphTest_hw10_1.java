
/* **************************
 ���ϸ�: DirectedGraphTest_hw10_1.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.06.07
 ����:  ���� �׷����� ���� ����Ʈ�� �����ϴ� ���α׷�.
 		DirectedGraph: ���� ����Ʈ�� ������ ���� �׷��� Ŭ����
 		DirectedGraphTest_hw10_1: ���� ����Ʈ�� ������ ���� �׷����� �����ϰ� Ȯ���ϴ� ���α׷�
 ************************** */

import java.util.Scanner;

class DirectedGraph {
	private Node[] list; // ���� ����Ʈ
	private int numberOfVertices; // ���� ��

	// ����Ʈ�� ��� ������ ������ Ŭ����
	private class Node {
		int vertex;
		Node link;

		public Node() {
			this.link = null;
		}

		public int getVertex() {
			return vertex;
		}

		public void setVertex(int vertex) {
			this.vertex = vertex;
		}

		public Node getLink() {
			return link;
		}

		public void setLink(Node link) {
			this.link = link;
		}
	}

	// ���� ���� n�� �׷����� ����
	public DirectedGraph(int n) {
		list = new Node[n];
		for (int i = 0; i < n; i++)
			list[i] = new Node();
		numberOfVertices = n;
	}

	// ���� <v1,v2>�� ����
	public void addEdge(int v1, int v2) {
		// v1,v2�� �ùٸ� ���� ��ȣ�̸�, list[v1]�� v2�� ����
		if (v1 >= numberOfVertices || v1 < 0 || v2 >= numberOfVertices || v2 < 0) {
			System.out.print("���� ���� ����-�߸��� ���� ��ȣ�Դϴ�. <" + v1 + "," + v2 + ">" + "\n");
		} else {
			if (list[v1].link == null) { // ���࿡ ��������Ʈ�� v1��°�� ����ִٸ�
				Node temp = new Node();
				temp.vertex = v2;
				list[v1].link = temp;
			} else {
				Node temp = new Node(); // ���࿡ ��������Ʈ�� v1��°�� �� ����ִٸ�
				temp.vertex = v2;
				temp.link = list[v1].link;
				list[v1].link = temp;
			}
		}
	}

	// ������ Ȯ���ϱ� ���� ���� ����Ʈ�� ��� ���
	public void printAdjacencyList() {
		System.out.println(" ");
		// �ݺ����� �̿��Ͽ� list[0],...,list[numberOfVertices-1]�� ��� ���� ��ȣ�� ���
		for (int i = 0; i < numberOfVertices; i++) {
			System.out.print("���� " + i + "�� ������ ���� = ");
			Node temp = list[i].link;
			while (temp != null) {
				System.out.print(temp.vertex + " ");
				temp = temp.link;
			}
			System.out.println(" ");
		}

	}
}

public class DirectedGraphTest_hw10_1 {
	public static void main(String[] args) {

		System.out.println("hw10_1 : �̼���  \n");

		Scanner scanner = new Scanner(System.in);
		// (1)���� �� n�� �Է¹���
		System.out.print("���� �� �Է�: ");
		int n = scanner.nextInt();

		// (2)���� ���� n�� ���� �׷����� ����
		DirectedGraph graph = new DirectedGraph(n);

		// (3)���� �� e�� �Է¹���
		System.out.print("���� �� �Է�: ");
		int e = scanner.nextInt();

		// (4)e���� ���� �Է¹޾� �׷����� ����
		System.out.println("\n" + e + "���� ���� �Է�(�� ������ ���� ��ȣ 2���� whitespace�� �����Ͽ� �Է�):");
		for (int i = 0; i < e; i++) {
			System.out.print("���� " + (i + 1) + " �Է�: ");
			int startNode = scanner.nextInt();
			int endNode = scanner.nextInt();
			graph.addEdge(startNode, endNode);
		}

		// (5)�׷��� ������ Ȯ��();
		graph.printAdjacencyList();
	}

}
