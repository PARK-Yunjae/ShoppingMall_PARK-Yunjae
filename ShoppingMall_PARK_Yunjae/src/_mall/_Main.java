package _mall;

import controller.MallController;

public class _Main {
	public static void main(String[] args) {
		MallController mallCont = MallController.getInstance();
		mallCont.init();
		
		while(mallCont.changeMenu());
	}
}