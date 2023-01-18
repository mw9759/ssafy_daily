package com.ssafy.ws.step6_2;

public class SeriesMovie extends Movie{
	/* 시리즈 넘버**/
	private int seriesNum;
	
	/* 에피소드**/
	private String episode;
	
	//기본 생성자
	public SeriesMovie() {
		super();
	}
	
	//생성자
	public SeriesMovie(int id, String title, String director, String genre, int runningTime, int seriesNum, String episode) {
		super(id, title, director, genre, runningTime);
		this.seriesNum = seriesNum;
		this.episode = episode;
	}

	//encapsulation
	/**
	 * @return the seriesNum
	 */
	public int getSeriesNum() {
		return seriesNum;
	}

	/**
	 * @param seriesNum the seriesNum to set
	 */
	public void setSeriesNum(int seriesNum) {
		this.seriesNum = seriesNum;
	}

	/**
	 * @return the episode
	 */
	public String getEpisode() {
		return episode;
	}

	/**
	 * @param episode the episode to set
	 */
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	
	//toSting
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("|");
		builder.append(String.format("%-10s", seriesNum));
		builder.append("|");
		builder.append(String.format("%-10s", episode));
		return builder.toString();
	}
}
