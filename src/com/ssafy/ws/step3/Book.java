package com.ssafy.ws.step3;
/**
 * 도서 정보를 나타내는 클래스
 */
public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;

	public Book() {};

	public Book(String isbn, String title, String author, String publisher, int price, String desc){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isbn);
		builder.append("	|");
		builder.append(title);
		builder.append("	|");
		builder.append(author);
		builder.append("	|");
		builder.append(publisher);
		builder.append("	|");
		builder.append(price);
		builder.append("	|");
		builder.append(desc);
		return builder.toString();
	}//"%-20s\t| %-20s%n", m.getMemberId(), m.getName()
}

