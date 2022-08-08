package no1925;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] dots = new int[3][2];
		int[] lines = new int[3];
		
		for(int i=0; i<3; i++) {
			String[] input = br.readLine().split(" ");
			dots[i][0] = Integer.parseInt(input[0]);
			dots[i][1] = Integer.parseInt(input[1]);
		}
		
		for(int i=0; i<3; i++) {
			int x = Math.abs(dots[i][0]-dots[(i+1)%3][0]);
			int y = Math.abs(dots[i][1]-dots[(i+1)%3][1]);
			lines[i] = x*x+y*y;
		}
		
		Arrays.sort(lines);
		
		double a = Math.sqrt(lines[0])+Math.sqrt(lines[1])-Math.sqrt(lines[2]);
		int j = lines[0] + lines[1];
		int l = lines[2];
		
		if(lines[0]==lines[1] && lines[0]==lines[2]) {
			sb.append("JungTriangle");
		} else if(a>0) {
			if(j==l) {
				sb.append("Jikkak");
			}else if(j>l) {
				sb.append("Yeahkak");
			}else {
				sb.append("Dunkak");
			}
			if(lines[0]==lines[1]||lines[0]==lines[2]||lines[2]==lines[1]) {
				sb.append("2");
			}
			sb.append("Triangle");
		} else {
			sb.append("X");
		}
		System.out.println(sb);
	}
}
