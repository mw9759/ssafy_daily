package com.ssafy.ws.step6_3;

public class Magazine1 extends Book1{ // 상속 선언
	/** 잡지 년도 */
	private  int year;
	/** 잡지 월 */
	private  int month;
	
	/** 기본 생성자 */
	public Magazine1(String isbn, String title, String author,
			String publisher, int price, String desc,
			int year, int month) {
		super(isbn, title,author, publisher,price, desc);
		this.year = year;
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("|");
		builder.append(String.format("%-10s",year));
		builder.append("|");
		builder.append(String.format("%-10s",month));
		return builder.toString();
	}
}
