# 문제 설명

---

문제 링크는 [여기](https://www.acmicpc.net/problem/10799)를 눌러주세요!

[10799번: 쇠막대기](https://www.acmicpc.net/problem/10799)

---

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/cb8cc811-b203-40a6-955e-5c4b84d5627b/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220801%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220801T142051Z&X-Amz-Expires=86400&X-Amz-Signature=015f85fb2a8b3cf54b2520330f010fcb6930b239b085780028f89389bc1b42c7&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

위와 같이 괄호 입력이 주어졌을 때, 괄호 두 개 이상 중첩된 경우 쇠막대기가 있다고 가정한다.  이때 중첩이 없는 괄호가 닫힐 때 레이저를 통해 쇠막대기를 절단한다.

문제가 원하는 최종 출력은 입력에 대해 결과적으로 얻을 수 있는 쇠막대기의 개수이다.

# 접근

---

처음에는 Stack을 이용해서 여는 괄호는 Stack에 저장,  닫는 괄호가 나올 때 Stack의 길이-1만큼 더해주는 식으로 답을 구하고자 했다.

> **왜 Stack의 길이 - 1 로 생각했는가?**
⇒ 예제를 보면 알 수 있듯이 중첩 없는 괄호의 경우 쇠막대기 절단 역할만 할 뿐, 실질적으로 쇠막대기 개수에 더해지지 않는다. 따라서 닫는 괄호의 짝인 여는 괄호 하나는 빼야 한다고 생각했다.
> 

```java
		int result = 0;
		char[] arr = br.readLine().toCharArray();
		
		for(char c : arr) {
			if(c=='(') stack.add(c);
			else {
				result += stack.size() - 1;
				stack.pop();
			}
		}
```

작성하고 생각해보니 그냥 stack.pop()을 먼저하면 -1을 할 필요가 없을 것 같아서 아래처럼 변경했다.

```java
		for(char c : arr) {
			if(c=='(') stack.add(c);
			else {
				stack.pop();
				result += stack.size();
			}
		}
```

이 다음 문제는 쇠막대기 절단 후 끝 부분에 대한 값이 더해지지 않는다는 것이었다. 그리고 이 부분은 정확히 닫는 괄호의 연속되는 개수-1와 같았다.

처음에는 이 값을 구하는데 변수를 통해서 해결하고자 했다. (foreach문을 쓰고 있기 때문에)

```java
		int result = 0;
		char[] arr = br.readLine().toCharArray();
		int end = -1;
		
		for(char c : arr) {
			if(c=='(') {
				stack.add(c);
				if (end>=0) {
					result += end;
					end = -1;
				}
			} else {
				stack.pop();
				result += stack.size();
				end++;
			}
		}
```

그리고 이 접근은 완전히 틀렸다..

어떤 부분이 틀렸는지 확인하고자 출력문을 추가해보았다.

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/40376af5-4bd6-401c-bbcb-58f07a3c9bf1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220801%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220801T142021Z&X-Amz-Expires=86400&X-Amz-Signature=bebe63c6496b847dcb690f5074f8486d4dcf14f202bc7dbbabe15a167f0fe93e&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

살펴보니 의도와 다르게 닫는 괄호가 연속해서 등장 시 한 번 더 쇠막대기가 짤리는 것같이 값이 들어가는 것 같았다.

코드도 눈에 잘 안 들어와서 디버깅이 힘든 것 같아 index를 이용한 for문 형태로 코드를 수정하였다.

```java
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
```

의도대로 동작할 수 있게끔, 닫는 괄호 등장 시 닫는 괄호가 연속되는만큼 result를 더하는 식으로 구현하였다.

# 소스코드

---

최종 코드는 다음과 같다.

```java
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
```

# 결과

---

제출 결과는 다음과 같았다.

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/99dd811e-1cfd-4ef7-a713-caaab0a57d58/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220801%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220801T142113Z&X-Amz-Expires=86400&X-Amz-Signature=cf04f225bb905e8f8a7fcd3caba8d7e9052bd1066c96ee6d232b064cd70815f9&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

# 고찰

---

문제를 좀 더 분석한 후에 코드를 짜야겠다는 생각이 들었다.

제대로 이해하지 않은 채로 문제를 내 마음대로 쪼개서 이해하고 구현하고, 다시 이해하고 수정하고를 반복하니 이상한 곳에서 시간이 많이 지체되었다.

위의 코드의 경우 레이저로 절단할 때 절단된 쇠막대기의 개수를 세는 것으로 구현한 것이었는데, 다른 방법으로 구현할 수는 없었을까? 예를 들어 쇠막대기가 등장할 때마다 세는 식으로…

이후에 좀 더 고민해봐야겠다.
