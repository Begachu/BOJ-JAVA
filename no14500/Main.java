package no14500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int[][] arr = new int[N][M];
		
		for(int n=0; n<N; n++) {
			token = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				arr[n][m] = Integer.parseInt(token.nextToken());
			}
		}
		int result = 0;
		int temp;
		
		// 2*2 네모
		for(int n=0; n<N-1; n++) {
			for(int m=0; m<M-1; m++) {
				temp = arr[n][m]+arr[n+1][m]+arr[n+1][m+1]+arr[n][m+1];
				result = Math.max(temp, result);
			}
		}
		
		// 1*4 막대
		for(int n=0; n<N-3; n++) {
			for(int m=0; m<M; m++) {
				temp = arr[n][m]+arr[n+1][m]+arr[n+2][m]+arr[n+3][m];
				result = Math.max(temp, result);
			}
		}
		
		// 4*1 막대
		for(int n=0; n<N; n++) {
			for(int m=0; m<M-3; m++) {
				temp = arr[n][m]+arr[n][m+1]+arr[n][m+2]+arr[n][m+3];
				result = Math.max(temp, result);
			}
		}
		
		// 2*3 도형들
		for(int n=0; n<N-1; n++) {
			for(int m=0; m<M-2; m++) {
				temp = arr[n][m]+arr[n][m+1]+arr[n][m+2]
						+arr[n+1][m]+arr[n+1][m+1]+arr[n+1][m+2];
				
				// L 모양
				int temp2 = Math.min(arr[n][m]+arr[n][m+1], arr[n][m+1]+arr[n][m+2]);
				temp2 = Math.min(temp2, arr[n+1][m]+arr[n+1][m+1]);
				temp2 = Math.min(temp2, arr[n+1][m+1]+arr[n+1][m+2]);
				
				// Z 모양
				temp2 = Math.min(temp2, arr[n][m]+arr[n+1][m+2]);
				temp2 = Math.min(temp2, arr[n+1][m]+arr[n][m+2]);
				
				// T 모양
				temp2 = Math.min(temp2, arr[n][m]+arr[n][m+2]);
				temp2 = Math.min(temp2, arr[n+1][m]+arr[n+1][m+2]);
				
				result = Math.max(temp - temp2, result);
			}
		}
		
		// 3*2 도형들
		for(int n=0; n<N-2; n++) {
			for(int m=0; m<M-1; m++) {
				temp = arr[n][m]+arr[n][m+1]
						+arr[n+1][m]+arr[n+1][m+1]
						+arr[n+2][m]+arr[n+2][m+1];
				
				// L 모양
				int temp2 = Math.min(arr[n][m]+arr[n+1][m], arr[n+1][m]+arr[n+2][m]);
				temp2 = Math.min(temp2, arr[n][m+1]+arr[n+1][m+1]);
				temp2 = Math.min(temp2, arr[n+1][m+1]+arr[n+2][m+1]);
				
				// Z 모양
				temp2 = Math.min(temp2, arr[n][m]+arr[n+2][m+1]);
				temp2 = Math.min(temp2, arr[n][m+1]+arr[n+2][m]);
				
				// T 모양
				temp2 = Math.min(temp2, arr[n][m]+arr[n+2][m]);
				temp2 = Math.min(temp2, arr[n][m+1]+arr[n+2][m+1]);
				
				result = Math.max(temp - temp2, result);
			}
		}
		
		System.out.println(result);
	}
}
