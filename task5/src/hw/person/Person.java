package hw.person;

public class Person {
	private String name;
	private int age;
	private String gender;
	
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		setGender(gender);
	}
	
	String getName() {
		return name;
	}
	
	int getAge() {
		return age;
	}
	
	String getGender() {
		return gender;
	}
	
	public void aging() {
		age++;
	}
	
	void setGender(String gender) {
		if(gender == "남" || gender == "여") {
			this.gender = gender;
		}
	}
	
	public void show() {
		System.out.println("이름: " + getName());
		System.out.println("나이: " + getAge());
		System.out.println("성별: " + getGender());
		
		System.out.println();
	}
}
