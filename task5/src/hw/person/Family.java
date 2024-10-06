package hw.person;

public class Family {
	private Person huband, wife, child1, child2;
	private String familyMotto;
	
	public Family(Person husband, Person wife) {
		this.huband = husband;
		this.wife = wife;
		
	}
	
	public void addChild(String name, int age, String gender) {
		if(child1 == null) {
			child1 = new Person(name, age, gender);
		} else if(child2 == null) {
			child2 = new Person(name, age, gender);
		} else {
			System.out.println("자식은 2명이 최대입니다.");
		}
	}
	
	public void setMotto(String motto) {
		this.familyMotto = motto;
	}
	
	public String getMotto() {
		return familyMotto;
	}
	
	public void showFamily() {
		System.out.println("<가족정보>");
		
		if(getMotto() != null) {
			System.out.println("가훈: " + getMotto());
		}
		System.out.println("==== 아빠정보 ====");
		huband.show();
		System.out.println("==== 엄마정보 ====");
		wife.show();
		if(child1 != null) {
			System.out.println("==== 자녀1 정보 ====");
			child1.show();
		}
		if(child2 != null) {
			System.out.println("==== 자녀2 정보 ====");
			child2.show();
		}
	}

}
