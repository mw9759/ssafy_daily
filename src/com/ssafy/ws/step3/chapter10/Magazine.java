package com.ssafy.ws.step3.chapter10;
/**
 * 잡지 정보를 나타내는 클래스
 */

public class Magazine extends Book{
	private int year;
	private int month;
	
	//생성자
	public Magazine() {}
	
	//초기화 생성자.
	public Magazine(String isbn, String title, String author, String publisher, int price
			, String desc, int quantity, int year, int month) {
		super(isbn, title, author, publisher, price, desc, quantity);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("| ");
		builder.append(String.format("%4d", year));
		builder.append("| ");
		builder.append(String.format("%4d", month));
		return builder.toString();
	}
}