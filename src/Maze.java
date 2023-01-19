import java.io.*;
import java.util.*;

public class Maze {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("src/inputMaze.txt")); // 파일 불러오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //파일 읽어오는 객체 생성
		
		int tc = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase < 2; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int n = Integer.parseInt(st.nextToken());//배열의 길이
			int sp_x = Integer.parseInt(st.nextToken());//출발점 x좌표
			int sp_y = Integer.parseInt(st.nextToken());//출발점 x좌표
			int bpCount = Integer.parseInt(st.nextToken());//범퍼 개수
			
			int arr[][] = new int[bpCount][2];
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(),"");
				for(int j = 0; j < 2; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(n+" "+sp_x+" "+ sp_y+ " "+ bpCount);
//			System.out.println(arr.toString());
			break;
			
		}
		/* 테스트케이스 개수 불러오기**/
		
	}

}
