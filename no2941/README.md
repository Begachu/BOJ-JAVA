# 문제 정리
문제 링크는 아래와 같다.
https://www.acmicpc.net/problem/9012

풀이를 올린 블로그는 다음과 같다.
https://velog.io/@begachu/%EB%B0%B1%EC%A4%80-9012%EB%B2%88-%EA%B4%84%ED%98%B8

## 올바른 괄호 문자열
올바른 괄호 문자열(Valid PS, VPS)의 예시는 다음과 같다.
- ()
- (())()
- ((()))

반대로 VPS가 아닌 괄호 문자열의 예시는 다음과 같다.
- (()(
- (())()))

이 예시를 통해 올바른 괄호 문자열이 되기 위한 조건을 생각해보면 다음과 같다.
> 1. 여는 괄호와 닫는 괄호의 전체 개수는 같다.
2. 여는 괄호가 등장하기 전에 닫는 괄호가 등장하면 안된다.

따라서 위의 조건을 만족하는 문자열은 YES, 아닌 것은 NO를 출력하면 된다.

# 문제 풀이
문자열을 좌측부터 순서대로 읽어 VPS 여부를 판단한다.
판단 방법은 다음과 같다.

편의상 **괄호 개수**는 아직 닫히지 않은 괄호의 수를 의미한다.

>1. **여는 괄호**인 경우 여는 **괄호 개수** +1
2. **닫는 괄호**인 경우 여는 **괄호 개수** -1
3. 순회중 **괄호 개수**가 음수가 되면 바로 NO 출력
4. 순회 후 **괄호 개수**가 0이면 YES, 아니면 NO 출력

따라서 코드는 다음과 같다.
```java
for (int t=0; t<T; t++) {
			// char형의 배열로 받아 처리 시작
			char[] cArr = br.readLine().toCharArray();
			int stack = 0;
			
			for (char c : cArr) {
				if (c=='(') stack++;
				else stack--;
				
				// 잘못된 괄호 입력
				if (stack<0) break;
			}
			
			if (stack==0) System.out.println("YES");
			else System.out.println("NO");
		}
```


# 결과
최종 제출한 코드는 다음과 같다.
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 개수 받기
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			// char형의 배열로 받아 처리 시작
			char[] cArr = br.readLine().toCharArray();
			int stack = 0;
			
			for (char c : cArr) {
				if (c=='(') stack++;
				else stack--;
				
				// 잘못된 괄호 입력
				if (stack<0) break;
			}
			
			if (stack==0) System.out.println("YES");
			else System.out.println("NO");
		}
		
		br.close();
	}
}
```

제출결과는 다음과 같다.

![](https://velog.velcdn.com/images/begachu/post/b1ea355a-b120-4a49-b16d-7a39486c49ad/image.png)
