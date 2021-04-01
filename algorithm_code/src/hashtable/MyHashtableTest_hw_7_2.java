//제출안함
/* **************************
 파일명: MyHashtableTest_hw_7_2.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.05.12
 내용:  <학번,성적>을 저장해 두고 검색하는 해시 테이블 프로그램. 충돌해결 방법은 chaining.
 	   학번(양의 정수)은 key로서 중복되지 않음. 성적(정수)은 Value로서 학번으로부터 구하고자 하는 값이다. 
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
	private int m; // 해시테이블 크기
	private static final int EMPTY = -1; // 비어있는 자리임을 나태내는 값

	// (2)생성자 - 크기가 size인 해시테이블을 생성
	public MyHashtable(int size) {
		m = size;
		arr = new Node[size];
		for(int i =0; i<size;i++)
			arr[i] = new Node();
	}

	// (2)put - 학번,성적을 매개변수로 받아 테이블에 삽입. 이미 있는 학번이면 성적 갱신
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

	// 해시테이블에 key 값을 검색하여 인덱스를 리턴. 검색 실패시 -1 리턴
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

	// (2)contains - 해시테이블에 key 값을 검색하고 검색 성공 여부를 리턴
	public boolean contains(int key) {
		int index = search(key);
		return (index >= 0);
	}

	// (2)remove - 해시테이블에서 key 값을 삭제하고 삭제 성공 여부를 리턴. 존재하지 않는 학번이면 삭제 실패
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

	// (2)print - 해시테이블의 구현을 확인하기 위해 해시 테이블의 구조를 모두 출력(내용이 없이 빈칸이거나 DELETED이어도 출력)
	public void print() {
		System.out.println("해시테이블 내용: ");
		for (int i = 0; i < m; i++) {
			if (table[i] == EMPTY)
				System.out.println("[" + i + "] ");
			else if (table[i] == DELETED)
				System.out.println("[" + i + "] DELETED");
			else
				System.out.println("[" + i + "] " + table[i]);
		}
	}

	// division method 해시 함수 h(x) = x mod m
	private int hashFunction(int key) {
		return key % m;
	}
}

public class MyHashtableTest_hw_7_2 {
	public static void main(String[] args) {

		System.out.println("hw7_2 : 이선하  \n");

		// 해시테이블 크기(size)를 입력받음
		Scanner scanner = new Scanner(System.in);
		System.out.print("해시테이블 크기 입력: ");
		int size = scanner.nextInt();

		// 크기가 size인 해시테이블을 생성
		MyHashtable studentTable = new MyHashtable(size);

		// 해시테이블 연산을 반복하여 수행
		int menu = 0;
		do {
			System.out.print("\n1:삽입 2:검색 3:삭제 4:테이블출력 5:종료 --->");
			menu = scanner.nextInt();

			switch (menu) {
			case 1:
				System.out.print("삽입할 학번(정수값), 성적(정수값)을 입력하세요: ");
				int id = scanner.nextInt();
				int grade = scanner.nextInt();
				if (studentTable.put(id, grade))
					System.out.println("학번: " + id + ", 성적: " + grade + "삽입 성공");
				else
					System.out.println("학번: " + id + ", 성적: " + grade + "삽입 실패");
				break;
			case 2:
				System.out.print("검색할 학번(정수값)을 입력하세요: ");
				id = scanner.nextInt();
				if (studentTable.contains(id))
					System.out.println(id + "학생을 찾았습니다.");
				else
					System.out.println(id + "학생을 찾을 수 없습니다.");
				break;
			case 3:
				System.out.print("삭제할 학번(정수값)을 입력하세요: ");
				id = scanner.nextInt();
				if (studentTable.remove(id))
					System.out.println(id + "삭제 성공");
				else
					System.out.println(id + "삭제 실패");
				break;
			case 4:
				studentTable.print();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호가 잘못되었습니다. 다시 입력하세요.");
			}
		} while (menu != 5);

		scanner.close();
	}

}
