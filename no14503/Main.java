package no14503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, R, C, D, result = 1;
	public static int[][] arr;
	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		arr[R][C] = 2;
		while (move());

		System.out.println(result);
	}

	public static boolean move() {
		int i = 0;
		for (; i < 4; i++) {
			D = (D + 3) % 4;
			if (arr[R + dr[D]][C + dc[D]] == 0)
				break;
		}
		if (i == 4) {
			R -= dr[D];
			C -= dc[D];
			return arr[R][C]!=1;
		}
		R += dr[D];
		C += dc[D];
		arr[R][C] = 2;
		result++;
		return true;
	}
}
