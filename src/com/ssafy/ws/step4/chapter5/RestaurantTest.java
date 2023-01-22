package com.ssafy.ws.step4.chapter5;

public class RestaurantTest {

	public static void main(String[] args) {
		//레스토랑 , 리뷰 객체 생성
		Restaurant rs1 = new Restaurant(101,"을밀대","서울","냉면",4);
		Restaurant rs2 = new Restaurant(201,"도마29","대구","연어초밥",3);
		Restaurant rs3 = new Restaurant(301,"도마39","부산","광어초밥",5);
		Restaurant rs4 = new Restaurant(401,"도마49","속초","참치초밥",6);
		Review rv1 = new Review(1,101,"김싸피","너무 맛있네요.");
		Review rv2 = new Review(2,201,"나싸피", "연어 초밥은 여기가 최고!");
		Review rv3 = new Review(3,301,"나싸피", "광어 초밥은 여기가 최고!");
		Review rv4 = new Review(4,401,"다싸피", "참치 초밥 별로..");
		Review rv5 = new Review(5,401,"바싸피", "참치 초밥은 여기가 최고!");
		
		//레르토랑 메니져 객체 생성
		RestaurantManager rm = new RestaurantManager();
		
		//레스토랑 정보 추가
		rm.addRestaurant(rs1);
		rm.addRestaurant(rs2);
		rm.addRestaurant(rs3);
		rm.addRestaurant(rs4);
		//리뷰 정보 추가.
		rm.addReview(rv1);
		rm.addReview(rv2);
		rm.addReview(rv3);
		rm.addReview(rv4);
		rm.addReview(rv5);
		
		//전체 레스토랑 정보 출력
		System.out.println("**********레스토랑**********");
		for(Restaurant r : rm.getRestaurantList()) {
			System.out.println(r);
		}
		
		//레스토랑 정보 수정 후 전체 레스토랑 정보 출력
		System.out.println("**********레스토랑 수정 후**********");
		for(Restaurant r : rm.updateRestaurant(101,"new을밀대","서울","냉면",4)) {
			System.out.println(r);
		}
		
		//레스토랑 정보 삭제 후 전체 레스토랑 정보 출력
		System.out.println("**********레스토랑 삭제 후**********");
		for(Restaurant r : rm.removeRestaurant(101)) {
			System.out.println(r);
		}
		
		//레스토랑 id 정보에 맞는 레스토랑 정보 출력
		System.out.println("**********레스토랑 조회**********");
		System.out.println(rm.getRestaurant(401));
		
		//전체 리뷰 출력
		System.out.println("**********리뷰**********");
		for(Review v : rm.getReviewList()) {
			System.out.println(v);
		}
		
		//리뷰 삭제 후 전체 리뷰 출력
		System.out.println("**********리뷰 삭제 후**********");
		for(Review v : rm.removeReview(3)) {
			System.out.println(v);
		}
		
		//해당 레스토랑에 대한 리뷰만 출려
		System.out.println("**********해당 레스토랑 리뷰**********");
		for(Review v : rm.getRestaurantReview(401)) {
			System.out.println(v);
		}
	}
}
