package io.file.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Byte계열 스트림...
 * 바이너리 데이터(이미지 파일)를 읽어서
 * 파일로 출력하는 로직을 작성.
 * ::
 * 입력(2개) | 출력(2개)
 * DataInputStream(FileInputStream)
 * DataOuputStream(FileOutputStream)
 */
public class DataInputStreamTest {
	public static void main(String[] args) {
		String fileName = "src/watermelon.png"; // 파일명
		String outfileName = "src/water.png";
		// 문자 기반 아니라서 autoflush 이딴 거 필요 없음.
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			dos = new DataOutputStream(new FileOutputStream(outfileName));
			
			int data = 0; 
			while((data=dis.readInt()) != -1) { // 파일의 끝이 -1. 
				// 스트링일 때는 null로 비교하는데 바이너리 데이터일 때는 -1로 비교함.
				// 아무런 내용도 없어도 -1...
				dos.writeInt(data);
			}
		}catch(EOFException e){ // 주의. 파일의 끝을 만날 때 생기는 예외.
			
		}catch(IOException e){
			
		}
	}

}
