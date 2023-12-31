package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	private static Scanner sc = new Scanner(System.in);

	// 숫자 입력 받기 - 예외 처리
	public static int getValue(String msg, int start, int end) {
		System.out.print(msg + "(%d ~ %d) : ".formatted(start, end));
		int sel = -1;
		try {
			sel = sc.nextInt();
			if (sel < start || sel > end) {
				System.out.println(start + " ~ " + end + " 값 입력해주세요");
				return -1;
			}
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력해 주세요");
		}
		sc.nextLine();
		return sel;
	}

	// 띄어쓰기 비허용
	public static String getValue(String msg) {
		System.out.print(msg);
		return sc.next();
	}

	// 띄어쓰기 허용
	public static String strValue(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	// 스캐너 닫기
	public static void ScannerClose() {
		sc.close();
	}
}
