package no17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		char[] str = br.readLine().toCharArray();
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<str.length; i++) {
			if(str[i]=='<') {
				while(!stack.isEmpty()) result.append(stack.pop());
				while(str[i]!='>') result.append(str[i++]);
				result.append(str[i]);
			}
			else if(str[i]==' ') {
				while(!stack.isEmpty()) result.append(stack.pop());
				result.append(" ");
			}
			else stack.add(str[i]);
		}
		
		while(!stack.isEmpty()) result.append(stack.pop());
		
		System.out.println(result);
	}
}
