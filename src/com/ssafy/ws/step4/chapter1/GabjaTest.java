package com.ssafy.ws.step4.chapter1;

import java.util.*;
/**
 * 60 갑자를 서양력으로 변환하는 프로그램
 */

public class GabjaTest {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	/* 잘못된 입력 구분하기.
    	 * 1. 2글자가 맞는지
    	 * 2. 60갑자에 해당되는지 확인한다.**/
    	String arr1[] = {"갑","을", "병", "정", "무", "기", "경", "신", "임", "계"};
    	String arr2[] = {"자", "축", "인", "묘", "진", "사", "오", "미", "신", "유", "술", "해"};
    	
    	while(true) {
    		System.out.println("60갑자를 입력하세요: ");
        	
        	String str = sc.nextLine(); // 문자열 입력받아 저장.
        	String[] strArray = str.split(""); //입력받은 문자열 배열에 저장.
        	
        	int sYear = 1800; // 시작년도
        	int fYear = 2100; // 끝년도
        	int firstYear = 0; //입력갑자 첫 시작년도.
        	
    		if (str.equals("종료")) {
    			System.out.println("종료합니다.");
    			break;
    		}
    		else if(strArray.length == 2) {
        		int check_a = 0;
        		int check_b = 0;
        		for(int i = 0; i < arr1.length; i++) {
        			if(!(arr1[i].equals(strArray[0]))) {
        				check_a = 1;
        			}else {
        				check_a = 0;
        				break;
        			}
        		}
        		if(check_a == 1) {
        			System.out.println("입력하신 " + strArray[0] + "은 십간에 포함되지 않습니다.");
        		}
        		
        		for(int i = 0; i < arr2.length; i++) {
        			if(!(arr2[i].equals(strArray[1]))) {
        				check_b = 1;
        			}else {
        				check_b = 0;
        				break;
        			}
        		}
        		if(check_b == 1) {
        			System.out.println("입력하신 " + strArray[1] + "은 십이지에 포함되지 않습니다.");
        		}
        		
        		if(check_a+check_b == 0) {
        			//정상적으로 입력되어 연산 1800년도는 경신년.
        			for(int i = 6, j = 8; i < 66; i++,j++) {
        				if(i == 10) {
        					i = 0;
        				}
        				if(j == 12) {
        					j = 0;
        				}
        				if(str.equals(arr1[i]+arr2[j])) {
        					firstYear = sYear;
        					break;
        				}
        				sYear++;
        				if(sYear>1860) {
        					System.out.println("입력하신 60갑자는 없습니다.");
        					break;
        				}
        			}
        			if(firstYear>1800) {
        				for(int i = firstYear; i <= fYear; i+=60) {
        					System.out.print(i+" ");
        				}
        				System.out.println();
        			}
        			}
        	}else {
        		System.out.println("잘못 입력하셨습니다.");
        	}
    	}
    }
}
