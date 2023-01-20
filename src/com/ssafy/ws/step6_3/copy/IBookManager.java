package com.ssafy.ws.step6_3.copy;

public interface IBookManager {
	static final int MAX_SIZE = 100;
	/** 도서저장위한 배열객체 멤버변수: 다형성 부보타입 참조변수는 부모 및 모든 자식클래스를 참조할 수 있는 기억공간*/
	static Book1[] books = new Book1[MAX_SIZE];
	
	
	public int getSize();
	public int isBook(String isdn);
	public void add(Book1 b);
	public void remove(String isbn);
	public Book1[] getList();
	public Magazine1[] getMagazines();
	//일반도서만 불러오기
	public Book1[] getBooks();
	public Book1 searchByisbn(String isbn);
	public Book1[] searchByTitle(String title);
	public int sum_price();
	public void printHead(String head);
}
