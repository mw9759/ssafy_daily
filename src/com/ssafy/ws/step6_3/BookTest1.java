package com.ssafy.ws.step6_3;


public class BookTest1 {
	/** 도서 초기화 정보 */
	//일반도서
	public static Book1 b1 = new Book1("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본문법");
	public static Book1 b2 = new Book1("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
	public static Book1 b3 = new Book1("35355", "분석설계        ", "소나무", "jaen.kr", 30000, "SW 모델링");
	//잡지
	public static Magazine1 b4 = new Magazine1("45678", "월간 알고리즘 ", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);
	
	public static void main(String[] args) {
		Book1[] books = null;
		Book1 book = null;
		
		BookManager1 bm = new BookManager1();
		
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(b4);
		books = bm.getList();
		
		System.out.println("********************도서 전체 목록********************");
		for (Book1 m : books) {
			System.out.println(m);
		}
		
		System.out.println();
		System.out.println("********************잡지 전체 목록********************");
		for(Book1 n : bm.getMagazines()) {
			System.out.println(n);
		}
		
		System.out.println();
		System.out.println("********************일반도서 전체 목록********************");
		for(Book1 n : bm.getBooks()) {
			System.out.println(n);
		}
		
	}
}
