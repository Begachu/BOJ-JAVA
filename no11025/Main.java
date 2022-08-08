package no11025;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static boolean[] cnt;
	public static int idx = 1;
	public static int N;
	public static int K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		cnt = new boolean[N];
		int n = K-1;
		
		while(idx<N) {
			cnt[n] = true;
			int jump = K;
			while(jump!=0) {
				n = (n+1)%N;
				if(!cnt[n]) jump--;
			}
			idx++;
		}
		System.out.println(n+1);
	}
	public static int DP(int n) {
		if(idx==N) return n;
		cnt[n] = true;
		int jump = K;
		while(jump!=0) {
			n = (n+1)%N;
			if(!cnt[n]) jump--;
		}
		idx++;
		return DP(n);
	}
	
}
