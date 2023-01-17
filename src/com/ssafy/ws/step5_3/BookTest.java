package com.ssafy.ws.step5_3;


/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {
	public static Book bk1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
	public static Book bk3 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
	public static Book bk2 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
	
	public static void main(String[] args) {
		Book[] books = null;
		Book book = null;
		
		BookManager bm = new BookManager();
		
		bm.add(bk1);
		bm.add(bk2);
		bm.add(bk3);
		System.out.println("********************도서목록********************");
		books = bm.getList();
		for (Book m : books) {
			System.out.printf("%-15s| %-15s| %-15s| %-15s| %-15s| %-15s%n",
					m.getIsbn(), m.getTitle(), m.getAuthor(), m.getPublisher(), m.getPrice(), m.getDesc());
		}
		
	}
}
