package com.ssafy.hw.step6_2;


public class VipUser extends User {
	
	// 새로 추가된 필드 접근 제한자 설정
	private String grade;
	private int point;

	public VipUser() {
		// 부모 클래스의 생성자 호출
		super();
	}

	public VipUser(String id, String password, String name, String email, int age, String grade, int point) {
		// 부모 클래스의 생성자 호출
		super(id, password, name, email, age);
		this.grade= grade;
		this.point = point;

	}

	/*
	 * 새로 추가된 필드들의 getter / setter 메소드를 추가해주세요.
	 */
	
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}
	
	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "VipUser [id=" + this.getId() + ", password=" + this.getPassword() + ", name=" + this.getName()
				+ ", email=" + this.getEmail() + ", age=" + this.getAge() + ", grade=" + grade + ", point=" + point
				+ "]";
	}
}
