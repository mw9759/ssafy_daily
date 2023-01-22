package com.ssafy.ws.step4.chapter4;

public class Review {
	private	int reviewid;
	private int resid;
	private String writer;
	private String content;
	
	//기본 생성자
	public Review() {}
	
	//생성자 선언
	public Review(int reviewid, int resid, String writer, String content) {
		this.reviewid = reviewid;
		this.resid = resid;
		this.writer = writer;
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [reviewid=");
		builder.append(reviewid);
		builder.append(", resid=");
		builder.append(resid);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}
}