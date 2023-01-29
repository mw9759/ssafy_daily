package com.ssafy.ws.step3.chapter10;

import java.io.Serializable;

/**
 * 도서 정보를 나타내는 클래스
 */
public class Book implements Serializable{
	//도서번호
	private String isbn;
	//제목
	private String title;
	//저자
	private String author;
	//출판사
	private String publisher;
	//가격
	private int price;
	//도서설명
	private String desc;
	//재고
	private int quantity;
	
	//생성자
	public Book() {}
	//초기화 생성자 
	public Book(String isbn, String title, String author, String publisher, int price
			, String desc, int quantity) {
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
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%-10s", isbn));
		builder.append("| ");
		builder.append(String.format("%-15s", title));
		builder.append("| ");
		builder.append(String.format("%-10s", author));
		builder.append("| ");
		builder.append(String.format("%-10s", publisher));
		builder.append("| ");
		builder.append(String.format("%7d", price));
		builder.append("| ");
		builder.append(String.format("%-10s", desc));
		builder.append("| ");
		builder.append(String.format("%-4d", quantity));
		return builder.toString();
	}
	
	
}