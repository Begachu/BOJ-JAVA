package no15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[] arr;
	public static int N;
	public static int M;
	public static void main(String[] args) throws Exception {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		arr = new int[M];
		
		dp(M);
		bw.flush();
	}
	
	public static void dp(int m) throws Exception {
		if(m==0) {
			for(int i : arr) bw.append(i+" ");
			bw.append("\n");
		} else {
			for(int i=0; i<N; i++) {
				arr[M-m] = i+1;
				dp(m-1);
			}
		}
	}
}