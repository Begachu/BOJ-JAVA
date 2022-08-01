package no17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("<");
		StringBuilder result = new StringBuilder();
		
		for(String str : input) {
			if(str.contains(">")) {
				String[] temp = str.split(">");
				result.append("<"+temp[0]+">");
				str = temp.length>1? temp[1] : "";
			}
			String[] word = str.split(" ");
			
			for(String w : word) {
				result.append(new StringBuilder(w).reverse());
				result.append(" ");
			}
			result.setLength(result.length()-1);
		}
		
		System.out.println(result);
	}
}
