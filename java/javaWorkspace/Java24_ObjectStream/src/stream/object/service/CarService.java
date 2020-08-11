package stream.object.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import stream.object.vo.Car;

/*
 * 직렬화 / 역직력화 기능을 모두 다 담겠다.
 * Car를 여러개 던지고 여러개 받을 수 있다.
 * 한곳에 넣어서 통째로 던진다. ArrayList!
 */
public class CarService {
	//직렬화 기능... (날린다)
	public void outputCar(ArrayList<Car> list, String path) throws Exception{
		// ArrayList를 받아서 파일로 던질 것.
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		
		oos.writeObject(list); // 날림
		oos.close();
	}
	
	//역직렬화 기능... (읽어서 본다. 받아서 본다)
	public ArrayList<Car> inputCar(String path) throws Exception{
		ArrayList<Car> list = null;
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		list = (ArrayList<Car>)ois.readObject();
		
		return list;
	}
}
