package com.ssafy.ws.step3.chapter10;

import java.io.Serializable;

/**
 * 도서 정보를 나타내는 클래스
 */
public class Book implements Serializable{ //중요.입출력시에 필수.
	private static final long serialVersionUID = 1L; //직렬화 객체시 지정하는 ID
	//도서번호
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	private int quantity;
	/* 기본 생성자 */
	public Book() {}
	
	/** 전체데이터 초기화 생성자
	 * @param isbn
	 * @param title
	 * @param author
	 * @param publisher
	 * @param price
	 * @param desc
	 * */
	public Book(String isbn, String title, String author,
			String publisher, int price, String desc, int quantity) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity = quantity;
	}
	
	
	
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%-8s",isbn));
		builder.append("|");
		builder.append(String.format("%-9s",title));
		builder.append("|");
		builder.append(String.format("%-10s",author));
		builder.append("|");
		builder.append(String.format("%-10s",publisher));
		builder.append("|");
		builder.append(String.format("%-10s",price));
		builder.append("|");
		builder.append(String.format("%-15s",desc));
		builder.append("|");
		builder.append(String.format("%-15s",quantity));
		return builder.toString();
	}
}
