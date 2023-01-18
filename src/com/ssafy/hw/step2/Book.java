package com.ssafy.ws.step3;

/**
 * 도서 정보를 나타내는 클래스
 */
public class Book {
	//코드를 작성해주세요. 
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	
	public Book() {}

	public Book(String isbn, String title, String author, 
			String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isbn);
		builder.append("\t|");
		builder.append(title);
		builder.append("\t|");
		builder.append(author);
		builder.append("\t|");
		builder.append(publisher);
		builder.append("\t|");
		builder.append(price);
		builder.append("\t|");
		builder.append(desc);
		return builder.toString();
	}
	
	
	
}
