
/* **************************
 파일명: MyBinarySearchTreeTest_hw_6_1.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.04.30
 내용:  아이디를 관리하는 이진검색트리 프로그램.
 	    아이디는 문자열이며, 중복되지 않는다.
1:삽입 - 사용자로부터 아이디를 입력받아 트리에 삽입하고, 삽입 성공 여부를 알림
2:검색 - 사용자로부터 아이디를 입력받아 트리에 존재하는 아이디인지 검사
3:삭제 - 사용자로부터 아이디를 입력받아 트리에서 삭제하고, 삭제 성공 여부를 알림 ************ 선택 과제임
4:전체조회 - 트리에 저장된 아이디의 갯수를 출력하고, 저장된 아이디를 모두 출력
 ************************** */

import java.util.Scanner;

class MyBinarySearchTree {
	// (1)private필드
	private Node root;
	private int idNum;

	public MyBinarySearchTree() {
		this.root = null;
		this.idNum = idNum;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	// (2)print() - 트리에 저장된 아이디를 모두 출력
	public void print() {
		inorder(root);
		System.out.println();

	}

	// (2)size() - 트리에 저장된 아이디 수(노드 수)를 리턴
	public int size(Node root) {
		int idNum;
		if (root == null) {
			idNum = 0;
		} else {
			idNum = size(root.left) + size(root.right) + 1;
		}
		return idNum;
	}

	// (2)탐색/검색(contanins) 연산 - 트리에 아이디가 존재하는지 여부 검사
	public boolean contanins(String id) {
		Node current = root;
		while (current != null) {
			if (id.compareTo(current.getId()) == 0) { // 현재 노드와 찾는 값이 같으면
				return true;
			} else if (id.compareTo(current.getId()) < 0) { // 찾는 값이 현재 노드보다 작으면
				current = current.getLeft();
			} else { // 찾는 값이 현재 노드보다 크면
				current = current.getRight();
			}
		}
		return false;
	}

	// (2)삽입(add) 연산 - 트리에 아이디를 삽입. 이미 존재하는 아이디면 삽입 실패
	public boolean add(String id) {

		Node newNode = new Node(id);
		if (contanins(id))
			return false;
		if (root == null) {
			root = newNode;
			return true;
		}
		Node current = root;
		Node parent;
		while (true) {
			parent = current;
			if (id.compareTo(current.getId()) < 0) {
				current = parent.getLeft();
				if (current == null) {
					parent.setLeft(newNode);
					return true;
				}
			} else {
				current = parent.getRight();
				if (current == null) {
					parent.setRight(newNode);
					return true;
				}
			}
		}
	}

	// (2)삭제(remove) 연산 - 트리에서 아이디를 삭제. 존재하지 않는 아이디면 삭제 실패
	public boolean remove(String id) {
		Node parent = root; // 삭제될 노드의 부모노드를 가리킴
		Node current = root; // 삭제될 노드를 가리킴
		boolean isLeftChild = true;
		Node temp;
		while (current.getId().compareTo(id) != 0) {
			parent = current;
			if (id.compareTo(current.getId()) < 0) {
				isLeftChild = true;
				current = current.getLeft();
			} else {
				isLeftChild = false;
				current = current.getRight();
			}
			if (current == null) { // 찾는 노드가 null인 경우
				return false;
			}
		}
		// case 1: 자식노드가 없는 경우
		if (current.getLeft() == null && current.getRight() == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild == true) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}
		// case 2: 하나의 자식을 갖는 경우
		else if (current.getRight() == null) { // 삭제할 노드의 오른쪽 자식 노드가 null인 경우
			if (current == root) {
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else if (current.getLeft() == null) { // 삭제할 노드의 왼쪽 자식 노드가 null인 경우
			if (current == root) {
				root = current.getRight();
			} else if (isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		}
		// case 3: 두개의 자식을 갖는 경우
		else {
			Node rightSubTree = current.getRight(); // 삭제될 노드의 오른쪽서브트리에 저장
			temp = getRightmin(current.getRight()); // 해당 노드의 오른쪽서브트리에서 가장 작은 값으로 대체
			if (current == root)
				root = temp;
			else if (isLeftChild)
				parent.left = temp;
			else
				parent.right = temp;

			temp.right = rightSubTree;
			if (temp == rightSubTree)
				temp.right = null;
			temp.left = current.left;
		}
		return true;
	}

	public Node getRightmin(Node rightChildRoot) {
		Node parent = rightChildRoot;
		Node current = rightChildRoot;

		while (current.getLeft() != null) {
			parent = current;
			current = current.left;
		}

		parent.left = null;
		return current;
	}

	// (3)private메소드-inorder():중순위 순회하며 키값을 출력
	private void inorder(Node t) { // 재귀 메소드
		if (t != null) {
			inorder(t.left);
			System.out.print(t.getId() + " ");
			inorder(t.right);
		}

	}

	// (4)트리의 노드 구조를 정의하는 private클래스 - 아이디(문자열)필드, 왼쪽자식링크필드, 오른쪽자식링크필드
	private class Node {
		String id;
		Node left;
		Node right;

		public Node(String id) {
			this.setId(id);
			setLeft(null);
			setRight(null);
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

}

public class MyBinarySearchTreeTest_hw_6_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("hw6_1 : 이선하  \n");

		MyBinarySearchTree b = new MyBinarySearchTree();

		int menu = 0;

		whileout: // 다중 반복문 빠져나오는 반복문 이름 whileout으로 지정
		while (true) {
			System.out.println("메뉴 - [1:삽입 2:검색 3:삭제 4:전체조회 5:종료]");
			System.out.print("메뉴를 선택하시오: ");
			menu = scanner.nextInt();
			switch (menu) {
			case 1: // 1일때 삽입
				System.out.print("삽입할 ID 입력: ");
				if (b.add(scanner.next()))
					System.out.println("삽입 성공");
				else
					System.out.println("삽입 실패");
				System.out.println();
				break;
			case 2: // 2일때 검색
				System.out.print("검색할 ID 입력: ");
				if (b.contanins(scanner.next()))
					System.out.println("존재하는 ID");
				else
					System.out.println("존재하지 않는 ID");
				System.out.println();
				break;
			case 3: // 3일때 삭제
				System.out.print("삭제할 ID 입력: ");
				if (b.remove(scanner.next()))
					System.out.println("삭제 성공");
				else
					System.out.println("삭제 실패");
				System.out.println();
				break;
			case 4: // 4일때 전체조회
				System.out.println("--전체조회--");
				System.out.println("현재 저장된 ID의 개수: " + b.size(b.getRoot()));
				System.out.print("저장된 ID 출력: ");
				b.print();
				System.out.println();
				break;
			case 5: // 5일때 종료
				System.out.println("종료");
				break whileout; // 다중 반복문 빠져나오는 break
			}
		}
		scanner.close();

	}

}
