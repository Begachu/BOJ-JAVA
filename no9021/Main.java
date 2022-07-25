package no9021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 개수 받기
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			// char형의 배열로 받아 처리 시작
			char[] cArr = br.readLine().toCharArray();
			int stack = 0;
			
			for (char c : cArr) {
				if (c=='(') stack++;
				else stack--;
				
				// 잘못된 괄호 입력
				if (stack<0) break;
			}
			
			if (stack==0) System.out.println("YES");
			else System.out.println("NO");
		}
		
		br.close();
	}
}
