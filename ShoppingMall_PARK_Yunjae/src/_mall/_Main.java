package _mall;

import controller.MallController;

public class _Main {
	public static void main(String[] args) {
		MallController mallCont = MallController.getInstance();
		mallCont.init();
		System.out.println(mallCont);
		
		boolean run = true;
		while(true) {
			run = mallCont.setNext("MallMain").update();
			if(run == false) {
				break;
			}
		}
	}
}
