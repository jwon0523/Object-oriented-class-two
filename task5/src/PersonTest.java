import hw.person.Person;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("이재원", 24, "남");
		Person p2 = new Person("김한성", 22, "남");
		
		p1.show();
		
		p2.aging();
		
		p2.show();
	}

}
