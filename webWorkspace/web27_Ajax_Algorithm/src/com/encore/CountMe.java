package com.encore;

import java.util.Arrays;

public class CountMe {

	public String execute(String book) {
		String word = "";
		String str = book.toLowerCase(); //문자열을 소문자로 변경
		String[] arr = str.split(" "); //" "을 기준으로 잘라서 String 배열로 변경
		Arrays.sort(arr);//오름차순으로 정렬
		int[] count = new int[arr.length]; //출연 횟수
		boolean[] visited = new boolean[arr.length]; //방문 여부
		int max = 0; //최댓값
		for(int i=0; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				if(visited[j]==true) continue;
				if(arr[i].equals(arr[j])) {
					count[i] += 1;
					visited[j] = true;
				}
			}
		}
		for(int i=arr.length-1; i>=0; i--) {
			if(max <= count[i]) {
				max = count[i];
				word = arr[i];
			}
		}
		return word;
	}

	public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		CountMe c = new CountMe();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
