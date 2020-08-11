/*
 * Source --- 파일
 * Sink --- 콘솔
 * ::
 * 파일에 있는 내용을 읽어서
 * 콘솔로 출력하는 로직을 작성
 * ::
 * 
 */
package io.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadingTest3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src\\data\\result.txt"));
		// 파일이 없어도 src\\data\\result.txt 새로 생김.
		// 대신 data라는 폴더가 있어야 함. 파일은 없어도 저절로 만들어지지만 경로는 정확해야 함.
		
		try {
			String line = "";
			while((line = br.readLine()) != null) {
				bw.write(line);// 한줄씩 읽으면 한줄씩 뿌려야 함.
				bw.newLine(); // BufferedWriter에 엔터가 없어서 이거 넣어줘야 함.
				// 문자 데이터를 출력할 때는 스트림이 데이터를 읽어들이는 족족 바로바로 출력하지 않음.
				// 그럴 때 저장소에 일정량의 데이터를 모아뒀다가 한꺼번에 출력함. 문자 데이터일 때만!
			}
			//bw.flush(); // 입력되는 족족 모아두지 않고 바로바로 뿌려주는 것.
			// autoflush 기능... 문자데이터 출력일 때만 이런 성질이 있어서 flush해줘야 함.
		}finally {
			br.close();
			bw.close(); // 자원 다 쓰고 닫는데 닫을 때 안에 있는 거 다 내보내고 닫음. 
			// 그래서 bw.close() 해주면 bw.flush() 안 해줘도 출력됨.
		}
	}

}
