package self.test;

import self.MyDate;
import self.NoteBook;
import self.Programmer;

public class Test {

	public static void main(String[] args) {
		Programmer person1 = new Programmer("Diana", 500, "Java", new MyDate(1990, 10, 22));
		System.out.println("===========Programmer Info========");
		System.out.println(person1.getProgrammer());
		
		System.out.println(" ");
		System.out.println(person1.getName()+" ���� ������ ��Ʈ��");
		
		person1.buyNoteBook(new NoteBook("Gram", 1700000));
		
		NoteBook dianaNoteBook = person1.getNoteBook();
		System.out.println(person1.getNoteBook());
	}

}
