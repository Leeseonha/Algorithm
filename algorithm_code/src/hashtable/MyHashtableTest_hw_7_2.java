//�������
/* **************************
 ���ϸ�: MyHashtableTest_hw_7_2.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.05.12
 ����:  <�й�,����>�� ������ �ΰ� �˻��ϴ� �ؽ� ���̺� ���α׷�. �浹�ذ� ����� chaining.
 	   �й�(���� ����)�� key�μ� �ߺ����� ����. ����(����)�� Value�μ� �й����κ��� ���ϰ��� �ϴ� ���̴�. 
 ************************** */

package hashtable;

import java.util.Scanner;

class MyHashtable {
	private class Node{
		int key;
		int value;
		Node next;
		public Node() {
			key = EMPTY;
			value = EMPTY;
			next = null;
		}
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			next = null;
		}
		
		public int getKey() {
			return key;
		}
		
		public void setKey(int key) {
			this.key = key;
		}
		
		public int getValue() {
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
	}
	
	private Node arr[];
	private int m; // �ؽ����̺� ũ��
	private static final int EMPTY = -1; // ����ִ� �ڸ����� ���³��� ��

	// (2)������ - ũ�Ⱑ size�� �ؽ����̺��� ����
	public MyHashtable(int size) {
		m = size;
		arr = new Node[size];
		for(int i =0; i<size;i++)
			arr[i] = new Node();
	}

	// (2)put - �й�,������ �Ű������� �޾� ���̺� ����. �̹� �ִ� �й��̸� ���� ����
	public boolean put(int key, int value) {
		Node newNode = new Node(key,value);
		int index = hashFunction(key);
		if(arr[index].next == null) {
			arr[index].next = newNode;
			return true;
		}
		
		
		
		
		if (table[hash] == EMPTY) {
			table[hash] = new int(key, value);
		}
		else {
			int current = table[hash];
			while(true) {
				if(current == key && current == value) {
					return false;
				}
				else if(current == EMPTY) {
					current = new HashItem(key, value);
					return true;
				}
			}
		}
		return true;

	}

	// �ؽ����̺� key ���� �˻��Ͽ� �ε����� ����. �˻� ���н� -1 ����
	public int search(int key) {
		int hashVal = hashFunction(key);
		while (table[hashVal] != EMPTY) {
			if (table[hashVal] == key)
				return table[hashVal];
			++hashVal;
			hashVal %= m;
		}
		return -1;
	}

	// (2)contains - �ؽ����̺� key ���� �˻��ϰ� �˻� ���� ���θ� ����
	public boolean contains(int key) {
		int index = search(key);
		return (index >= 0);
	}

	// (2)remove - �ؽ����̺��� key ���� �����ϰ� ���� ���� ���θ� ����. �������� �ʴ� �й��̸� ���� ����
	public boolean remove(int key) {
		int hashVal = hashFunction(key);
		if (key == EMPTY) {
			return false;
		}
		while (table[hashVal] != EMPTY) {
			if (table[hashVal] == key) {
				int temp = table[hashVal];
				table[hashVal] = DELETED;
				return true;
			}
			++hashVal;
			hashVal %= m;
		}
		return false;

	}

	// (2)print - �ؽ����̺��� ������ Ȯ���ϱ� ���� �ؽ� ���̺��� ������ ��� ���(������ ���� ��ĭ�̰ų� DELETED�̾ ���)
	public void print() {
		System.out.println("�ؽ����̺� ����: ");
		for (int i = 0; i < m; i++) {
			if (table[i] == EMPTY)
				System.out.println("[" + i + "] ");
			else if (table[i] == DELETED)
				System.out.println("[" + i + "] DELETED");
			else
				System.out.println("[" + i + "] " + table[i]);
		}
	}

	// division method �ؽ� �Լ� h(x) = x mod m
	private int hashFunction(int key) {
		return key % m;
	}
}

public class MyHashtableTest_hw_7_2 {
	public static void main(String[] args) {

		System.out.println("hw7_2 : �̼���  \n");

		// �ؽ����̺� ũ��(size)�� �Է¹���
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ؽ����̺� ũ�� �Է�: ");
		int size = scanner.nextInt();

		// ũ�Ⱑ size�� �ؽ����̺��� ����
		MyHashtable studentTable = new MyHashtable(size);

		// �ؽ����̺� ������ �ݺ��Ͽ� ����
		int menu = 0;
		do {
			System.out.print("\n1:���� 2:�˻� 3:���� 4:���̺���� 5:���� --->");
			menu = scanner.nextInt();

			switch (menu) {
			case 1:
				System.out.print("������ �й�(������), ����(������)�� �Է��ϼ���: ");
				int id = scanner.nextInt();
				int grade = scanner.nextInt();
				if (studentTable.put(id, grade))
					System.out.println("�й�: " + id + ", ����: " + grade + "���� ����");
				else
					System.out.println("�й�: " + id + ", ����: " + grade + "���� ����");
				break;
			case 2:
				System.out.print("�˻��� �й�(������)�� �Է��ϼ���: ");
				id = scanner.nextInt();
				if (studentTable.contains(id))
					System.out.println(id + "�л��� ã�ҽ��ϴ�.");
				else
					System.out.println(id + "�л��� ã�� �� �����ϴ�.");
				break;
			case 3:
				System.out.print("������ �й�(������)�� �Է��ϼ���: ");
				id = scanner.nextInt();
				if (studentTable.remove(id))
					System.out.println(id + "���� ����");
				else
					System.out.println(id + "���� ����");
				break;
			case 4:
				studentTable.print();
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�޴� ��ȣ�� �߸��Ǿ����ϴ�. �ٽ� �Է��ϼ���.");
			}
		} while (menu != 5);

		scanner.close();
	}

}
