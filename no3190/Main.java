package no3190;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int N;
	public static int K;
	public static int[][] M;
	public static Snake head;
	public static Snake tail;
	public static int[] dy = { 0, 1, 0, -1 };
	public static int[] dx = { 1, 0, -1, 0 };
	public static int d = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int time = 0;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		M = new int[N + 2][N + 2];

		for (int i = 0; i < N + 2; i++) {
			M[i][0] = 1;
			M[0][i] = 1;
			M[i][N + 1] = 1;
			M[N + 1][i] = 1;
		}
		for (int k = 0; k < K; k++) {
			int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			M[temp[0]][temp[1]] = 2;
		}
		head = new Snake();
		tail = head;
		M[1][1] = 1;

		int A = Integer.parseInt(br.readLine());
		boolean alive = true;
		game: for (int a = 0; a < A; a++) {
			String[] temp = br.readLine().split(" ");
			int _time = Integer.parseInt(temp[0]);
			while (time < _time) {
				time++;
				alive = move();
				if (!alive) {
					break game;					
				}
			}
			if (temp[1].equals("D"))
				d = (d + 1) % 4;
			else
				d = (d + 3) % 4;
		}
		while (alive) {
			time++;
			if (!move())
				break;
		}

		System.out.println(time);
	}

	public static boolean move() {
		int y = head.y + dy[d];
		int x = head.x + dx[d];
		
		if (M[y][x] == 1)
			return false;
		Snake temp = new Snake(x, y, null);
		head.pre = temp;
		head = temp;
		if (M[y][x] == 0) {
			M[tail.y][tail.x] = 0;
			tail = tail.pre;
		}
		M[y][x] = 1;
		return true;
	}

}

class Snake {
	public int x;
	public int y;
	public Snake pre;

	public Snake() {
		this(1, 1, null);
	}

	public Snake(int x, int y, Snake pre) {
		this.x = x;
		this.y = y;
		this.pre = pre;
	}
}