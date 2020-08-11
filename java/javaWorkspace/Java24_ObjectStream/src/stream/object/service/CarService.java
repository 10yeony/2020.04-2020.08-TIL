package stream.object.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import stream.object.vo.Car;

/*
 * ����ȭ / ������ȭ ����� ��� �� ��ڴ�.
 * Car�� ������ ������ ������ ���� �� �ִ�.
 * �Ѱ��� �־ ��°�� ������. ArrayList!
 */
public class CarService {
	//����ȭ ���... (������)
	public void outputCar(ArrayList<Car> list, String path) throws Exception{
		// ArrayList�� �޾Ƽ� ���Ϸ� ���� ��.
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		
		oos.writeObject(list); // ����
		oos.close();
	}
	
	//������ȭ ���... (�о ����. �޾Ƽ� ����)
	public ArrayList<Car> inputCar(String path) throws Exception{
		ArrayList<Car> list = null;
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		list = (ArrayList<Car>)ois.readObject();
		
		return list;
	}
}
