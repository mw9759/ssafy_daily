package com.ssafy.ws.step5_3;
/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {
	public static Book bk1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
	public static Book bk3 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
	public static Book bk2 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
	public static void main(String[] args) {
		
		BookManager bm = new BookManager();
		
		bm.add(bk1);
		bm.add(bk2);
		bm.add(bk3);
		
		//전체 도서 목록 출력
		bm.starBar("전체 도서 목록");
		for (Book m : bm.getList()) {
			System.out.println(m);
		}
		
		//도서번호에 해당하는 도서조회
		bm.starBar("도서조회: 21424");
		System.out.println(bm.searchByIsbn("21424"));
		
		//도서 삭제 및 삭제 후의 도서목록 출력
		bm.starBar("도서삭제: 21424");
		bm.starBar("삭제 후 도서 목록");
		for(Book m : bm.remove("21424")) {
			System.out.println(m);
		}
	}
}
