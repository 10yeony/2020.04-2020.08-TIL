/*
 * Source --- 파일
 * Sink --- 파일
 * ::
 * 파일에 있는 내용을 읽어서
 * 또 다른 파일로 출력하는 로직을 작성
 * ::
 * 
 */
package io.file.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadingTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("src\\data\\result.txt", true), true);
		// 파일이 없어도 src\\data\\result.txt 새로 생김.
		// 대신 data라는 폴더가 있어야 함. 파일은 없어도 저절로 만들어지지만 경로는 정확해야 함.
		
		try {
			String line = "";
			while((line = br.readLine()) != null) {
				pw.println(line);
			}
		}finally {
			br.close();
			//pw.close(); 
		}
	}

}
