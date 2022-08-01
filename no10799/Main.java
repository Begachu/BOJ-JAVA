package no10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		
		int result = 0;
		char[] arr = br.readLine().toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='(') stack.add(arr[i]);
			else {
				stack.pop();
				result += stack.size();
				
				while(i+1<arr.length && arr[i+1]==')') {
					result += 1;
					stack.pop();
					i++;
				}
			}
			
		}
		System.out.print(result);
	}
}
