package no1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		// 일단 모든 단어가 그룹단어라고 가정
		int result = T;
		
		for(int t=0; t<T; t++) {
			// 각각의 알파벳 등장여부 check할 배열 
			boolean[] cnt = new boolean[26];
			// 가장 최근 등장한 알파벳
			char lastChar = ' ';
			
			for(char c : br.readLine().toCharArray()) {
				// 연속되는 알파벳인가?
				if (lastChar==c) continue;
				
				// 이미 등장했던 알파벳인가?
				if (cnt[c-'a']) {
					// 그룹단어 아니므로 result - 1
					result--;
					break;
				}
				// 등장여부 check 후 lastChar 업데이트
				cnt[c-'a'] = true;
				lastChar = c;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}
