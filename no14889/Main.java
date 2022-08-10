package no14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력 처리부
		int N = Integer.parseInt(br.readLine());
		int[][] S = new int[N][N];
		boolean[] cnt = new boolean[N]; 
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				S[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(comp(0, 0, N, S, cnt));
	}
	
	public static int comp(int i, int idx, int N, int[][] S, boolean[] cnt) {
		if(idx==N/2) return compute(N, S, cnt);
		int result = Integer.MAX_VALUE;
		for(; i<N; i++) {
			cnt[i] = true;
			result = Math.min(result, comp(i+1, idx+1, N, S, cnt));
			cnt[i] = false;
		}
		return result;
	}
	
	private static int compute(int N, int[][] S, boolean[] cnt) {
		int result = 0;
		for(int r=0; r<N; r++) {
			int temp = 0;
			for(int c=0; c<N; c++) {
				if(cnt[r]==cnt[c]) temp+=S[r][c];
			}
			if(cnt[r]) result += temp;
			else result -= temp;
		}
		return Math.abs(result);
	}
}
