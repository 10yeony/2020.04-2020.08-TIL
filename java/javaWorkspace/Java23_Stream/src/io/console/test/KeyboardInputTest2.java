package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Ű����� �о���� �����͸�
 * �ַܼ� ����ϴ� ������ �ۼ�
 */
public class KeyboardInputTest2 {
// Ű����� ������ ��� �Է��� �� �ִµ� ���ض� �Է��ϸ� �Է� ����.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Ű����� �����͸� �Է��ϼ���... \n");

		String line = "";
		try {
			while((line = br.readLine()) != null){
				if(line.equals("���ض�")) {
					System.out.println("�Է±���... �����մϴ�...");
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
