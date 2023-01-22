package com.ssafy.ws.step4.chapter5;

public class RestaurantManager {
	//최대 담을 수 있는 개수를 상수변수로 선언
	private static int MAX_RESTAURANT_SIZE = 100;
	private static int MAX_REVIEW_SIZE = 1000;
	
	//개수만큼 담을 수 있는 멤버변수 배열객체.
	private static Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
	private static Review[] reviews = new Review[MAX_REVIEW_SIZE];
	
	//현재 등록된 개수를 저장할 멤버 변수
	private static int sizeRes;
	private static int sizeRev;
	
	//레스토랑 인덱스 유무 조회
	public int isRestaurant(int resid) {
		for(int i = 0; i < sizeRes; i++) {
			if(restaurants[i].getResid() == resid) {
				return i;
			}
		}
		return -1;
	}
	
	//레스토랑 추가.
	public void addRestaurant(Restaurant s) {
		if(sizeRes<MAX_RESTAURANT_SIZE) {			
			if(isRestaurant(s.getResid())==-1) {
				restaurants[sizeRes++] = s;
			}
			else {
				System.out.println("해당 레스토랑 " + s.getName() + "은(는) 이미 등록되어 있습니다.");
			}
		} else
			System.out.println("저장 공간이 부족합니다.");
	}
	
	//레스토랑 리스트 출력
	public Restaurant[] getRestaurantList() {
		Restaurant[] rs = new Restaurant[sizeRes];
		for(int i = 0; i < sizeRes; i++) {
			rs[i] = restaurants[i];
		}
		return rs;
	}
	
	//레스토랑 정보수정 및 수정 결과 출력.
	public Restaurant[] updateRestaurant(int resid, String name, String address, String signatureMenu ,int rate) {
		int index = isRestaurant(resid);
		if(index == -1) {
			System.out.println("등록 정보가 없습니다. 새로 추가해 주세요.");
		}else {
			restaurants[index].setName(name);
			restaurants[index].setAddress(address);
			restaurants[index].setSignatureMenu(signatureMenu);
			restaurants[index].setRate(rate);
		}
		return getRestaurantList();
	}
	
	//레스토랑 정보 삭제 및 삭제 후의 리스트 출력
	public Restaurant[] removeRestaurant(int resid) {
		int index = isRestaurant(resid);
		if(index == -1)
			System.out.println("등록 정보가 없어 삭제할 수 없습니다.");
		else {
			restaurants[index] = restaurants[--sizeRes];
			restaurants[sizeRes] = null;
		}
		return getRestaurantList();
	}
	
	//레스토랑 id를 입력받아 해당 정보를 반환.
	public Restaurant getRestaurant(int resid) {
		Restaurant rs = new Restaurant();
		if(isRestaurant(resid) != -1) {
			rs = restaurants[isRestaurant(resid)];
			return rs;
		}
		else {
			System.out.println("입력하신 정보의 레스토랑은 없습니다.");
			return null;
		}
	}
	
	
		
	//레스토랑 추가._리뷰는 중복으로 달기가 가능하기에 저장 공간만 확인.
	public void addReview(Review s) {
		if(sizeRev<MAX_REVIEW_SIZE) {			
			reviews[sizeRev++] = s;
		} else
			System.out.println("저장 공간이 부족합니다.");
	}
	
	//리뷰 인덱스 조회
	public int isReview(int reviewid) {
		for(int i = 0; i < sizeRev; i++) {
			if(reviews[i].getReviewid() == reviewid) {
				return i;
			}
		}
		return -1;
	}
	
	//리뷰 리스트 출력
	public Review[] getReviewList() {
		Review[] rv = new Review[sizeRev];
		for(int i = 0; i < sizeRev; i++) {
			rv[i] = reviews[i];
		}
		return rv;
	}
	
	//리뷰 정보 삭제 및 삭제 후의 리스트 출력
	public Review[] removeReview(int reviewid) {
		int index = isReview(reviewid);
		if(index == -1)
			System.out.println("등록 정보가 없어 삭제할 수 없습니다.");
		else {
			reviews[index] = reviews[--sizeRev];
			reviews[sizeRev] = null;
		}
		return getReviewList();
	}
	
	//해당 맛집에 대한 리뷰만 반환
	public Review[] getRestaurantReview(int resid) {
		Review[] rv = new Review[sizeRev];//해당 리뷰만 담을 배열 생성.
		int index = 0;
		for(int i = 0; i < sizeRev; i++) {
			if(reviews[i].getResid() == resid) {
				rv[index++] = reviews[i];
			}
		}
		
		Review[] rv_1 = new Review[index];
		for(int i = 0; i < index; i++) {
			rv_1[i] = rv[i];
		}
		return rv_1;
	}
}