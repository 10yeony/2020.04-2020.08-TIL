package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 키보드로 읽어들인 데이터를
 * 콘솔로 출력하는 로직을 작성
 */
public class KeyboardInputTest2 {
// 키보드로 데이터 계속 입력할 수 있는데 고마해라 입력하면 입력 끝남.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("키보드로 데이터를 입력하세요... \n");

		String line = "";
		try {
			while((line = br.readLine()) != null){
				if(line.equals("고마해라")) {
					System.out.println("입력금지... 종료합니다...");
					break;
				}else {
					System.out.println("Reading Data : " +line);
				}
			}
		}finally {
			br.close();
		}
	}

}
