package com.ssafy.ws.step3.chapter10;

/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {
	
	/** 도서 초기화 정보 */
	//일반도서
	public static Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본문법",10);
	public static Book b2 = new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용",20);
	public static Book b3 = new Book("35355", "분석설계        ", "소나무", "jaen.kr", 30000, "SW 모델링",30);
	//잡지
	public static Magazine b4 = new Magazine("45678", "월간 알고리즘 ", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1);
	
	public static void main(String[] args) { // 인터페이스 이용.
		//도서 관리 기능을 사용하기 위한 BookManagerImpl 객체 생성 사용
		IBookManager mngr1 = BookManagerImpl.getInstance();
		List<Book> books = null;
//		List<Magazine> 
		Book[] books = null;
		Book book = null;
		//파일 불러오기
		mngr1.loadData();
		
		mngr1.add(b1);
		mngr1.add(b2);
		mngr1.add(b3);
		mngr1.add(b4);
		books = mngr1.getList();
		
		
		
		/* 전체 도서 목록 출력 **/
		mngr1.printHead("도서 전체 목록");
		for (Book m : books) {
			System.out.println(m);
		}
		
		/* 잡지 목록만 출력 **/
		System.out.println();//공백 라인
		mngr1.printHead("잡지 전체 목록");
		for(Book n : mngr1.getMagazines()) {
			System.out.println(n);
		}
		
		/* 일반 도서 목록만 출력 **/
		System.out.println();
		mngr1.printHead("일반도서 전체 목록");
		for(Book n : mngr1.getBooks()) {
			System.out.println(n);
		}
		
		/* 도서번호로 해당 도서 정보 출력**/
		System.out.println();
		mngr1.printHead("입력(도서 번호)하신 도서 정보");
		System.out.println(mngr1.searchByisbn("21424"));
		
		/* 도서 제목 검색해서 해당 도서 정보 출력**/
		System.out.println();
		mngr1.printHead("입력(도서 제목)하신 도서 정보");
		for(Book n: mngr1.searchByTitle("Java")) {
			System.out.println(n);
		}
		
		/* 등록된 도서들의 총 가격 **/
		System.out.println();
		mngr1.printHead("등록된 도서들의 총 가격 ");
		System.out.println(mngr1.getTotalPrice()+"원");
		
		/* 등록된 도서들의 평균 가격**/
		mngr1.printHead("등록된 도서들의 평균 가격 ");
		System.out.println(mngr1.getPriceAvg());
		
		/*도서판매*/
		mngr1.printHead("도서판매:21424,11개");
		try {
			mngr1.sell("21424", 11);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
		}
		
		/*도서구매*/
		mngr1.printHead("도서구매:21424,10개");
		try {
			mngr1.buy("21424", 10);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		
		/*도서판매*/
		mngr1.printHead("도서판매:21424,11개");
		try {
			mngr1.sell("21424", 11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
