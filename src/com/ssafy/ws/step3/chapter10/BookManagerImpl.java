package com.ssafy.ws.step3.chapter10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */

public class BookManagerImpl implements IBookManager {
	/* Singletone Pattern 적용 설계**/
	private static BookManagerImpl instance = new BookManagerImpl();
	private BookManagerImpl() {}
	public static BookManagerImpl getInstance() {
		return instance;
	}
	/** 도서의 등록갯수 및 도서 추가 등록시 배열요소 인덱스 번호 멤버변수.*/
	private List<Book> books= new ArrayList<>();
	
	//도서번호로 인덱스 확인 / 도서 등록 유무 확인 
	public int isBook(String isdn) {
		for(int index = 0; index < books.size(); index++) {
			if(books.get(index).getIsbn().equals(isdn)) {
				return index;
			}
		}
		return -1;
	}

	//도서 추가
	@Override
	public void add(Book b) {
		if(isBook(b.getIsbn()) == -1) {
			books.add(b);
		}else {
			System.out.println("해당 도서는 이미 등록되어 있습니다.");
		}
	}
	
	//도서 제거
	@Override
	public void remove(String isbn) {
		int index = isBook(isbn);
		if(index>=0) {
			books.remove(index);
		} else {
			System.out.println("제거할 도서를 찾지 못했습니다.");
		}
	}
	
	//전체 리스트
	@Override
	public Book[] getList() {
		Book[] res = new Book[books.size()];
		return books.toArray(res);
	}
	
	//잡지 리스트
	@Override
	public Magazine[] getMagazines() {
		List<Magazine> mgs = new ArrayList<>();
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i) instanceof Magazine) {
				mgs.add((Magazine) books.get(i));
			}
		}
		Magazine[] mg = new Magazine[mgs.size()];
		return mgs.toArray(mg);	
	}
	
	//일반도서 리스트
	@Override
	public Book[] getBooks() {
		List<Book> bks = new ArrayList<>();
		for(int i = 0; i < books.size(); i++) {
			if(!(books.get(i) instanceof Magazine)) {
				bks.add(books.get(i));
			}
		}
		Book[] mg = new Book[bks.size()];
		return bks.toArray(mg);
	}

	//도서 번호로 정보 조회
	@Override
	public Book searchByIsbn(String isbn) {
		int index = isBook(isbn);
		if(index >= 0) {
			return books.get(index);
		}
		System.out.println("오류. 해당 도서를 찾을 수 없습니다."+isbn);
		return null;
	}

	//제목 검색
	@Override
	public Book[] searchByTitle(String title) {
		List<Book> sbb = new ArrayList<>();
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getTitle().contains(title)) {
				sbb.add(books.get(i));
			}
		}
		Book[] b = new Book[sbb.size()];
		return sbb.toArray(b);
	}
	
	//총 도서 가격.
	@Override
	public int getTotalPrice() {
		int sum_p = 0;
		for(int i = 0; i < books.size(); i++) {
			sum_p += books.get(i).getPrice();
		}
		return sum_p;
	}
	
	@Override
	public void printHead(String head) {
		System.out.printf("########## %s ##########%n", head);
	}

	@Override
	public double getPriceAvg() {
		return (double)getTotalPrice()/(getList().length);
	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		int check = isBook(isbn);
		if(check == -1) {
			throw new ISBNNotFoundException(isbn);
		}
		else if(books.get(check).getQuantity() < quantity) {
			throw new QuantityException();
		}
		else {
			books.get(check).setQuantity(books.get(check).getQuantity()-quantity);
			System.out.println(books.get(check));
		}
		
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		int check = isBook(isbn);
		if(check == -1) {
			throw new ISBNNotFoundException(isbn);
		}
		else {
			books.get(check).setQuantity(books.get(check).getQuantity()+quantity);
			System.out.println(books.get(check));
		}
		
	}

	@Override
	public void saveData() {
		//데이터파일 저장 폴더 생성
		File foldername = new File("src/data");
		if(!foldername.exists()) {
			foldername.mkdir();
			System.out.println("[정보] 데이터 파일 저장용 폴더를 생성하였습니다. " + foldername.getAbsolutePath());
		}
		
		// 데이터 저장.
		File file = new File("src/data/book.dta");
		ObjectOutputStream out = null; //초기값 빈 상태로 선언.
		try {
			out = new ObjectOutputStream(new FileOutputStream(file, false));
			out.writeObject(books);
			System.out.println("[성공] 총 "+books.size()+"권의 도서 데이터를 저장하였습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("[실패] 파일 저장시에 문제가 발생했습니다.");
		}
		finally {
			if(out != null) {
				try {
					out.close();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}

	//데이터 불러오기
	@Override//개발중 오류발생시 디버깅!
	public void loadData() {
		// TODO Auto-generated method stub
		File file = new File("src/data/book.dta");
		
		// 파일이 없을 경우 고려
		if(file.exists() && file.canRead() && file.isFile()) {
			// try with resources
			try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
				books = (List<Book>)in.readObject();
				System.out.printf("[성공] 도서 총 %d권 정보를 로드하였습니다.\n", books.size());
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getLocalizedMessage());
				// ??? : 멤버변수 선언 및 명시적 초기화
				books = new ArrayList<>();
			}
		}else {
			System.out.println("[실패] 불러올 파일이 없습니다.");
			// ??? : 멤버변수 선언 및 명시적 초기화
			books = new ArrayList<>();
		}
	}
}

