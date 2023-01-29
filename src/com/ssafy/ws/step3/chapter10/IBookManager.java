package com.ssafy.ws.step3.chapter10;

/**
 * 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스
 */
public interface IBookManager {
	public void add(Book book);
	public void remove(String isbn);
	public Book[] getList();
	public Book searchByIsbn(String isbn);
	public Book[] searchByTitle(String title);
	public Magazine[] getMagazines();
	public Book[] getBooks();
	public int getTotalPrice();
	public double getPriceAvg();
	void printHead(String head);
	
	//exceptions
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException;
	public void buy(String isbn, int quantity) throws ISBNNotFoundException;
	
	//file i/o
	public void saveData();
	public void loadData();
}