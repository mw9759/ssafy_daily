package com.ssafy.ws.step5_3;
/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManager {
	private Book[] books;
	
	private static int MAX_SIZE = 100;
	
	private int size;
	
	//클래스 기본 생성자
	public BookManager() {
		books = new Book[MAX_SIZE];
	}
	
	/** 도서의 존재 유무 및 저장위치 인덱스 조회*/
	public int checkIsbn(String isbn) {
		for(int i = 0; i < size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				return i;
			}
		}
		return -1;
	}
	
	//도서추가
	public void add(Book b) {
		if(size<MAX_SIZE) {
			if(checkIsbn(b.getIsbn())==-1) {
				books[size++] = b;
			}else {
				System.out.printf("%s 도서는 이미 등록되어 있습니다.\n", b.getIsbn());
			}
		}else {
			System.out.println("등록 공간이 부족합니다.");
		}
	}
	
	//전체 도서 리스트 출력
	public Book[] getList() {
		Book[] tmpArr = new Book[size];
		for (int index = 0; index < size; index++) {
			tmpArr[index] = books[index];
		}
		return tmpArr;
	}
	
	//도서 삭제
	public Book[] remove(String isbn) {
		int index = checkIsbn(isbn);
		Book[] afterRemov = new Book[size-1];
		if(index == -1) {
			System.out.println("삭제하려는 도서는 존재하지 않습니다.");
		}else {
			books[index] = books[--size];
			books[size] = null;
		}
		return getList();
	}
	
	//도서 고유정보로 도서정보 반환
	public Book searchByIsbn(String isbn) {
		Book book = new Book();
		if(checkIsbn(isbn) == -1) {
			System.out.println("입력하신 도서 정보는 없습니다. (입력 도서번호: "+isbn+" )");
			return null;
		}else {
			return books[checkIsbn(isbn)];
		}
	}
	
	//목록 구분렬 생성
	public void starBar(String s) {
		System.out.printf("********** %s **********\n", s);
	}
}
