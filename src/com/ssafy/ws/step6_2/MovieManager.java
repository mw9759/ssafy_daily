package com.ssafy.ws.step6_2;

public class MovieManager {
	//배열 길이 상수로 선언, 클래스 변수
	private static int MAX_SIZE = 100;
	
	//배열 선언
	private Movie[] movieList = new Movie[MAX_SIZE];
	
	//들어온 객체 수 카운팅 변수
	private int size;
	
	//배열에 들어올 영화가 이미 존재하는지 확인 및 인덱스 출력.
	public int checkMovie(int id) {
		for(int i = 0; i < size; i++) {
			if(movieList[i].getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	//영화 객체 추가
	public void add(Movie m) {
		if(size < MAX_SIZE) {
			if(checkMovie(m.getId()) == -1) {
				movieList[size++] = m;
			}else {
				System.out.println("해당 영화는 이미 등록되어 있습니다.");
			}
		}else {
			System.out.println("영화를 추가할 공간이 부족합니다.");
		}
	}
	
	//영화 제목을 통해 해당 키워드를 포함하는 영화 정보 출력
	public Movie[] searchByTitle(String title) {
		int resultCount = 0;
		for(int i = 0; i < size; i++) {
			if(movieList[i].getTitle().contains(title)) {
				resultCount++;
			}
		}
		
		if(resultCount ==0) {
			System.out.println("검색 결과가 없습니다. 입력 키워드: "+title);
			return null;
		}
		
		Movie[] resultList = new Movie[resultCount];
		for(int i = 0, j = 0; i < size; i++) {
			if(movieList[i].getTitle().contains(title)) {
				resultList[j++] = movieList[i];
			}
		}
		return resultList;
	}
	
	//전체 영화 정보 출력
	public Movie[] getList() {
		Movie[] mv = new Movie[size];
		for(int i = 0; i < size; i++) {
			mv[i] = movieList[i];
		}
		return mv;
	}
	
	//일반 영화만 출력
	public Movie[] getMovies() {
		int nomalMovie = 0;
		for(int i = 0; i < size; i++) {
			if(!(movieList[i] instanceof SeriesMovie)) {
				nomalMovie++;
			}
		}
		
		Movie[] m = new Movie[nomalMovie];
		for(int i = 0, j = 0; i < nomalMovie; i++) {
			if(!(movieList[i] instanceof SeriesMovie)) {
				m[j++] = movieList[i];
			}
		}
		return m;
	}
	
	//시리즈 영화만 출력
	public Movie[] getSeriesMovies() {
		int seriesCount = 0;
		for(int i = 0; i < size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				seriesCount++;
			}
		}
		Movie[] m = new Movie[seriesCount];
		for(int i = 0, j = 0; i < size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				m[j++] = movieList[i];
			}
		}
		return m;
	}
	
	//모든 영화들의 평균상영 시간 반환
	public double getRunningTimeAvg() {
		int sumAllTime = 0;
		for(int i = 0; i < size; i++) {
			sumAllTime += movieList[i].getRunningTime();
		}
		return sumAllTime/size;
	}
	
	//구분렬 생성
	public void starLine(String s) {
		System.out.printf("########## %s ##########%n", s);
	}
	
}
