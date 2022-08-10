package no14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {1, 0, -1, 0};
	public static int[] dc = {0, -1, 0, 1};		
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int safe = -3;
		int[][] arr = new int[N+2][M+2];
		int size = 0;
		int[][] virus = new int[N*M][];
		
		for(int n=0; n<N+2; n++)
			for(int m=0; m<M+2; m++)
				arr[n][m] = 1;
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				arr[n+1][m+1] = Integer.parseInt(st.nextToken());
				if(arr[n+1][m+1]==2)
					virus[size++] = new int[] {n+1, m+1};
				else if(arr[n+1][m+1]==0) safe++;
			}
		}
		
		System.out.println(safe - perm(0, arr, N, M, virus));
	}
	
	public static int perm(int idx, int[][] arr, int N, int M, int[][] virus) {
		if(idx==3) return bfs(arr, virus);
		int result = Integer.MAX_VALUE;
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(arr[n+1][m+1]!=0) continue;
				int[][] copy = new int[N+2][M+2];
				for(int i=0; i<N+2; i++) {
					System.arraycopy(arr[i], 0, copy[i], 0, M+2);
				}
				copy[n+1][m+1] = 1;
				result = Math.min(result, perm(idx+1, copy, N, M, virus));
			}
		}
		return result;
	}

	private static int bfs(int[][] arr, int[][] virus) {
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; true; i++) {
			if(virus[i]==null) break;
			queue.add(virus[i]);
		}
		int infection = 0;
		
		while(!queue.isEmpty()) {
			int[] v = queue.poll();
			for(int i=0; i<4; i++) {
				int r = v[0] + dr[i];
				int c = v[1] + dc[i];
				if(arr[r][c]==0) {
					arr[r][c] = 2;
					infection++;
					queue.add(new int[] {r, c});
				}
			}
		}
		return infection;
	}
}
