/*
 * Ű���� �����͸� �о�鿩��(=���� ���)
 * �ַܼ� ����ϴ� ������ �ۼ�
 * ::
 * Source --- Ű����
 * Sink --- �ܼ�
 * ::
 * 1. ��Ʈ�� ���� : �Է� ��Ʈ���� �ʿ�... �ַܼ� ����ϹǷ� ��� ��Ʈ�� �� �ʿ�
 *    InputStreamReader, BufferedReader
 * 2. �о���δ�...
 *    read() ���� readLine()���� ����
 * 3. �ַܼ� ���
 *    System.out.println()
 */
package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//�������� �� �Է��ϸ� �о�帮�� �����
public class KeyboardInputTest1 {

	public static void main(String[] args) {
		//1.
		System.out.println("1. Stream ����.....");
		InputStreamReader ir = new InputStreamReader(System.in); // Ű����� ����
		BufferedReader br = new BufferedReader(ir); // InputStreamReader�� ����
		
		//2.
		try {
			System.out.println("2. readLine()���� �о�帳�ϴ�.....");
			String line = br.readLine(); // ���� �о ����. ����ó�� ����� ��.
			while(line!=null) { //�о���� �����Ͱ� �ִٸ�
				//3.
				System.out.println("Reading Data : "+line);
				line=br.readLine(); // �� �κ��� �־�� �ݺ��Ѵ�.
			}
		}catch(IOException e) {

		}finally {
			try {
				br.close(); // 1���� ������ �ڿ��� ����.
			}catch(IOException e) {
				
			}
		}

	}

}
