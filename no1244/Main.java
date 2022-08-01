package no1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받기
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		int M = Integer.parseInt(br.readLine());
		
		for(int m=0; m<M; m++) {
			String[] input = br.readLine().split(" ");
			int gender = Integer.parseInt(input[0]);
			int idx = Integer.parseInt(input[1]);
			
			
			// case 1: 남학생
			if(gender==1) {
				for (int i=idx-1; i<N; i+=idx) {
					arr[i] = (arr[i]==0) ? 1 : 0;
				}
			}
			// case 2: 여학생
			else {
				arr[idx-1] = (arr[idx-1]==0) ? 1 : 0;
				for (int i=0; i<N; i++) {
					int left = idx-i-2;
					int right = idx+i;
					if(left>=0 && right<N && arr[left]==arr[right]) {
						arr[left] = (arr[left]==0)? 1 : 0;
						arr[right] = (arr[right]==0)? 1 : 0;
					} else break;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int idx = 1;
		for(int i: arr) {
			sb.append(i+" ");
			if(idx++%20==0) sb.append("\n");
		}
		
		sb.deleteCharAt(sb.lastIndexOf(" "));
		System.out.println(sb);
	}
}
