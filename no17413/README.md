# 문제 설명


문제 링크는 [여기](https://www.acmicpc.net/problem/17413)를 눌러주세요!

[17413번: 단어 뒤집기 2](https://www.acmicpc.net/problem/17413)


입력으로 들어온 문자열의 각 단어를 뒤집는 문제이다.

이때 입력으로  ‘<’와 ‘>’가 들어올 수 있으며, 해당 기호 안의 문자열은 뒤집지 않는다.

입/출력의 예시는 다음과 같다.

### 예제 입력1

```
baekjoon online judge
```

### 예제 출력1

```
noojkeab enilno egduj
```

---

### 예제 입력2

```
<ab cd>ef gh<ij kl>
```

### 예제 출력2

```
<ab cd>fe hg<ij kl>
```

# 접근


처음에는 문제도 안 읽고 “뭐야~ 그냥 문자열 뒤집으면 되는거 아냐?” 했다.

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println(new StringBuilder(br.readLine()).reverse());
```

다시 읽어보니 그러면 ~~당연하게도~~ 그러면 안됐다!

그래서 처음부터 다시 진지하게 읽고 문제를 풀어보았다.

---

일단 <>형태의 문자열을 찾는 것이 관건이었다. 기본 단어의 경우 공백 기준으로 split 후 reverse를 통해 뒤집어주기만 하면 되므로.

앞으로 편의상 <> 문자열을 `tag`라고 칭하고자 한다.

`tag` 를 찾기 위해 각 문자열을 “<”으로 split하였다. 이렇게 나눠진 문자열은 최대 한 개의 `tag`만을 가질 수 있으므로 처리가 용이해진다.

이후 반복문을 통해 각 문자열을 처리하였다.

```java
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("<");
		StringBuilder result = new StringBuilder();
		
		for(String str : input) {
			// 내용
		}
```

일단 “<”이 존재해서 split이 되었다면, 이와 pair인 “>” 또한 존재할 것이다.

따라서 조건문을 통해 “>”를 찾고, 있다면 “>”으로 한 번 더 split하여 result에 추가해주었다.

남은 문자열은 reverse해주어야 하므로 str에 다시 저장하였다.

“>” 이후 문자열이 없을 경우를 대비해 삼항연산자로 예외처리 해주었다.

```java
		for(String str : input) {
			if(str.contains(">")) {
				String[] temp = str.split(">");
				result.append("<"+temp[0]+">");
				str = temp.length>1? temp[1] : "";
			}
		}
```

if문을 나온 경우 이는 `tag` 없는 단어로만 이루어진 문자열이므로 이제 공백으로 split() 후 각각의 문자열을 reverse하여 result에 추가하면 된다.

```java
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
```

# 소스 코드


최종 코드는 다음과 같다.

```java
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
```

# 결과


제출 결과는 다음과 같다.

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9ed31030-f158-4bc3-b213-3819dbecef17/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220801%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220801T142316Z&X-Amz-Expires=86400&X-Amz-Signature=6a9d4e7cfe0a7e83e4629a97e5af55eecce831ad74e41881b384f929eb3d1451&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

# 고찰


생각해보니 각 문자열을 stack을 이용하는 방법도 충분히 해볼만한 것 같다.

그래서 해봤다.

```java
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
```

**“<”**를 만난 경우, 일단 stack에 있던 값(단어)를 pop해 result에 넣는다.

이후 “>”를 만날 때까지 순서대로 result에 넣는다.

**공백**을 만난 경우, stack에 있던 값을 pop해 result에 넣고 공백을 삽입한다.

이외의 경우 그냥 단어 내 문자이므로 stack에 삽입한다.

반복문을 나온 후에는 stack에 문자열이 있다면 이를 pop해 result에 넣고, result를 출력하면 됐다!

제출결과는 다음과 같았다.

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/90fd6c76-a776-4b27-8e62-2081f6980210/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220801%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220801T142302Z&X-Amz-Expires=86400&X-Amz-Signature=708b05250667185c2e534675413a1861502fd94c596c3629e03ad493a219f084&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

놀랍게도 별로 달라진 건 없으면서 공간복잡도만 올라갔다! 아무튼 이런 식으로 stack을 활용해서도 풀어보았다.
