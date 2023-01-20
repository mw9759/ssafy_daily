package com.ssafy.ws.step6_3.copy;

public class BookManager1 {
	/** 도서정보 저장 배열. 자료저장구조 최대크기 상수 설정.*/
	private static int MAX_SIZE = 100;
	
	/** 도서저장위한 배열객체 멤버변수: 다형성 부보타입 참조변수는 부모 및 모든 자식클래스를 참조할 수 있는 기억공간*/
	private Book1[] books = new Book1[MAX_SIZE];
	
	/** 도서의 등록갯수 및 도서 추가 등록시 배열요소 인덱스 번호 멤버변수.*/
	private int size;
	
	/** 도서 등록 권수 조회*/
	public int getSize() {
		return size;
	}
	
	/** 도서의 존재 유무 및 저장위치 인덱스 조회*/
	public int isBook(String isdn) {
		for(int index = 0; index < size; index++) {
			if(books[index].getIsbn().equals(isdn)) {
				return index;
			}
		}
		return -1;
	}
	
	/** 도서 등록
	 * - 체킹 조건: 1. 동일도서번호 존재여부, 2. 배열최대크기의 등록도서 크기 비교.
	 *  */
	public void add(Book1 b) {
		if(size < MAX_SIZE) {
			if(isBook(b.getIsbn()) == -1){
				books[size++] = b;
			}else {
				System.out.printf("%s 도서번호는 이미 등록되어 있습니다.\n", b.getIsbn());
			}
		}else {
			System.out.printf("%s 도서번호는 이미 등록되어 있습니다.\n", b.getIsbn());
		}
	}
	
	
	//도서삭제
	public void remove(String isbn) {
		int index = isBook(isbn);
		if (index >= 0){
			books[index] = books[--size];
			books[size] =null;
		}else {
			System.out.println("삭제불가"+isbn);
		}
	}
	
	//전체 도서 조회
	public Book1[] getList() {
		Book1[] tmpArr = new Book1[size];
		for (int index = 0; index < size; index++) {
			tmpArr[index] = books[index];
		}
		return tmpArr;
	}
	
	//잡지만 불러오기
	public Magazine1[] getMagazines() {
		int mg_count = 0;
		for(int idx = 0; idx < this.size; idx++) {
			if(books[idx] instanceof Magazine1) {
				mg_count++;
			}
		}
		if(mg_count == 0) {
			return null;
		}
		Magazine1[] magazine = new Magazine1[mg_count];
		
		int a = 0;
		for(int index = 0; index < this.size; index++) {
			if(books[index] instanceof Magazine1) {
				magazine[a++] = (Magazine1)books[index];
			}
		}
		
		return magazine;
	}
	
	//일반도서만 불러오기
	public Book1[] getBooks() {
		int nb_counts = 0;
		for(int idx = 0; idx < this.size; idx++) {
			if(!(books[idx] instanceof Magazine1)) {
				nb_counts++;
			}
		}
		
		if(nb_counts == 0) {
			return null;
		}
		Book1[] n_books = new Book1[nb_counts];
		
		int a = 0;
		for(int index = 0; index < this.size; index++) {
			if(!(books[index] instanceof Magazine1)) {
				n_books[a++] = (Book1)books[index];
			}
		}
		
		return n_books;
		
	}

	//도서번호로 조회
	public Book1 searchByisbn(String isbn) {
		int index = isBook(isbn);
		if(index >= 0) {
			return books[index];
		}
		System.out.println("오류. 해당 도서를 찾을 수 없습니다."+isbn);
		return null;
	}
	
	//도서 제목으로 조회
	public Book1[] searchByTitle(String title) {
		Book1[] tmpBooks = getList();//현재 등록된 전체 도서 정보
		Book1[] titleBooks = new Book1[size];
		
		int tmpSize = 0; // title로 검색된 도서의 숫자
		
		for (int index = 0; index < tmpBooks.length; index++) {
			if(tmpBooks[index].getTitle().contains(title)) {
				titleBooks[tmpSize++] = tmpBooks[index];
			}
		}
		if(tmpSize == 0)
			return null;
		Book1[] resultBooks = new Book1[tmpSize];
		for(int index = 0; index < tmpSize; index++) {
			resultBooks[index] = titleBooks[index];
		}
		
		return resultBooks;
	}
	
	/* 도러리스트 가격의 총합**/
	public int sum_price() {
		int sum_p = 0;
		for(int i = 0; i < size; i++) {
			sum_p += books[i].getPrice();
		}
		return sum_p;
	}
	
	/** 
	 * 제목줄 출력 메서드
	 * @param head 제목
	 * */
	public void printHead(String head) {
		System.out.printf("########## %s ##########%n", head);
	}
	
}
