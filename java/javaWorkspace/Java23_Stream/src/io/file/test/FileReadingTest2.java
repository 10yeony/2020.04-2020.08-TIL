/*
 * Source --- ����
 * Sink --- ����
 * ::
 * ���Ͽ� �ִ� ������ �о
 * �� �ٸ� ���Ϸ� ����ϴ� ������ �ۼ�
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
		// ������ ��� src\\data\\result.txt ���� ����.
		// ��� data��� ������ �־�� ��. ������ ��� ������ ����������� ��δ� ��Ȯ�ؾ� ��.
		
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
