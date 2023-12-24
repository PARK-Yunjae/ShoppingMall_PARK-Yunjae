package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MallLogin implements MenuCommand {
	private MallController mallCont;

	public MallLogin() {
		init();
	}

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MallMain");
		String id = Util.getValue("ID");
		int idIdx = mallCont.getmDAO().idValue(id);
		if (idIdx == -1) {
			System.out.println("ID가 존재하지 않습니다");
			return false;
		}
		String pw = Util.getValue("PW");
		int pwIdx = mallCont.getmDAO().pwValue(pw);

		if(idIdx != pwIdx) {
			System.out.println("비밀번호가 틀렸습니다");
			return false;
		}
		System.out.println("로그인 성공");
		mallCont.setId(id);
		
		if(idIdx == 0) {
			mallCont.setNextMenu("AdminMain");
		}
		if(idIdx > 0) {
			mallCont.setNextMenu("MemberMain");
		}
		return false;
	}

}
