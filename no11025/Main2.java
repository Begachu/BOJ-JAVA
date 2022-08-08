package no11025;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int idx = 1;
		int[] cnt = new int[N];
		
		for(int i=0; i<N; i++)
			cnt[i] = i;
		
		int n = K-1;
		
		while(idx<N) {
			System.out.println(n+1);
			while(cnt[n]!=n) n = cnt[n];
			cnt[n] = cnt[(n+1)%N];
			n = (n+K)%N;
			idx++;
		}
		System.out.println(n+1);
	}
	
}
