package task8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputInteger {
	static int getInteger() throws InputMismatchException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		return num;
		
	}
	
	public static void main(String[] args) {
		int num;
		while(true) {
			try {
				System.out.print("Input: ");
				num = getInteger();
			} catch(InputMismatchException e) {
				System.out.println("숫자를 다시 입력해 주세요.");
				continue;
			}
			System.out.println("num: " + num);
		}
	}
}
