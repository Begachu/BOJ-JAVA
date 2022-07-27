# 문제 설명

문제 링크는 [여기](https://www.acmicpc.net/problem/1181)를 눌러주세요!

---

주어진 N개의 문자열을 아래의 우선순위 조건으로 정렬하는 문제이다.

> 길이가 짧은 것부터길이가 같으면 사전 순으로
> 
> - 이때 각 문자열은 중복되어 들어올 수 있으며, 이 경우 중복을 제거하여 출력

문자열에 대한 정렬 문제로, 오늘 학습한 **자료구조** 및 **정렬**, **람다식**을 활용하기 딱 좋은 문제라는 생각이 들었다.

# 접근

문자열 정렬 이전에 고려해야할 것은 **중복 제거**였다.
이는 요소의 중복을 허용하지 않는 **Set**자료 구조를 활용하여 해결하였다.

Set은 같은 내용의 요소를 add하였을 때 알아서 중복을 제거해준다. 따라서 이를 활용하면 굳이 중복을 체크할 필요가 없다.

```java
	// 자동으로 중복을 제거할 수 있도록 set 사용
	HashSet<String> hSet = new HashSet<>();

	// 입력을 모두 set에 담는다
	for(int n=0; n<N; n++) hSet.add(br.readLine());

```

이제 중복문제는 해결하였다. 정렬문제를 생각해보자!

---

**Set은 정렬을 지원하지 않는다.** 따라서 Set만으로는 문제해결을 할 수 없었다. 따라서 Set 데이터를 정렬이 가능한 **List** 형태로 변환하였다.

```java
	// 정렬을 수행해야하지만, set은 정렬이 안되므로 list로 변경
	List<String> list = new ArrayList<>(hSet);

```

---

위에서 언급한 정렬 조건을 다시 가져오면 다음과 같다.

> 길이가 짧은 것부터길이가 같으면 사전 순으로
> 

두 정렬 조건을 만족하게 한 번에 정렬하는 방법은 떠올리지 못했다.
따라서 단순히 **각각의 조건에 맞는 정렬**을 수행하여 요구사항을 만족시키고자 한다.

이때 우선순위 순으로 정렬을 진행하게 되면, 결과적으로는 우선순위의 역순으로 정렬한 꼴이 되어버린다... 따라서 우선순위의 역순으로 정렬을 해야 한다.

```java
	// 우선순위가 낮은 정렬 규칙부터 적용해간다
	Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
	Collections.sort(list, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

```

이후에 이제 정렬된 list의 요소를 순서대로 출력하면 끝난다!

# 소스코드

최종 코드는 다음과 같다.

```java
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
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

		for(String str : list)	bw.append(str+"\\n");
		bw.flush();
		br.close();
		bw.close();
	}
}

```

~~나도 JAVA 멋쟁이가 되고 싶어서 빠른 입출력을 써봤다ㅎㅎ~~

# 결과

제출결과는 다음과 같았다.

![https://velog.velcdn.com/images/begachu/post/e7d9718c-3d8f-457c-ae73-35d12c788d65/image.png](https://velog.velcdn.com/images/begachu/post/e7d9718c-3d8f-457c-ae73-35d12c788d65/image.png)

# 고찰

생각해보니 List<String>에 대한 Collections.sort()는 사전순 정렬이므로 아래와 같이 고칠 수 있었다.

```
	// 우선순위가 낮은 정렬 규칙부터 적용해간다
	//Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
  Collections.sort(list);
  Collections.sort(list, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

```

수정한 코드의 제출결과는 다음과 같았다.

![https://velog.velcdn.com/images/begachu/post/697550be-2bef-4f52-a97d-dd37060d7888/image.png](https://velog.velcdn.com/images/begachu/post/697550be-2bef-4f52-a97d-dd37060d7888/image.png)

물론 당연하게도 이전 코드와의 결과 차이는 거의 없었다.