package no1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		// 자동으로 중복을 제거할 수 있도록 set 사용
		HashSet<String> hSet = new HashSet<>();
		
		// 입력을 모두 set에 담는다
		for(int n=0; n<N; n++) hSet.add(br.readLine());
		
		// 정렬을 수행해야하지만, set은 정렬이 안되므로 list로 변경
		List<String> list = new ArrayList<>(hSet);
		
		// 우선순위가 낮은 정렬 규칙부터 적용해간다
		Collections.sort(list);
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
		
		for(String str : list)	bw.append(str+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
