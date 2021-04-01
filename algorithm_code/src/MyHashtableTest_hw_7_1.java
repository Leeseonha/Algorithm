
/* **************************
 ���ϸ�: MyHashtableTest_hw_7_1.java
 �ۼ���: IT���������к� 201814028 �̼���
 �ۼ���: 2020.05.12
 ����:  �й��� ������ �ΰ� �˻��ϴ� �ؽ� ���̺� ���α׷�. �й�(���� ����)�� key�μ� �ߺ����� ����.
 		class MyHashtableTest_hw_7_1: �ؽ����̺��� ����Ͽ� �й��� �����ϴ� ���α׷�
 		class MyHashtable: �й��� �����ϴ� �ؽ����̺�. �浹�ذ����� linear probing, �ؽ��Լ��� division method
 ************************** */

import java.util.Scanner;

class MyHashtable {
	// (1)private�ʵ�
	private int[] table; // �ؽ����̺�
	private int m; // �ؽ����̺� ũ��
	private static final int EMPTY = -1; // ����ִ� �ڸ����� ���³��� ��
	private static final int DELETED = -2; // ������ �ڸ����� ��Ÿ���� ��

	private class HashItem {
		private int key;

		public HashItem(int key) {
			this.key = key;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}
	}

	// (2)������ - ũ�Ⱑ size�� �ؽ����̺��� ����
	public MyHashtable(int size) {
		table = new int[size];
		m = size;
		for (int i = 0; i < size; i++) {
			table[i] = EMPTY;
		}
	}

	// (2)put - �ؽ����̺� key ���� �����ϰ� ���� ���� ���θ� ����. �̹� �ִ� �й��̸� ���� ����
	public boolean put(int key) {
		if (key < 0) {
			return false;
		}
		int index = 0;
		int found = search(key);

		if (found == -1) {
			index = hashFunction(key);
			int newHash = hash(index, key);
			while (table[index] != EMPTY && table[index] != DELETED) {
				index++;
				index = index % m;
			}
			table[index] = key;
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
		// �� �޼ҵ带 �ϼ��ϼ���
		return key % m;
	}

	// linear probing i��° �ؽ� �Լ� hi(x) = (h(x) + i) mod m
	private int hash(int i, int x) {
		if (x == EMPTY) {
			return 0;
		}
		return (i + x) % m;
	}
}

public class MyHashtableTest_hw_7_1 {
	public static void main(String[] args) {

		System.out.println("hw7_1 : �̼���  \n");

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
				System.out.print("������ �й�(������)�� �Է��ϼ���: ");
				int id = scanner.nextInt();
				if (studentTable.put(id))
					System.out.println(id + "���� ����");
				else
					System.out.println(id + "���� ����");
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
