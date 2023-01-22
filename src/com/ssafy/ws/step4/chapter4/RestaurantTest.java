package com.ssafy.ws.step4.chapter4;

public class RestaurantTest {

	public static void main(String[] args) {
		//레스토랑 객체 생성
		Restaurant rs1 = new Restaurant(101,"을밀대","서울","냉면",4);
		Restaurant rs2 = new Restaurant(401,"도마29","대구","연어초밥",3);
		Review rv1 = new Review(1,101,"김싸피","너무 맛있네요.");
		Review rv2 = new Review(2,401,"나싸피", "연어 초밥은 여기가 최고!");
		//rs1.resid = 5559; //만약 해당 클래스 맴버변수가 제한자private일때 직접 할당 불가.
		
		System.out.println("**************맛집목록**************");
		System.out.println(rs1);
		System.out.println(rs2);
		System.out.println("**************리뷰목록**************");
		System.out.println(rv1);
		System.out.println(rv2);
	}
}