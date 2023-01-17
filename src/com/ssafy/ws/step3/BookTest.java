package com.ssafy.ws.step3;

/**
 * 도서 객체를 생성하고 정보를 출력하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		System.out.println("*******************도서목록********************");
		Book bk1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book bk2 = new Book("35355", "분석설계      ", "소나무", "jaen.kr", 30000, "SW 모델링         ");
		System.out.println(bk1);
		System.out.println(bk2);
	}
}
