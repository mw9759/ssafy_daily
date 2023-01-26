package com.ssafy.collection.set;

public class DuplicateException extends Exception {
	private String key;
	public DuplicateException() {
		super("해당 아이디는 이미 사용중입니다.");
	}
	
	public DuplicateException(String key) {
		super(key + " 해당 아이디는 이미 사용중입니다.");
		this.key = key;
	}
	
	public String getKey() {
		return this.key;
	}
}
