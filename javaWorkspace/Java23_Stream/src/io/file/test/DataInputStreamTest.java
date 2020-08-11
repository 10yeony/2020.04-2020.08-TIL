package io.file.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Byte�迭 ��Ʈ��...
 * ���̳ʸ� ������(�̹��� ����)�� �о
 * ���Ϸ� ����ϴ� ������ �ۼ�.
 * ::
 * �Է�(2��) | ���(2��)
 * DataInputStream(FileInputStream)
 * DataOuputStream(FileOutputStream)
 */
public class DataInputStreamTest {
	public static void main(String[] args) {
		String fileName = "src/watermelon.png"; // ���ϸ�
		String outfileName = "src/water.png";
		// ���� ��� �ƴ϶� autoflush �̵� �� �ʿ� ����.
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			dos = new DataOutputStream(new FileOutputStream(outfileName));
			
			int data = 0; 
			while((data=dis.readInt()) != -1) { // ������ ���� -1. 
				// ��Ʈ���� ���� null�� ���ϴµ� ���̳ʸ� �������� ���� -1�� ����.
				// �ƹ��� ���뵵 ��� -1...
				dos.writeInt(data);
			}
		}catch(EOFException e){ // ����. ������ ���� ���� �� ����� ����.
			
		}catch(IOException e){
			
		}
	}

}
