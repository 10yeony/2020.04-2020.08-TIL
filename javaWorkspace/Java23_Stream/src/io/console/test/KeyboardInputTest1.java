/*
 * 키모드로 데이터를 읽어들여서(=문자 기반)
 * 콘솔로 출력하는 로직을 작성
 * ::
 * Source --- 키보드
 * Sink --- 콘솔
 * ::
 * 1. 스트림 생성 : 입력 스트림만 필요... 콘솔로 출력하므로 출력 스트림 안 필요
 *    InputStreamReader, BufferedReader
 * 2. 읽어들인다...
 *    read() 말고 readLine()으로 읽음
 * 3. 콘솔로 출력
 *    System.out.println()
 */
package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//실행했을 때 입력하면 읽어드리고 출력함
public class KeyboardInputTest1 {

	public static void main(String[] args) {
		//1.
		System.out.println("1. Stream 생성.....");
		InputStreamReader ir = new InputStreamReader(System.in); // 키보드와 연결
		BufferedReader br = new BufferedReader(ir); // InputStreamReader와 연결
		
		//2.
		try {
			System.out.println("2. readLine()으로 읽어드립니다.....");
			String line = br.readLine(); // 한즐씩 읽어서 받음. 예외처리 해줘야 함.
			while(line!=null) { //읽어들인 데이터가 있다면
				//3.
				System.out.println("Reading Data : "+line);
				line=br.readLine(); // 이 부분이 있어야 반복한다.
			}
		}catch(IOException e) {

		}finally {
			try {
				br.close(); // 1에서 열어준 자원을 닫음.
			}catch(IOException e) {
				
			}
		}

	}

}
