package _mall;

import controller.MallController;

public class _Main {
	public static void main(String[] args) {
		MallController mallCont = MallController.getInstance();
		mallCont.init();
		mallCont.setNextMenu("AdminFileLoad");
		mallCont.changeMenu();
		mallCont.setNextMenu("MallMain");
		while(mallCont.changeMenu());
	}
}
