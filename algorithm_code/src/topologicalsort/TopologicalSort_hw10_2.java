
/* **************************
 파일명: TopologicalSort_hw10_2.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.06.07
 내용:  DAG(Directed Acyclic Graph)에 대해 topological sort를 수행하는 프로그램.
 ************************** */

package topologicalsort;

import java.util.Scanner;

class DirectedGraph {
	private Node[] list; // 인접 리스트
	private int numberOfVertices; // 정점 수

	private boolean visited[]; // 방문 확인 리스트
	private Node sortedGraph; // 정렬된 그래프

	// 리스트의 노드 구조를 정의한 클래스
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

	// 정점 수가 n인 그래프를 생성
	public DirectedGraph(int n) {
		list = new Node[n];
		for (int i = 0; i < n; i++)
			list[i] = new Node();
		numberOfVertices = n;
		visited = new boolean[numberOfVertices];
	}

	// 간선 <v1,v2>를 삽입
	public void addEdge(int v1, int v2) {
		// v1,v2가 올바른 정점 번호이면, list[v1]에 v2를 삽입
		if (v1 >= numberOfVertices || v1 < 0 || v2 >= numberOfVertices || v2 < 0) {
			System.out.print("간선 삽입 오류-잘못된 정점 번호입니다. <" + v1 + "," + v2 + ">" + "\n");
		} else {
			if (list[v1].link == null) { // 만약에 인접리스트의 v1번째가 비어있다면
				Node temp = new Node();
				temp.vertex = v2;
				list[v1].link = temp;
			} else {
				Node temp = new Node(); // 만약에 인접리스트의 v1번째가 안 비어있다면
				temp.vertex = v2;
				temp.link = list[v1].link;
				list[v1].link = temp;
			}
		}
	}

	// 구현을 확인하기 위해 인접 리스트를 모두 출력
	public void printAdjacencyList() {
		System.out.println(" ");
		// 반복문을 이용하여 list[0],...,list[numberOfVertices-1]의 모든 정점 번호를 출력
		for (int i = 0; i < numberOfVertices; i++) {
			System.out.print("정점 " + i + "에 인접한 정점 = ");
			Node temp = list[i].link;
			while (temp != null) {
				System.out.print(temp.vertex + " ");
				temp = temp.link;
			}
			System.out.println(" ");
		}
	}

	// dfs구현
	public void dfs(int v) {
		visited[v] = true;
		Node temp = list[v];
		while (temp != null) {
			if (visited[temp.vertex] == false) {
				dfs(temp.vertex);
			}
			temp = temp.link;
		}
		Node put = new Node(); // dfs로 정렬한 다음 역으로 정렬한 노드 삽입
		put.vertex = v;
		if (sortedGraph == null) {
			sortedGraph = put;
		} else {
			put.link = sortedGraph;
			sortedGraph = put;
		}
	}

	// 정점수만큼 반복하여 dfs함수 실행
	public void topologicalSortDFS() {
		for (int i = 0; i < numberOfVertices; i++) {
			if (visited[i] == false) {
				dfs(i);
			}
		}
	}

	// 위상 정렬 수행 확인하기 위해 정점 번호 출력
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

		System.out.println("hw10_2 : 이선하  \n");

		Scanner scanner = new Scanner(System.in);
		System.out.println("위상 정렬을 수행합니다. DAG를 입력하세요.");
		// (1)정점 수 n을 입력받음
		System.out.print("정점 수 입력: ");
		int n = scanner.nextInt();

		// (2)정점 수가 n인 방향 그래프를 생성
		DirectedGraph graph = new DirectedGraph(n);

		// (3)간선 수 e를 입력받음
		System.out.print("간선 수 입력: ");
		int e = scanner.nextInt();

		// (4)e개의 간선 입력받아 그래프에 삽입
		System.out.println("\n" + e + "개의 간선 입력(각 간선은 정점 번호 2개를 whitespace로 구분하여 입력):");
		for (int i = 0; i < e; i++) {
			System.out.print("간선 " + (i + 1) + " 입력: ");
			int startNode = scanner.nextInt();
			int endNode = scanner.nextInt();
			graph.addEdge(startNode, endNode);
		}

		// (5)그래프 구현을 확인();
		graph.printAdjacencyList();

		// (6)위상 정렬 확인
		System.out.print("\n위상정렬 결과: ");
		graph.topologicalSortDFS();
		graph.printDFS();
	}

}
