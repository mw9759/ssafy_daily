package com.ssafy.ws.step4.chapter5;

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

	//Encapsulation
	/**
	 * @return the reviewid
	 */
	public int getReviewid() {
		return reviewid;
	}

	/**
	 * @param reviewid the reviewid to set
	 */
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}

	/**
	 * @return the resid
	 */
	public int getResid() {
		return resid;
	}

	/**
	 * @param resid the resid to set
	 */
	public void setResid(int resid) {
		this.resid = resid;
	}

	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}

	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	//toString_override
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
