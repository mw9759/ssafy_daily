package com.ssafy.ws.step6_3;
// private- <   <  #protected <+public 
public class Book1 {
	//도서번호
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	
	/* 기본 생성자 */
	public Book1() {}
	
	/** 전체데이터 초기화 생성자
	 * @param isbn
	 * @param title
	 * @param author
	 * @param publisher
	 * @param price
	 * @param desc
	 * */
	public Book1(String isbn, String title, String author,
			String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
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
		builder.append(String.format("%-20s",author));
		builder.append("|");
		builder.append(String.format("%-20s",publisher));
		builder.append("|");
		builder.append(String.format("%-20s",price));
		builder.append("|");
		builder.append(String.format("%-20s",desc));
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
//	@Override
//	public String toString() {
//		return String.format("%-20s| %-20s| %-20s| %-20s| %-20s| %-20s", isbn, title, author, publisher, price, desc);
//	}
//	
	
	
	
	
}

