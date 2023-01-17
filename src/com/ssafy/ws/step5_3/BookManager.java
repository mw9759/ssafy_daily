package com.ssafy.ws.step5_3;


/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManager {
	private Book[] books;
	
	public static int MAX_SIZE = 100;
	
	private int size;
	public BookManager() {
		books = new Book[MAX_SIZE];
	}
	
	public void add(Book b) {
		books[size++] = b;
	}
	
	public Book[] getList() {
		Book[] tmpArr = new Book[size];
		for (int index = 0; index < size; index++) {
			tmpArr[index] = books[index];
		}
		return tmpArr;
	}
}
