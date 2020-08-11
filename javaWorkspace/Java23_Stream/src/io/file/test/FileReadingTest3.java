/*
 * Source --- ����
 * Sink --- �ܼ�
 * ::
 * ���Ͽ� �ִ� ������ �о
 * �ַܼ� ����ϴ� ������ �ۼ�
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
		// ������ ��� src\\data\\result.txt ���� ����.
		// ��� data��� ������ �־�� ��. ������ ��� ������ ����������� ��δ� ��Ȯ�ؾ� ��.
		
		try {
			String line = "";
			while((line = br.readLine()) != null) {
				bw.write(line);// ���پ� ������ ���پ� �ѷ��� ��.
				bw.newLine(); // BufferedWriter�� ���Ͱ� ��� �̰� �־���� ��.
				// ���� �����͸� ����� ���� ��Ʈ���� �����͸� �о���̴� ���� �ٷιٷ� ������� ����.
				// �׷� �� ����ҿ� �������� �����͸� ��Ƶ״ٰ� �Ѳ����� �����. ���� �������� ����!
			}
			//bw.flush(); // �ԷµǴ� ���� ��Ƶ��� �ʰ� �ٷιٷ� �ѷ��ִ� ��.
			// autoflush ���... ���ڵ����� ����� ���� �̷� ������ �־ flush����� ��.
		}finally {
			br.close();
			bw.close(); // �ڿ� �� ���� �ݴµ� ���� �� �ȿ� �ִ� �� �� �������� ����. 
			// �׷��� bw.close() ���ָ� bw.flush() �� ���൵ ��µ�.
		}
	}

}
