package com.ssafy.collection.set;

public class InvalidDataException extends Exception {
	
	public InvalidDataException() {
		super("입력하신 정보가 일치하지 않습니다.");
	}
}
