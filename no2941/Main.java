package no2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] alphaArr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for (String s : alphaArr) {
			str = str.replaceAll(s, "*");
		}
		
		System.out.println(str.length());
		
		br.close();
	}
}
