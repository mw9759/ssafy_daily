package com.ssafy.collection.set;

public class RecordNotFoundException extends Exception {
	private String key;
	
	public RecordNotFoundException() {
		super("해당 정보를 찾을 수 없습니다.");
	}
	
	public RecordNotFoundException(String key) {
		super(key + " 해당 정보를 찾을 수 없습니다.");
		this.key = key;
	}
	
	public String getKey() {
		return this.key;
	}
}
