package fly;
// �Ϻ��� �߻�ȭ... ������ ���� �ϳ��� ����� �������̽��̴�.
// �������̽� ������� = �߻� �޼ҵ� + ���
public interface Flyer {
	public static final int SIZE = 100; // �������̽��� �ʵ尡 ������ ����� ���� �� �ִ�.
	// ������ �Ͱ� ���õ� ����� Template�� ����...
	public abstract void fly();
	public void land(); // ������ �տ� public abstract�� �����ȴ�.
	void take_off(); // ���� ���� �� ����.
}
