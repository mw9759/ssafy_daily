package com.ssafy.ws.step3.chapter10;

/**
 * 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IBookManager {
	//코드를 작성해주세요. 
	static final int MAX_SIZE = 100;
	/** 도서저장위한 배열객체 멤버변수: 다형성 부보타입 참조변수는 부모 및 모든 자식클래스를 참조할 수 있는 기억공간*/
	
	
	public int getSize();
	public int isBook(String isdn);
	public void add(Book b);
	public void remove(String isbn);
	public Book[] getList();
	public Magazine[] getMagazines();
	//일반도서만 불러오기
	public Book[] getBooks();
	public Book searchByisbn(String isbn);
	public Book[] searchByTitle(String title);
	public int getTotalPrice();
	public void printHead(String head);
	public double getPriceAvg();
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException;
	public void buy(String isbn, int quantity) throws ISBNNotFoundException;
	public void saveData();
	public void loadData();
}
