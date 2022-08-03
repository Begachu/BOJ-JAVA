package no1966;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<int[]> queue = new LinkedList<>();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int result = 1;
			char[] arr = br.readLine().replaceAll(" ", "").toCharArray();
			
			for(int i=0; i<N; i++) {
				queue.add(new int[] {i, arr[i]-'0'});
			}
			
			while(!queue.isEmpty()) {
				int max = queue.peek()[1];
				for(int[] temp : queue) {
					max = Math.max(max, temp[1]);
				}
				while(queue.peek()[1]!=max)
					queue.add(queue.poll());
				if(queue.poll()[0]==M) break;
				result++;
			}
			queue.clear();
			bw.append(result+"\n");
		}
		bw.flush();
	}
}
