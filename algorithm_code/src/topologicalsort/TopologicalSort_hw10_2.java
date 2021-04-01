
/* **************************
 ���ϸ�: TopologicalSort_hw10_2.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.06.07
 ����:  DAG(Directed Acyclic Graph)�� ���� topological sort�� �����ϴ� ���α׷�.
 ************************** */

package topologicalsort;

import java.util.Scanner;

class DirectedGraph {
	private Node[] list; // ���� ����Ʈ
	private int numberOfVertices; // ���� ��

	private boolean visited[]; // �湮 Ȯ�� ����Ʈ
	private Node sortedGraph; // ���ĵ� �׷���

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
		visited = new boolean[numberOfVertices];
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

	// dfs����
	public void dfs(int v) {
		visited[v] = true;
		Node temp = list[v];
		while (temp != null) {
			if (visited[temp.vertex] == false) {
				dfs(temp.vertex);
			}
			temp = temp.link;
		}
		Node put = new Node(); // dfs�� ������ ���� ������ ������ ��� ����
		put.vertex = v;
		if (sortedGraph == null) {
			sortedGraph = put;
		} else {
			put.link = sortedGraph;
			sortedGraph = put;
		}
	}

	// ��������ŭ �ݺ��Ͽ� dfs�Լ� ����
	public void topologicalSortDFS() {
		for (int i = 0; i < numberOfVertices; i++) {
			if (visited[i] == false) {
				dfs(i);
			}
		}
	}

	// ���� ���� ���� Ȯ���ϱ� ���� ���� ��ȣ ���
	public void printDFS() {
		Node temp = sortedGraph;
		while (temp != null) {
			System.out.print(temp.vertex + " ");
			temp = temp.link;
		}
	}

}

public class TopologicalSort_hw10_2 {
	public static void main(String[] args) {

		System.out.println("hw10_2 : �̼���  \n");

		Scanner scanner = new Scanner(System.in);
		System.out.println("���� ������ �����մϴ�. DAG�� �Է��ϼ���.");
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

		// (6)���� ���� Ȯ��
		System.out.print("\n�������� ���: ");
		graph.topologicalSortDFS();
		graph.printDFS();
	}

}
