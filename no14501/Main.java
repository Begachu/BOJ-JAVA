package no14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int N;
	public static int[][] arr;
	public static int[] cnt;
	public static StringTokenizer token;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		cnt = new int [N];
		
		for(int n=0; n<N; n++) {
			cnt[n] = -1;
			token = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(token.nextToken());
			arr[n][1] = Integer.parseInt(token.nextToken());
		}
		System.out.println(DP(0));
	}
	
	public static int DP(int idx) {
		if(idx>=N) return 0;
		if(cnt[idx]==-1) {
			int temp = idx+arr[idx][0];
			if(temp<=N) {
				cnt[idx] = arr[idx][1] + DP(temp);
			}
			cnt[idx] = Math.max(DP(idx+1), cnt[idx]);			
		}
		return cnt[idx];
	}
}
