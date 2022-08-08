package no15654;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static boolean[] cnt;
	public static int[] arrV;
	public static int[] arr;
	public static int N;
	public static int M;
	public static void main(String[] args) throws Exception {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		cnt = new boolean[N];
		arr = new int[M];
		arrV = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arrV);
		
		dp(M);
		bw.flush();
	}
	
	public static void dp(int m) throws Exception {
		if(m==0) {
			for(int i: arr) bw.append(i+" ");
			bw.append("\n");
		} else {
			for(int i=0; i<N; i++) {
				if(cnt[i]) continue;
				cnt[i] = true;
				arr[M-m] = arrV[i];
				dp(m-1);
				cnt[i] = false;
			}
		}
	}
}