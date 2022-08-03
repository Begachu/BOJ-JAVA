package no1158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		sb.append("<");
		
		for(int n=1; n<=N; n++) {
			queue.add(n);
		}
		while(!queue.isEmpty()) {
			for(int k=0; k<K-1; k++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll() + ", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}
