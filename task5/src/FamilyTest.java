import hw.person.Family;
import hw.person.Person;

public class FamilyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Family family = new Family(new Person("김한성", 45, "남"), new Person("이대학", 45, "여"));
		
		family.showFamily();
		
		family.setMotto("행복하게 살자!");
		
		family.addChild("김자바", 22, "남");
		
		family.showFamily();
		
		family.addChild("김오뜨", 18, "여");
		
		family.showFamily();
		
	}

}
