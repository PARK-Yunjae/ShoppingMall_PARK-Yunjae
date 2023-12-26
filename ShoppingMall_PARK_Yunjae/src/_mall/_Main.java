package _mall;

import controller.MallController;

public class _Main {
	public static void main(String[] args) {
		MallController mallCont = MallController.getInstance();
		mallCont.init(); //DAO를 생성 map리스트 추가
		mallCont.setNextMenu("AdminFileLoad"); // 파일 자동 로드
		mallCont.changeMenu(); 					// 로드 실행
		mallCont.setNextMenu("MallMain");
		while(mallCont.changeMenu());
	}
}
