package com.ssafy.ws.step6_3.copy;


public class BookTest1 {
	/** 도서 초기화 정보 */
	//일반도서
	public static Book1 b1 = new Book1("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본문법");
	public static Book1 b2 = new Book1("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용");
	public static Book1 b3 = new Book1("35355", "분석설계        ", "소나무", "jaen.kr", 30000, "SW 모델링");
	//잡지
	public static Magazine1 b4 = new Magazine1("45678", "월간 알고리즘 ", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1);
	
	public static void main(String[] args) { // 인터페이스 이용.
		//도서 관리 기능을 사용하기 위한 BookManagerImpl 객체 생성 사용
		IBookManager mngr1 = BookManagerImpl.getInstance();
		BookManagerImpl mngr = BookManagerImpl.getInstance();
		Book1[] books = null;
		Book1 book = null;
		
		mngr.add(b1);
		mngr.add(b2);
		mngr.add(b3);
		books = mngr.getList();
		
		/* 전체 도서 목록 출력 **/
		mngr.printHead("도서 전체 목록");
		for (Book1 m : books) {
			System.out.println(m);
		}
	}
	
	
	public static void main1(String[] args) { //상속 이용.
		Book1[] books = null;
		Book1 book = null;
		
		BookManager1 bm = new BookManager1();
		
		bm.add(b1);
		bm.add(b2);
		bm.add(b3);
		bm.add(b4);
		books = bm.getList();
		
		/* 전체 도서 목록 출력 **/
		bm.printHead("도서 전체 목록");
		for (Book1 m : books) {
			System.out.println(m);
		}
		
		/* 잡지 목록만 출력 **/
		System.out.println();//공백 라인
		bm.printHead("잡지 전체 목록");
		for(Book1 n : bm.getMagazines()) {
			System.out.println(n);
		}
		
		/* 일반 도서 목록만 출력 **/
		System.out.println();
		bm.printHead("일반도서 전체 목록");
		for(Book1 n : bm.getBooks()) {
			System.out.println(n);
		}
		
		/* 도서번호로 해당 도서 정보 출력**/
		System.out.println();
		bm.printHead("입력(도서 번호)하신 도서 정보");
		System.out.println(bm.searchByisbn("21424"));
		
		/* 도서 제목 검색해서 해당 도서 정보 출력**/
		System.out.println();
		bm.printHead("입력(도서 제목)하신 도서 정보");
		for(Book1 n: bm.searchByTitle("Java")) {
			System.out.println(n);
		}
		
		/* 등록된 도서들의 총 가격 **/
		System.out.println();
		bm.printHead("등록된 도서들의 총 가격 ");
		System.out.println(bm.sum_price()+"원");
		
		/* 등록된 도서들의 평균 가격**/
		bm.printHead("등록된 도서들의 총 가격 ");
		System.out.println((double)bm.sum_price()/(bm.getList().length)+"원");
	}
}
