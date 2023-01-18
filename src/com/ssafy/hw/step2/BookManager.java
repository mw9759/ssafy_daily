package com.ssafy.ws.step3;

/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */
public class BookManager {
	// 멤버변수들
	private int MAX_SIZE = 100;
	private int size = 0;
	private int booksSize = 0;
	private int magazineSize = 0;
	Book[] books = new Book[MAX_SIZE];
	Book[] normalBooks = new Book[MAX_SIZE];
	Magazine[] magazines = new Magazine[MAX_SIZE];
	
	
	//도서 추가할 떄 error 체크
	public boolean addcheck(Book book) {
		for(int a=0;a<size;a++) {
			if (books[a].getIsbn().equals(book.getIsbn())){
				return true;
			}
		}
		return false;
	}
	//도서 삭제할 때 error check
	public boolean removecheck(String isbn) {
		for(int a=0;a<size;a++) {
			if (books[a].getIsbn().equals(isbn)){
				return false;
			}
		}
		return true;
	}
	//일반 도서를 더하는 코드
	public void add(Book book) {
		
		//error 처리
		if (size>100) {
			System.out.println("현재 도서목록이 가득 찼습니다.");
			return;
		}
		if (addcheck(book)) {
			System.out.println("중복입니다");
			return;
		}
		//전체 도서에 추가
		books[size++]=book;
		//일반 도서에 추가
		normalBooks[booksSize++]=book;
		System.out.println("******도서추가:"+book+"******");
		
	}
	//잡지를 더하는 코드
	public void add(Magazine magazine) {
		
		//error 처리
		if (size>100) {
			System.out.println("현재 도서목록이 가득 찼습니다.");
			return;
		}
		if (addcheck(magazine)) {
			System.out.println("중복입니다");
			return;
		}
		
		//전체 도서에 추가
		books[size++]=magazine;
		//잡지에 추가
		magazines[magazineSize++]=magazine;
		System.out.println("******잡지추가:"+magazine+"******");
		
		
	}
	
	//도서 삭제
	public void remove(String isbn) {
		
		//error 처리
		if(size<1) {
			System.out.println("현재 책이 0권입니다.");
			return;
		}
		if(removecheck(isbn)) {
			System.out.println("일치하는 책이 없습니다");
			return;
		}
		
		
		//전체 목록에서 삭제
		for(int num=0;num<size;num++) {
			String check = books[num].getIsbn();
			if(isbn.equals(check)) {
				System.out.println("******도서삭제:"+isbn+"******");
				books[num]=books[size-1];
				books[size-1]=null;
				size--;
			}
		}
		//일반 도서 목록에서 삭제
		for(int num=0;num<booksSize;num++) {
			String check = normalBooks[num].getIsbn();
			if(isbn.equals(check)) {
				normalBooks[num]=normalBooks[booksSize-1];
				normalBooks[booksSize-1]=null;
				booksSize--;
				
			}
		}
		//잡지 목록에서 삭제
		for(int num=0;num<magazineSize;num++) {
			String check = magazines[num].getIsbn();
			if(isbn.equals(check)) {
				System.out.println("******도서삭제:"+isbn+"******");
				magazines[num]=magazines[magazineSize-1];
				magazines[magazineSize-1]=null;
				magazineSize--;
			}
		}
		
	}
	
	//전체 도서 목록
	public Book[] getList() {
		System.out.println("******도서목록******");
		Book[] booklist = new Book[size];
		for(int a=0;a<size;a++) {
			booklist[a]=books[a];
			System.out.println(books[a]);
		}
		return booklist;
	}
	
	//일반 도서 목록
	public Book[] getBooks() {
		System.out.println("******일반 도서목록******");
		Book[] booklist = new Book[booksSize];
		for(int a=0;a<booksSize;a++) {
			booklist[a]=normalBooks[a];
			System.out.println(normalBooks[a]);
		}
		return booklist;
	}
	// 잡지 목록
	public Magazine[] getMagazines() {
		System.out.println("******잡지 목록******");
		Magazine[] magazinelist = new Magazine[magazineSize];
		for(int a=0;a<magazineSize;a++) {
			magazinelist[a]=magazines[a];
			System.out.println(magazines[a]);
		}
		return magazinelist;
	}
	
	//ISBN으로 찾기
	public Book searchByIsbn(String isbn) {
		System.out.println("******도서 isbn 조회:"+isbn+"******");
		boolean check = false;
		for(int a=0;a<size;a++) {
			String listIsbn = books[a].getIsbn();
			if (listIsbn.equals(isbn)) {
				System.out.println(books[a]);
				return books[a];
			}
		}
		System.out.println("******도서 isbn 조회:"+isbn+"은 조회되지 않습니다.******");
		return null;
		
	}
	
	//제목으로 찾기
	public Book[] searchByTitle(String title) {
		System.out.println("******도서 제목 포함 검색:"+title+"******");
		int sameNum=0;
		Book[] sametitle = new Book[size];
		boolean check = false;
		for(int a=0;a<size;a++) {
			String listTitle = books[a].getTitle();
			if (listTitle.contains(title)) {
				System.out.println(books[a]);
				sametitle[sameNum++]=books[a];
			}
		}
		if(sameNum==0) {
			System.out.println("******도서 제목 포함 검색:"+title+"은 조회되지 않습니다.******");
		}
		return sametitle;
		
	}
	//전체가격
	public int getTotalPrice() {
		int sum = 0;
		for(int a=0;a<size;a++) {
			
			sum+=books[a].getPrice();
		}
		System.out.println("도서 가격 총합: "+sum);
		return sum;
	}
	
	//평균 가격
	public double getPriceAvg() {
		int sum = getTotalPrice();
		double avg = sum/size;
		System.out.println("도서 가격 평균: "+avg);
		return avg;
		
	}
	
	public int getSize() {
		return size;
	}
	
	
}
