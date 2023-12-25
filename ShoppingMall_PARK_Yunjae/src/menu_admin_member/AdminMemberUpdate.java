package menu_admin_member;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminMemberUpdate implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminMember");
		if(mallCont.getmDAO().getmList().size() == 0) {
			System.out.println("[관리자] 회원이 존재하지 않습니다");
			return false;
		}
		String id = Util.getValue("ID");
		int idIdx = mallCont.getmDAO().idValue(id);
		if (idIdx == -1) {
			System.out.println("[관리자] ID가 존재하지 않습니다");
			return false;
		}
		if(idIdx == 0) {
			System.out.println("[관리자] 관리자는 수정 불가");
			return false;
		}
		String name = Util.getValue("바꿀 이름");
		mallCont.getmDAO().UpdateNickName(name, idIdx);
		System.out.println("[관리자] %d 회원 닉네임 변경 완료".formatted(id));

		return false;
	}

}
