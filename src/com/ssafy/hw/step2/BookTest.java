package com.ssafy.ws.step3;

/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {

	public static void main(String[] args) {
		//코드를 작성해주세요. 
		Book book1 = new Book("1231","열정","영희","싸피",12000,"문법");
		Book book2 = new Book("1232","희망","철수","싸피",13000,"기본");
		Book book3 = new Book("1233","꿈","수민","싸피",11000,"기초");
		Magazine magazine1 = new Magazine("1234","꿈","희수","싸피",11000,"필수",2021,12);
		
		BookManager mnbook = new BookManager();
		
		mnbook.add(book1);
		mnbook.add(book2);
		mnbook.add(book3);
		mnbook.add(book3);
		mnbook.add(magazine1);
		Book[] newlist = new Book[100];
		newlist=mnbook.getList();
		mnbook.searchByIsbn("1233");
		mnbook.remove("1233");
		mnbook.remove("1233");
		newlist=mnbook.getList();
		mnbook.add(book3);
		mnbook.searchByTitle("꿈");
		mnbook.getBooks();
		mnbook.getMagazines();
		
		mnbook.getTotalPrice();
		mnbook.getPriceAvg();
		

	}
}
