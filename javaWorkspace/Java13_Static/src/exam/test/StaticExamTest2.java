package exam.test;
//�ʵ�� static ������ ��� �ٸ����� Ȯ���ϰ� ����...
//static ������ ������ ��ü���� ���� �����Ѵ�...!!! �ǹ̸� ��Ȯ�ϰ� ����.
// ��ü�� �ƹ��� ���� ��������� static ������ �Բ� ������.
// ��ü���� ���ϴ� ��(�̸�, ����, �ּ�)�� �ʵ�� ���, 
// ���� �ٸ� ��ü���� �����ؾ� �ϴ� ���� static���� ��ƾ� ��. 
// static�� ���ϴ� �� �ƴ϶� �׻� ���� ���� ��� ��. ���� ����� ��.

// ī�尡 ������ ����(���̾�,��Ʈ,Ŭ�ι�..), ī��ѹ��� �� �ٸ��� �ʵ�� ���������
// width, height, �� ������ �������� ���̹Ƿ� �����ϰ� ���� static ������ ��´�.

class Car{
	// serialNumber�� counter�� ����� ��ġ�� �ʵ� ����.
	// static�� ������ ���� ������ �� ��.
	int serialNumber;
	static int counter; 
	// static�� ������ Ŭ������ �ı��� �ƴ�. ���� �ʵ尡 �ƴ�.
	// �׳� �������� global�� ����.
	
	Car(){//������
		counter++;//1
		serialNumber = counter;
	}
	
}

public class StaticExamTest2 {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("========= field ============");
		System.out.println(car1.serialNumber);
		System.out.println(car2.serialNumber);
		System.out.println(car3.serialNumber);
		
		System.out.println("\n=======Static V==========");
		System.out.println(Car.counter);
		System.out.println(car1.counter); 
		System.out.println(car2.counter);
		System.out.println(car3.counter);
		// System.out.println(car4.counter); // �������� ��ü �����ؼ� ���������� �� �� �ִ� ��.

	}

}
