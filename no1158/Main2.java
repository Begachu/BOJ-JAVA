package no1158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.append("<");
		
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		Node head = new Node(1);
		Node tail = head;
		
		for(int i=2; i<=N; i++) {
			tail.next = new Node(i, tail.next, tail);
			head.pre = tail.next;
			tail = tail.next;
		}
		
		while(head != head.pre) {
			head = head.peek(K);
			bw.append(head.value + ", ");
			head = head.next;
		}
		bw.append(head.value + ">");
		bw.flush();
	}
}

class Node {
	Node next = this;
	Node pre = this;
	int value;
	
	public Node(int value) {
		this.value = value;
	}
	public Node(int value, Node next, Node pre) {
		this.value = value;
		this.next = next;
		this.pre = pre;
	}
	public Node peek(int num) {
		if(num==1) {
			next.pre = pre;
			pre.next = next;
			return this;
		}
		else return next.peek(num-1);
	}
}

