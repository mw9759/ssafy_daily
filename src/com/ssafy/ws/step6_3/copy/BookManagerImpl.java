package com.ssafy.ws.step6_3.copy;

public class BookManagerImpl implements IBookManager {
	/* Singletone Pattern 적용 설계**/
	/** 도서의 등록갯수 및 도서 추가 등록시 배열요소 인덱스 번호 멤버변수.*/
	private int size = 0;
	
	private static BookManagerImpl instance = new BookManagerImpl();
	private BookManagerImpl() {}
	
	public static BookManagerImpl getInstance() {
		return instance;
	}
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int isBook(String isdn) {
		for(int index = 0; index < size; index++) {
			if(books[index].getIsbn().equals(isdn)) {
				return index;
			}
		}
		return -1;
	}

	@Override
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

	@Override
	public void remove(String isbn) {
		int index = isBook(isbn);
		if (index >= 0){
			books[index] = books[--size];
			books[size] =null;
		}else {
			System.out.println("삭제불가"+isbn);
		}
	}

	@Override
	public Book1[] getList() {
		Book1[] tmpArr = new Book1[size];
		for (int index = 0; index < size; index++) {
			tmpArr[index] = books[index];
		}
		return tmpArr;
	}

	@Override
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

	@Override
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

	@Override
	public Book1 searchByisbn(String isbn) {
		int index = isBook(isbn);
		if(index >= 0) {
			return books[index];
		}
		System.out.println("오류. 해당 도서를 찾을 수 없습니다."+isbn);
		return null;
	}

	@Override
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

	@Override
	public int sum_price() {
		int sum_p = 0;
		for(int i = 0; i < size; i++) {
			sum_p += books[i].getPrice();
		}
		return sum_p;
	}
	
	@Override
	public void printHead(String head) {
		System.out.printf("########## %s ##########%n", head);
	}

}
