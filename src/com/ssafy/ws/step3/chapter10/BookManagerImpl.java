package com.ssafy.ws.step3.chapter10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.hw.step2.chapter10.User;
import com.ssafy.hw.step2.chapter10.UserManagerImpl;


/**
 * 도서리스트를 배열로 유지하며 관리하는 클래스
 */

public class BookManagerImpl implements IBookManager {
	/* Singletone Pattern 적용 설계**/
	/** 도서의 등록갯수 및 도서 추가 등록시 배열요소 인덱스 번호 멤버변수.*/
	private List<Book> books = new ArrayList<>();

	private final int MAX_SIZE = 100;

	private static BookManagerImpl um = new BookManagerImpl();

	private BookManagerImpl() {
	};

	public static BookManagerImpl getInstance() {
		return um;
	}
	
	@Override
	public int getSize() {
		return books.size();
	}

	@Override
	public int isBook(String isdn) {
		for(int index = 0; index < books.size(); index++) {
			if(books.get(index).getIsbn().equals(isdn)) {
				return index;
			}
		}
		return -1;
	}

	@Override
	public void add(Book b) {
		if(books.size() < MAX_SIZE) {
			if(isBook(b.getIsbn()) == -1){
				books.add(b);
			}else {
				System.out.printf("%s 도서번호는 이미 등록되어 있습니다.\n", b.getIsbn());
			}
		}else {
			System.out.printf("%s 도서번호는 이미 등록되어 있습니다.\n", b.getIsbn());
		}
	}

	@Override
	public void remove(String isbn) {
		int index = isBook(isbn);
		if (index >= 0){
			books.remove(index);
		}else {
			System.out.println("삭제불가"+isbn);
		}
	}

	@Override
	public Book[] getList() {
		Book[] res = new Book[books.size()];
		return this.books.toArray(res);
	}

	@Override
	public Magazine[] getMagazines() {
		List<Book> list = new ArrayList<>();
		
		for(int index = 0; index < books.size(); index++) {
			if(books.get(index) instanceof Magazine) {
				list.add(books.get(index));
			}
		}
		Magazine[] res = new Magazine[list.size()];
		//this.books.toArray(res)
		return (Magazine[]) list.toArray(res);
	}

	@Override
	public Book[] getBooks() {
		int nb_counts = 0;
		for(int idx = 0; idx < books.size(); idx++) {
			if(!(books.get(idx) instanceof Magazine)) {
				nb_counts++;
			}
		}
		
		if(nb_counts == 0) {
			return null;
		}
		Book[] n_books = new Book[nb_counts];
		
		int a = 0;
		for(int index = 0; index < books.size(); index++) {
			if(!(books.get(index) instanceof Magazine)) {
				n_books[a++] = books.get(index);
			}
		}
		return n_books;
	}

	@Override
	public Book searchByisbn(String isbn) {
		int index = isBook(isbn);
		if(index >= 0) {
			return books.get(index);
		}
		System.out.println("오류. 해당 도서를 찾을 수 없습니다."+isbn);
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		Book[] tmpBooks = getList();//현재 등록된 전체 도서 정보
		Book[] titleBooks = new Book[books.size()];
		
		int tmpSize = 0; // title로 검색된 도서의 숫자
		
		for (int index = 0; index < tmpBooks.length; index++) {
			if(tmpBooks[index].getTitle().contains(title)) {
				titleBooks[tmpSize++] = tmpBooks[index];
			}
		}
		if(tmpSize == 0)
			return null;
		Book[] resultBooks = new Book[tmpSize];
		for(int index = 0; index < tmpSize; index++) {
			resultBooks[index] = titleBooks[index];
		}
		
		return resultBooks;
	}

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
		else if(books.get(check).getQuantity()-quantity < 0) {
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
		// try with resources
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/user.dat"))) {
			oos.writeObject(this.books);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//데이터 불러오기
	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		File file = new File("src/book.dat");
		
		// 파일이 없을 경우 고려
		if(file.exists() && file.isFile() && file.canRead()) {
			// try with resources
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
				this.books = (List<Book>)ois.readObject();
			} catch (Exception e) {
				e.printStackTrace();//개발중 오류발생시 디버깅!
			}
		}
	}
	
	
	

}

