package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	private static Scanner sc = new Scanner(System.in);

	public static int getValue(String msg, int start, int end){
		System.out.print(msg  +"(%d ~ %d) : ".formatted(start,end));
		int sel = -1;
		try {
			sel = sc.nextInt();				
			if (sel < start || sel > end) {
				System.out.println(start + " ~ " + end + " 값 입력해주세요");
				return -1;
			}
		}catch (InputMismatchException  e) {
			System.out.println("숫자를 입력해 주세요");
		}
		sc.nextLine();
		return sel;
	}
}
