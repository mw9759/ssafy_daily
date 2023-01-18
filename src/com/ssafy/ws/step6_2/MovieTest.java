package com.ssafy.ws.step6_2;

public class MovieTest {

	public static void main(String[] args) {
		Movie m1 = new Movie(1,"교섭", "임순례", "드라마", 108);
		Movie m2 = new Movie(2,"유령", "이해영", "액션", 133);
		SeriesMovie m3 = new SeriesMovie(3,"아바타", "제임스", "액션", 162, 1 , "아바타");
		SeriesMovie m4 = new SeriesMovie(4,"이비타", "제임스", "액션", 192, 2 , "물의 길");
		
		MovieManager mm = new MovieManager();
		
		//객체 추가
		mm.add(m1);
		mm.add(m2);
		mm.add(m3);
		mm.add(m4);
		
		//모든 영화 출력
		mm.starLine("모든 영화");
		for(Movie m : mm.getList()) {
			System.out.println(m);
		}
		
		//영화 제목 검색(일치x 키워드 포함 여부 조건)searchByTitle
		mm.starLine("검색 결과: 아바타");
		for(Movie m : mm.searchByTitle("아바타")) {
			System.out.println(m);
		}
		
		//일반 영화만 출력
		mm.starLine("일반 영화");
		for(Movie m : mm.getMovies()) {
			System.out.println(m);
		}
		
		//시리즈 영화만 출력
		mm.starLine("시리즈 영화");
		for(Movie m : mm.getSeriesMovies()) {
			System.out.println(m);
		}
		
		//평균 상형시간 출력
		mm.starLine("평균 상영 시간");
		System.out.println(mm.getRunningTimeAvg()+" 분.");
	}

}
