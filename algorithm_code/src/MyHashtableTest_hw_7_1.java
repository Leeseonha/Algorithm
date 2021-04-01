
/* **************************
 파일명: MyHashtableTest_hw_7_1.java
 작성자: IT융합자율학부 201814028 이선하
 작성일: 2020.05.12
 내용:  학번을 저장해 두고 검색하는 해시 테이블 프로그램. 학번(양의 정수)은 key로서 중복되지 않음.
 		class MyHashtableTest_hw_7_1: 해시테이블을 사용하여 학번을 관리하는 프로그램
 		class MyHashtable: 학번을 저장하는 해시테이블. 충돌해결기법은 linear probing, 해시함수는 division method
 ************************** */

import java.util.Scanner;

class MyHashtable {
	// (1)private필드
	private int[] table; // 해시테이블
	private int m; // 해시테이블 크기
	private static final int EMPTY = -1; // 비어있는 자리임을 나태내는 값
	private static final int DELETED = -2; // 삭제된 자리임을 나타내는 값

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

	// (2)생성자 - 크기가 size인 해시테이블을 생성
	public MyHashtable(int size) {
		table = new int[size];
		m = size;
		for (int i = 0; i < size; i++) {
			table[i] = EMPTY;
		}
	}

	// (2)put - 해시테이블에 key 값을 삽입하고 삽입 성공 여부를 리턴. 이미 있는 학번이면 삽입 실패
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
		// 이 메소드를 완성하세요
		return key % m;
	}

	// linear probing i번째 해시 함수 hi(x) = (h(x) + i) mod m
	private int hash(int i, int x) {
		if (x == EMPTY) {
			return 0;
		}
		return (i + x) % m;
	}
}

public class MyHashtableTest_hw_7_1 {
	public static void main(String[] args) {

		System.out.println("hw7_1 : 이선하  \n");

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
				System.out.print("삽입할 학번(정수값)을 입력하세요: ");
				int id = scanner.nextInt();
				if (studentTable.put(id))
					System.out.println(id + "삽입 성공");
				else
					System.out.println(id + "삽입 실패");
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
