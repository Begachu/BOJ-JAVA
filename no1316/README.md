# 문제 설명

문제 링크는 [여기](https://www.acmicpc.net/problem/1316)에서 볼 수 있다.

---

**그룹 단어**란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.

> 그룹 단어 예시 : aaaaacccddd, a, asdf, temp, ...
비 그룹 단어 예시 : test, xoxo, asdfa, ...
> 

문제는 입력받은 N개의 문자열에서 그룹 단어의 수를 출력하는 것이다.

# 접근

일단 정답의 최대값은 N이다.
들어온 모든 단어가 그룹 단어인 경우 **최대값이 N**이기 때문이다.
나의 경우 일단 **모든 단어가 그룹 단어라고 가정**하고 진행하고자 아래와 같이 result의 초기값을 설정하였다.

```java
	int T = Integer.parseInt(br.readLine());
	// 일단 모든 단어가 그룹단어라고 가정
	int result = T;

```

---

**그룹 단어는 연속적인 등장을 제외한 알파벳의 재등장이 없어야 한다.**

따라서 나는 26개의 각 알파벳의 등장여부를 체크하는 배열을 만들어 사용하였다.
이와 함께 각 알파벳이 연속적인 등장중인지를 확인하기 위한 변수 lastChar도 선언하였다.

```java
	// 각각의 알파벳 등장여부 check할 배열
	boolean[] cnt = new boolean[26];
	// 가장 최근 등장한 알파벳
	char lastChar = ' ';

```

---

이후 이제 입력받은 문자열의 각 문자에 대해 foreach를 이용한 탐색을 진행하였다.
우선 첫 번째로 **현재 연속적으로 등장하는 문자인지** 확인하였다.
연속 등장인 경우, continue를 통해 다음 문자로 넘어갔다.

연속 등장이 아닌 경우, **문자가 등장한 적이 있는지** 확인하였다.
만약 등장했다면 이 문자열은 그룹 단어가 아니므로 더 이상 문자 탐색이 필요 없다.
따라서 result의 값을 1 차감하고 break를 통해 foreach문을 나왔다.

문자가 등장한 적이 없다면, 일단 해당 문자가 등장한 했음을 체크하였다.
또한 연속적인 등장 여부를 확인하기 위해 lastChar 값을 업데이트하였다.

```java
	for(char c : br.readLine().toCharArray()) {
		// 연속되는 알파벳인가?
		if (lastChar==c) continue;

		// 이미 등장했던 알파벳인가?
		if (cnt[c-'a']) {
			// 그룹단어 아니므로 result - 1
			result--;
			break;
		}
		// 등장여부 check 후 lastChar 업데이트
		cnt[c-'a'] = true;
		lastChar = c;
	}

```

---

마지막으로 result값을 출력하였다. T의 값과 상관없이 숫자 하나만 출력하므로 Sysout을 이용하여 단순 출력하였다.

```java
System.out.println(result);

```

# 소스코드

최종적으로 제출한 코드는 다음과 같다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		// 일단 모든 단어가 그룹단어라고 가정
		int result = T;

		for(int t=0; t<T; t++) {
			// 각각의 알파벳 등장여부 check할 배열
			boolean[] cnt = new boolean[26];
			// 가장 최근 등장한 알파벳
			char lastChar = ' ';

			for(char c : br.readLine().toCharArray()) {
				// 연속되는 알파벳인가?
				if (lastChar==c) continue;

				// 이미 등장했던 알파벳인가?
				if (cnt[c-'a']) {
					// 그룹단어 아니므로 result - 1
					result--;
					break;
				}
				// 등장여부 check 후 lastChar 업데이트
				cnt[c-'a'] = true;
				lastChar = c;
			}
		}

		System.out.println(result);

		br.close();
	}
}

```

# 결과

채점 결과는 다음과 같았다.

![https://velog.velcdn.com/images/begachu/post/40710573-0eaf-4d3b-bc3f-4892f038d93d/image.png](https://velog.velcdn.com/images/begachu/post/40710573-0eaf-4d3b-bc3f-4892f038d93d/image.png)

# 고찰

입력으로 들어오는 문자열이 알파벳 소문자로 한정되어있어서 더 고민없이 풀 수 있었던 것 같다.
처음에 문제를 잘 안읽었을 땐 대소문자 통일하는 방법으로 구현하고자 했는데 그럴 필요 없었다!