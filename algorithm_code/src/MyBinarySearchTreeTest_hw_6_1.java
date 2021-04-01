
/* **************************
 ���ϸ�: MyBinarySearchTreeTest_hw_6_1.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.04.30
 ����:  ���̵� �����ϴ� �����˻�Ʈ�� ���α׷�.
 	    ���̵�� ���ڿ��̸�, �ߺ����� �ʴ´�.
1:���� - ����ڷκ��� ���̵� �Է¹޾� Ʈ���� �����ϰ�, ���� ���� ���θ� �˸�
2:�˻� - ����ڷκ��� ���̵� �Է¹޾� Ʈ���� �����ϴ� ���̵����� �˻�
3:���� - ����ڷκ��� ���̵� �Է¹޾� Ʈ������ �����ϰ�, ���� ���� ���θ� �˸� ************ ���� ������
4:��ü��ȸ - Ʈ���� ����� ���̵��� ������ ����ϰ�, ����� ���̵� ��� ���
 ************************** */

import java.util.Scanner;

class MyBinarySearchTree {
	// (1)private�ʵ�
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

	// (2)print() - Ʈ���� ����� ���̵� ��� ���
	public void print() {
		inorder(root);
		System.out.println();

	}

	// (2)size() - Ʈ���� ����� ���̵� ��(��� ��)�� ����
	public int size(Node root) {
		int idNum;
		if (root == null) {
			idNum = 0;
		} else {
			idNum = size(root.left) + size(root.right) + 1;
		}
		return idNum;
	}

	// (2)Ž��/�˻�(contanins) ���� - Ʈ���� ���̵� �����ϴ��� ���� �˻�
	public boolean contanins(String id) {
		Node current = root;
		while (current != null) {
			if (id.compareTo(current.getId()) == 0) { // ���� ���� ã�� ���� ������
				return true;
			} else if (id.compareTo(current.getId()) < 0) { // ã�� ���� ���� ��庸�� ������
				current = current.getLeft();
			} else { // ã�� ���� ���� ��庸�� ũ��
				current = current.getRight();
			}
		}
		return false;
	}

	// (2)����(add) ���� - Ʈ���� ���̵� ����. �̹� �����ϴ� ���̵�� ���� ����
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

	// (2)����(remove) ���� - Ʈ������ ���̵� ����. �������� �ʴ� ���̵�� ���� ����
	public boolean remove(String id) {
		Node parent = root; // ������ ����� �θ��带 ����Ŵ
		Node current = root; // ������ ��带 ����Ŵ
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
			if (current == null) { // ã�� ��尡 null�� ���
				return false;
			}
		}
		// case 1: �ڽĳ�尡 ���� ���
		if (current.getLeft() == null && current.getRight() == null) {
			if (current == root) {
				root = null;
			} else if (isLeftChild == true) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}
		// case 2: �ϳ��� �ڽ��� ���� ���
		else if (current.getRight() == null) { // ������ ����� ������ �ڽ� ��尡 null�� ���
			if (current == root) {
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else if (current.getLeft() == null) { // ������ ����� ���� �ڽ� ��尡 null�� ���
			if (current == root) {
				root = current.getRight();
			} else if (isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		}
		// case 3: �ΰ��� �ڽ��� ���� ���
		else {
			Node rightSubTree = current.getRight(); // ������ ����� �����ʼ���Ʈ���� ����
			temp = getRightmin(current.getRight()); // �ش� ����� �����ʼ���Ʈ������ ���� ���� ������ ��ü
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

	// (3)private�޼ҵ�-inorder():�߼��� ��ȸ�ϸ� Ű���� ���
	private void inorder(Node t) { // ��� �޼ҵ�
		if (t != null) {
			inorder(t.left);
			System.out.print(t.getId() + " ");
			inorder(t.right);
		}

	}

	// (4)Ʈ���� ��� ������ �����ϴ� privateŬ���� - ���̵�(���ڿ�)�ʵ�, �����ڽĸ�ũ�ʵ�, �������ڽĸ�ũ�ʵ�
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

		System.out.println("hw6_1 : �̼���  \n");

		MyBinarySearchTree b = new MyBinarySearchTree();

		int menu = 0;

		whileout: // ���� �ݺ��� ���������� �ݺ��� �̸� whileout���� ����
		while (true) {
			System.out.println("�޴� - [1:���� 2:�˻� 3:���� 4:��ü��ȸ 5:����]");
			System.out.print("�޴��� �����Ͻÿ�: ");
			menu = scanner.nextInt();
			switch (menu) {
			case 1: // 1�϶� ����
				System.out.print("������ ID �Է�: ");
				if (b.add(scanner.next()))
					System.out.println("���� ����");
				else
					System.out.println("���� ����");
				System.out.println();
				break;
			case 2: // 2�϶� �˻�
				System.out.print("�˻��� ID �Է�: ");
				if (b.contanins(scanner.next()))
					System.out.println("�����ϴ� ID");
				else
					System.out.println("�������� �ʴ� ID");
				System.out.println();
				break;
			case 3: // 3�϶� ����
				System.out.print("������ ID �Է�: ");
				if (b.remove(scanner.next()))
					System.out.println("���� ����");
				else
					System.out.println("���� ����");
				System.out.println();
				break;
			case 4: // 4�϶� ��ü��ȸ
				System.out.println("--��ü��ȸ--");
				System.out.println("���� ����� ID�� ����: " + b.size(b.getRoot()));
				System.out.print("����� ID ���: ");
				b.print();
				System.out.println();
				break;
			case 5: // 5�϶� ����
				System.out.println("����");
				break whileout; // ���� �ݺ��� ���������� break
			}
		}
		scanner.close();

	}

}
